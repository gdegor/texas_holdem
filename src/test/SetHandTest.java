package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SetHandTest extends EntityTest {
    @Test
    public void testSet_correctInput() {
        Combination expectedAnswer = Combination.SET;
        List<String> inputStrings = Arrays.asList(
                "3H 3S 2C 5D 3S",
                "8H QC QH JD QS",
                "4S 4D 3H 4C 6C",
                "TD 7H TC 9S TD"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testSet_incorrectInput() {
        Combination expectedAnswer = Combination.SET;
        List<String> inputStrings = Arrays.asList(
                "2H 3S 2C 5D 3S",
                "5H 5C QH JD QS",
                "4S 8D 3H 4C 6C",
                "TD TH TC 9S TD"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
