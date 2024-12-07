import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//Question2-Task1

class UserManagerTest {

    @Mock
    UserService userService;

    UserManager userManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userManager = new UserManager(userService);
    }

    @Test
    void testRegisterUser_Success() {
        String username = "Maria";
        String password = "svt00";

        when(userService.usernameExists(username)).thenReturn(false);
        when(userService.saveUser(username, password)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);
        assertTrue(result);

        verify(userService).usernameExists(username);
        verify(userService).saveUser(username, password);
    }

    @Test
    void testRegisterUser_UsernameExists() {
        String username = "existingUser";
        String password = "svt00";

        when(userService.usernameExists(username)).thenReturn(true);

        boolean result = userManager.registerUser(username, password);
        assertFalse(result);

        verify(userService).usernameExists(username);
        verify(userService, never()).saveUser(username, password);
    }
}
