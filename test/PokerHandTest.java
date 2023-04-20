import main.java.Combinations;
import main.java.PokerHand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokerHandTest {
    static void assertEq (Combinations expectedAnswer, List<String> inputStrings) {
        for (String inputStr : inputStrings) {
            Assertions.assertEquals(expectedAnswer, new PokerHand(inputStr).getCombination());
        }
    }

    @Test
    public void testingRoyalFlush() {
        Combinations expectedAnswer = Combinations.ROYAL_FLUSH;
        List<String> inputStrings = Arrays.asList(
                "AS JS QS KS TS",
                "AH QH JH KH TH",
                "QD KD TD AD JD",
                "TC AC KC JC QC"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingStraightFlush() {
        Combinations expectedAnswer = Combinations.STRAIGHT_FLUSH;
        List<String> inputStrings = Arrays.asList(
                "6S 7S 8S 9S TS",
                "9H TH JH QH KH",
                "7D 4D 3D 6D 5D",
                "2C 3C 6C 4C 5C"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingFourOfKind() {
        Combinations expectedAnswer = Combinations.FOUR_OF_KIND;
        List<String> inputStrings = Arrays.asList(
                "6S 7S 6C 6D 6S",
                "8H 8C 8H 8D 8S",
                "2S 2D 2H 2C 5C",
                "AD AH AC AS AD"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingFullHouse() {
        Combinations expectedAnswer = Combinations.FULL_HOUSE;
        List<String> inputStrings = Arrays.asList(
                "6H 6S 2C 6D 2S",
                "8H TC 8H TD 8S",
                "AS 2D 2H 2C AC",
                "JD 4H JC JS 4D"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingFlush() {
        Combinations expectedAnswer = Combinations.FLUSH;
        List<String> inputStrings = Arrays.asList(
                "2S 7S 5S 9S TS",
                "9H 2H JH JH QH",
                "7D AD 5D 5D 5D",
                "2C QC 6C TC 5C"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingStraight() {
        Combinations expectedAnswer = Combinations.STRAIGHT;
        List<String> inputStrings = Arrays.asList(
                "3H 4S 2C 5D 6S",
                "8H TC 9H JD QS",
                "2S 5D 3H 4C 6C",
                "6D 7H 8C 9S TD"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingSet() {
        Combinations expectedAnswer = Combinations.SET;
        List<String> inputStrings = Arrays.asList(
                "3H 3S 2C 5D 3S",
                "8H QC QH JD QS",
                "4S 4D 3H 4C 6C",
                "TD 7H TC 9S TD"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingTwoPairs() {
        Combinations expectedAnswer = Combinations.TWO_PAIRS;
        List<String> inputStrings = Arrays.asList(
                "3H 4S 3C 5D 4S",
                "QH TC JH JD QS",
                "6S 4D 3H 4C 6C",
                "9D TH 8C 9S TD"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingPair() {
        Combinations expectedAnswer = Combinations.PAIR;
        List<String> inputStrings = Arrays.asList(
                "3H AS 3C 5D 4S",
                "QH TC KH JD QS",
                "6S 4D 3H 4C 5C",
                "AD QH 8C AS TD"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingHighCard() {
        Combinations expectedAnswer = Combinations.HIGH_CARD;
        List<String> inputStrings = Arrays.asList(
                "3H AS JC 5D 4S",
                "QH TC KH JD 3S",
                "6S 4D 3H AC 5C",
                "AD QH 8C 2S TD"
        );
        assertEq(expectedAnswer, inputStrings);
    }

    @Test
    public void testingSort() {
        List<PokerHand> expectedHands = new ArrayList<>();
        expectedHands.add(new PokerHand("AS JS QS KS TS"));    //    ROYAL FLUSH
        expectedHands.add(new PokerHand("6S 7S 8S 9S TS"));    //    STRAIGHT FLUSH
        expectedHands.add(new PokerHand("7H 7S 7D 7D 7S"));    //    FOUR OF KIND
        expectedHands.add(new PokerHand("TS 4C 4S TD 4H"));    //    FULL HOUSE
        expectedHands.add(new PokerHand("2C 3C AC 4C 5C"));    //    FLUSH
        expectedHands.add(new PokerHand("7S 3D 4H 6S 5S"));    //    STRAIGHT
        expectedHands.add(new PokerHand("7H 5S 5D 2D 5S"));    //    SET
        expectedHands.add(new PokerHand("7H 7S 5D 2D 5S"));    //    TWO PAIRS
        expectedHands.add(new PokerHand("2H 5S 7D 7D 3S"));    //    PAIR

        List<PokerHand> inputHands = new ArrayList<>();
        inputHands.add(new PokerHand("7S 3D 4H 6S 5S"));    //    STRAIGHT
        inputHands.add(new PokerHand("2H 5S 7D 7D 3S"));    //    PAIR
        inputHands.add(new PokerHand("AS JS QS KS TS"));    //    ROYAL FLUSH
        inputHands.add(new PokerHand("2C 3C AC 4C 5C"));    //    FLUSH
        inputHands.add(new PokerHand("7H 5S 5D 2D 5S"));    //    SET
        inputHands.add(new PokerHand("6S 7S 8S 9S TS"));    //    STRAIGHT FLUSH
        inputHands.add(new PokerHand("TS 4C 4S TD 4H"));    //    FULL HOUSE
        inputHands.add(new PokerHand("7H 7S 7D 7D 7S"));    //    FOUR OF KIND
        inputHands.add(new PokerHand("7H 7S 5D 2D 5S"));    //    TWO PAIRS
        
        Collections.sort(inputHands);

        for (PokerHand inputAns : inputHands) {
            PokerHand expectedAns = expectedHands.get(inputHands.indexOf(inputAns));
            Assertions.assertEquals(inputAns.getCombination(), expectedAns.getCombination());
        }
    }

    @Test
    public void testingDefaultSort() {
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

    @Test
    void wrongInput_shortInputString() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> new PokerHand("AS 2D"));
        Assertions.assertEquals("Invalid constructor argument", exception.getMessage());
    }

    @Test
    void wrongInput_invalidSuit() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> new PokerHand("AH 2D 3D 5X TS"));
        Assertions.assertEquals("Invalid card suit", exception.getMessage());
    }

    @Test
    void wrongInput_invalidNominal() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> new PokerHand("AH BD 3D 5H TS"));
        Assertions.assertEquals("Invalid card nominal", exception.getMessage());
    }
}
