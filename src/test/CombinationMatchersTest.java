package test;

import main.java.matcher.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombinationMatchersTest extends PokerHandStringParseTest {
    @Test
    public void testCombinationMatchers_correctInput() {
        testParse_correctInput();  //  get list of cards from parse tests
        Assertions.assertTrue(new FlushMatcher().match(flushHand));
        Assertions.assertTrue(new RoyalFlushMatcher().match(royalFlushHand));
        Assertions.assertTrue(new FullHouseMatcher().match(fullHouseHand));
        Assertions.assertTrue(new SetMatcher().match(setHand));
        Assertions.assertTrue(new FourOfKindMatcher().match(fourKindHand));
    }
}
