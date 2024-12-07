import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//Question2-Task4

class OrderServiceTest {

    @Mock
    ShippingService shippingService;

    OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(shippingService);
    }

    @Test
    void testPlaceOrder_ValidShipment() {
        String item = "Chocolate";
        int quantity = 5;

        when(shippingService.ship(item, quantity)).thenReturn(true);

        boolean result = orderService.placeOrder(item, quantity);
        assertTrue(result);

        verify(shippingService).ship(item, quantity);
    }

    @Test
    void testPlaceOrder_InvalidQuantity() {
        String item = "Chocolate";
        int quantity = 0;

        when(shippingService.ship(item, quantity)).thenReturn(false);

        boolean result = orderService.placeOrder(item, quantity);
        assertFalse(result);

        verify(shippingService, never()).ship(item, quantity);
    }
}
