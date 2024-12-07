import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    //Question1-Task2
    @Test
    void testNullValues() {
        String result = null;
        assertNull(result, "Null result");
        result = "Not Null";
        assertNotNull(result, "Result not null");
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 equals to 5");
        assertNotEquals(6, calculator.add(2, 3), "2 + 3 does not equals to 6");
    }

    @Test
    void testLogicalAssertions() {
        int sum = calculator.add(2, 3);
        int divide = calculator.divide(6, 3);

        assertTrue(sum > 0, "Positive sum");
        assertFalse(sum < 0, "Negative sum");

        assertTrue(divide == 2, "6 / 3 equals to 2");
        assertFalse(divide != 2, "6 / 3 does not unequals to 2");
    }

    //Question1-Task3
    @Test
    void testDivide() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0), "Invalid division");
        assertDoesNotThrow(() -> calculator.divide(4, 2), "Valid division");
    }

    //Question1-Task4
    @Test
    void testArrayEquality() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "Expected equal actual");
    }

    @Test
    void testObjectSame() {
        String str1 = "Hello";
        String str2 = "Hello";
        assertSame(str1, str2, "str1 and str2 is same");
    }

    @Test
    void testLinesMatch() {
        List<String> expected = List.of("SVT", "Assignment");
        List<String> actual = List.of("SVT", "Assignment");
        assertLinesMatch(expected, actual, "Matching");
    }

    //Question1-Task5
    @Test
    void testExecutionTime() {
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(300);
        }, "Executed within time");
    }

    //Question1-Task6
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "0, 5, 5",
            "-1, -2, -3"
    })
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), String.format("%d + %d equals to %d", a, b, expected));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData.csv", numLinesToSkip = 1)
    void testAddFromCsv(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), String.format("%d + %d equals to %d", a, b, expected));
    }
}
