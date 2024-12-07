import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

//Question1-Task9

class BookingServiceTest {

    @Mock
    PaymentService mockPaymentService;

    @InjectMocks
    BookingService bookingService;

    public BookingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessPayment() {
        bookingService.book();
        verify(mockPaymentService).processPayment();
    }
}
