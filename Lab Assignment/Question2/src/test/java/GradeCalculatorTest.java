import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

//Question2-Task5

class GradeCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "55, F"
    })
    void testGetGrade(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score), "Grade matched with score " + score);
    }

    @Test
    void testGetGradeInvalidScore() {
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(-1), "Invalid score");
        assertThrows(IllegalArgumentException.class, () -> GradeCalculator.getGrade(101), "Invalid score");
    }
}
