import main.java.PokerHand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerHandComparatorTest {
    @Test
    public void testSort() {
        List<PokerHand> expectedHands = new ArrayList<>();
        expectedHands.add(new PokerHand("AS JS QS KS TS"));    //    ROYAL FLUSH
        expectedHands.add(new PokerHand("6S 7S 8S 9S TS"));    //    STRAIGHT FLUSH
        expectedHands.add(new PokerHand("7H 5S 7D 7D 7S"));    //    FOUR OF KIND
        expectedHands.add(new PokerHand("TS 4C 4S TD 4H"));    //    FULL HOUSE
        expectedHands.add(new PokerHand("2C 3C AC 4C 5C"));    //    FLUSH
        expectedHands.add(new PokerHand("7S 3D 4H 6S 5S"));    //    STRAIGHT
        expectedHands.add(new PokerHand("7H 5S 5D 2D 5S"));    //    SET
        expectedHands.add(new PokerHand("7H 7S 5D 2D 5S"));    //    TWO PAIRS
        expectedHands.add(new PokerHand("2H 5S 7D 7D 3S"));    //    PAIR

        List<PokerHand> inputHands = new ArrayList<>();
        inputHands.add(new PokerHand("7S 3D 4H 6S 5S"));       //    STRAIGHT
        inputHands.add(new PokerHand("2H 5S 7D 7D 3S"));       //    PAIR
        inputHands.add(new PokerHand("AS JS QS KS TS"));       //    ROYAL FLUSH
        inputHands.add(new PokerHand("2C 3C AC 4C 5C"));       //    FLUSH
        inputHands.add(new PokerHand("7H 5S 5D 2D 5S"));       //    SET
        inputHands.add(new PokerHand("6S 7S 8S 9S TS"));       //    STRAIGHT FLUSH
        inputHands.add(new PokerHand("TS 4C 4S TD 4H"));       //    FULL HOUSE
        inputHands.add(new PokerHand("7H 5S 7D 7D 7S"));       //    FOUR OF KIND
        inputHands.add(new PokerHand("7H 7S 5D 2D 5S"));       //    TWO PAIRS

        for (PokerHand inputAns : inputHands) {
            PokerHand expectedAns = expectedHands.get(inputHands.indexOf(inputAns));
            Assertions.assertNotEquals(inputAns.getCombination(), expectedAns.getCombination());
        }

        Collections.sort(inputHands);

        for (PokerHand inputAns : inputHands) {
            PokerHand expectedAns = expectedHands.get(inputHands.indexOf(inputAns));
            Assertions.assertEquals(inputAns.getCombination(), expectedAns.getCombination());
        }
    }

    @Test
    public void testDefaultSort() {
        ArrayList<PokerHand> inputHands = new ArrayList<>();
        inputHands.add(new PokerHand("KS 2H 5C JD TD"));
        inputHands.add(new PokerHand("2C 3C AC 4C 5C"));
        Collections.sort(inputHands);

        List<PokerHand> expectedHands = new ArrayList<>();
        expectedHands.add(new PokerHand("2C 3C AC 4C 5C"));    //    FLUSH
        expectedHands.add(new PokerHand("KS 2H 5C JD TD"));    //    HIGH CARD

        for (PokerHand inputAns : inputHands) {
            PokerHand expectedAns = expectedHands.get(inputHands.indexOf(inputAns));
            Assertions.assertEquals(inputAns.getCombination(), expectedAns.getCombination());
        }
    }
}
