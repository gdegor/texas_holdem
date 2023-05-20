package test;

import main.java.PokerHand;
import main.java.enums.Combination;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class EntityTest {
    protected static void assertEqualsComboForEachHand(Combination expectedAnswer, List<String> inputStrings) {
        for (String inputStr : inputStrings) {
            Assertions.assertEquals(expectedAnswer, new PokerHand(inputStr).getCombination());
        }
    }

    protected static void assertNotEqualsComboForEachHand(Combination expectedAnswer, List<String> inputStrings) {
        for (String inputStr : inputStrings) {
            Assertions.assertNotEquals(expectedAnswer, new PokerHand(inputStr).getCombination());
        }
    }
}
