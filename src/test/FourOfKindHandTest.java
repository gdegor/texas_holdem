package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FourOfKindHandTest extends EntityTest {
    @Test
    public void testFourOfKind_correctInput() {
        Combination expectedAnswer = Combination.FOUR_OF_KIND;
        List<String> inputStrings = Arrays.asList(
                "6S 7S 6C 6D 6S",
                "8H 8C 9H 8D 8S",
                "2S 2D 2H 2C 5C",
                "AD AH AC AS QD"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testFourOfKind_incorrectInput() {
        Combination expectedAnswer = Combination.FOUR_OF_KIND;
        List<String> inputStrings = Arrays.asList(
                "3S 6S 2C 6D 6S",
                "8C 3C 9C 8C 8C",
                "2S 2D 3H 2C 5C",
                "AD 2H AC AS QD"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
