import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

//Question1-Task7

class RandomGeneratorTest {

    RandomGenerator generator = new RandomGenerator();

    @RepeatedTest(5)
    void testRandomNumber() {
        int random = generator.generateRandomNumber();
        assertTrue(random >= 1 && random <= 10, "Any random number from 1-10");
    }
}
