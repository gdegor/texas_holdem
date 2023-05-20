package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TwoPairsHandTest extends EntityTest {
    @Test
    public void testTwoPairs() {
        Combination expectedAnswer = Combination.TWO_PAIRS;
        List<String> inputStrings = Arrays.asList(
                "3H 4S 3C 5D 4S",
                "QH TC JH JD QS",
                "6S 4D 3H 4C 6C",
                "9D TH 8C 9S TD"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
