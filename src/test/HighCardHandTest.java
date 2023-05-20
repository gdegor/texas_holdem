package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HighCardHandTest extends EntityTest {
    @Test
    public void testHighCard() {
        Combination expectedAnswer = Combination.HIGH_CARD;
        List<String> inputStrings = Arrays.asList(
                "3H AS JC 5D 4S",
                "QH TC KH JD 3S",
                "6S 4D 3H AC 5C",
                "AD QH 8C 2S TD"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
