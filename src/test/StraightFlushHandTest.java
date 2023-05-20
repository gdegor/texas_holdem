package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StraightFlushHandTest extends EntityTest {
    @Test
    public void testStraightFlush_correctInput() {
        Combination expectedAnswer = Combination.STRAIGHT_FLUSH;
        List<String> inputStrings = Arrays.asList(
                "6S 7S 8S 9S TS",
                "9H TH JH QH KH",
                "7D 4D 3D 6D 5D",
                "2C 3C 6C 4C 5C"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testStraightFlush_incorrectInput() {
        Combination expectedAnswer = Combination.STRAIGHT_FLUSH;
        List<String> inputStrings = Arrays.asList(
                "6S 7S 8S 9S TD",
                "9H TH JH QC KH",
                "7D 4D 5D 6H 5D",
                "2C 3C 2H 4C 5C"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
