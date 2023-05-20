package test;

import main.java.enums.Combination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RoyalFlushHandTest extends EntityTest {
    @Test
    public void testRoyalFlush_correctInput() {
        Combination expectedAnswer = Combination.ROYAL_FLUSH;
        List<String> inputStrings = Arrays.asList(
                "AS JS QS KS TS",
                "AH QH JH KH TH",
                "QD KD TD AD JD",
                "TC AC KC JC QC"
        );
        assertEqualsComboForEachHand(expectedAnswer, inputStrings);
    }

    @Test
    public void testRoyalFlush_incorrectInput() {
        Combination expectedAnswer = Combination.ROYAL_FLUSH;
        List<String> inputStrings = Arrays.asList(
                "AS AS QS KS TS",
                "AH QC JH KH TH",
                "QD KS TD AD JD",
                "TC QC KC JC QC"
        );
        assertNotEqualsComboForEachHand(expectedAnswer, inputStrings);
    }
}
