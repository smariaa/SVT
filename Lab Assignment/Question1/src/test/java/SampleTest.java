import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//Question1-Task1

class SampleTest {

    @BeforeAll
    static void setupAll() {
        System.out.println("BeforeAll tests.");
    }

    @BeforeEach
    void setupEach() {
        System.out.println("BeforeEach test.");
    }

    @Test
    void testMethodOne() {
        System.out.println("Test method assertTrue.");
        assertTrue(true);
    }

    @Test
    void testMethodTwo() {
        System.out.println("Test method assertEquals.");
        assertEquals(5, 2 + 3);
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach test.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll tests.");
    }
}
