import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//Question1-Task8

class UserServiceTest {

    @Mock
    UserRepository mockRepository;

    @InjectMocks
    UserService userService;

    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindUserById() {
        User mockUser = new User(213-134-006, "Syeda Maria Ahmed");
        when(mockRepository.findById(213-134-006)).thenReturn(mockUser);

        User user = userService.findUserById(213-134-006);
        assertNotNull(user);
        assertEquals("Syeda Maria Ahmed", user.getName());

        verify(mockRepository).findById(213-134-006);
    }
}
