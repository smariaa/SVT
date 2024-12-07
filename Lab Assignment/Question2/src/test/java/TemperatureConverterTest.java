import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

//Question2-Task2

class TemperatureConverterTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/TestData.csv", numLinesToSkip = 1)
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        assertEquals(expectedFahrenheit, TemperatureConverter.celsiusToFahrenheit(celsius), 0.001,
                "Celsius " + celsius + " expected results " + expectedFahrenheit);
    }

    @Test
    void testCelsiusToFahrenheit_BelowAbsoluteZero() {
        assertThrows(IllegalArgumentException.class, () -> TemperatureConverter.celsiusToFahrenheit(-274),
                "Temperature below absolute zero");
    }
}
