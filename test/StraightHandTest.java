import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StraightHandTest extends EntityTest {
    @Test
    public void testStraight_correctInput() {
        Combination expectedAnswer = Combination.STRAIGHT;
        List<String> inputStrings = Arrays.asList(
                "3H 4S 2C 5D 6S",
                "8H TC 9H JD QS",
                "2S 5D 3H 4C 6C",
                "6D 7H 8C 9S TD"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testStraight_incorrectInput() {
        Combination expectedAnswer = Combination.STRAIGHT;
        List<String> inputStrings = Arrays.asList(
                "2H 4S 2C 5D 6S",
                "AH TC 9H JD QS",
                "AS 5D 3H 4C 6C",
                "6D 2D 8C 9S TD"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
