import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//Question2-Task3

class LoginManagerTest {

    @Mock
    AuthenticationService authenticationService;

    LoginManager loginManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loginManager = new LoginManager(authenticationService);
    }

    @Test
    void testLogin_ValidCredentials() throws Exception {
        String username = "Maria";
        String password = "svt00";

        when(authenticationService.authenticate(username, password)).thenReturn(true);

        boolean result = loginManager.login(username, password);
        assertTrue(result);

        verify(authenticationService).authenticate(username, password);
    }

    @Test
    void testLogin_InvalidCredentials() throws Exception {
        String username = "Fahmi";
        String password = "sth123";

        when(authenticationService.authenticate(username, password)).thenReturn(false);

        boolean result = loginManager.login(username, password);
        assertFalse(result);

        verify(authenticationService).authenticate(username, password);
    }

    @Test
    void testLogin_NullUsername() {
        String password = "svt00";

        assertThrows(Exception.class, () -> loginManager.login(null, password));

        verify(authenticationService, never()).authenticate(anyString(), anyString());
    }

    @Test
    void testLogin_NullPassword() {
        String username = "Maria";

        assertThrows(Exception.class, () -> loginManager.login(username, null));

        verify(authenticationService, never()).authenticate(anyString(), anyString());
    }
}
