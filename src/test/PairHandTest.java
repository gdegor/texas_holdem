package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PairHandTest extends EntityTest {
    @Test
    public void testPair_correctInput() {
        Combination expectedAnswer = Combination.PAIR;
        List<String> inputStrings = Arrays.asList(
                "3H AS 3C 5D 4S",
                "QH TC KH JD QS",
                "6S 4D 3H 4C 5C",
                "AD QH 8C AS TD"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testPair_incorrectInput() {
        Combination expectedAnswer = Combination.PAIR;
        List<String> inputStrings = Arrays.asList(
                "3H 3S 3C 5D 4S",
                "QH QC KH JD QS",
                "6S AD 3H 4C 5C",
                "AD TH 8C AS TD"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
