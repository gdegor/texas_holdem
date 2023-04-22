import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FullHouseHandTest extends EntityTest {
    @Test
    public void testFullHouse_correctInput() {
        Combination expectedAnswer = Combination.FULL_HOUSE;
        List<String> inputStrings = Arrays.asList(
                "6H 6S 2C 6D 2S",
                "8H TC 8H TD 8S",
                "AS 2D 2H 2C AC",
                "JD 4H JC JS 4D"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testFullHouse_incorrectInput() {
        Combination expectedAnswer = Combination.FULL_HOUSE;
        List<String> inputStrings = Arrays.asList(
                "6H 6S 7C 6D 2S",
                "8H TC 8H TD QS",
                "AS 2D 2H 6C AC",
                "TD 4H JC JS 4D"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
