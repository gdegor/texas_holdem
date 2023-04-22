import main.java.matcher.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CombinationMatchersTest extends PokerHandStringParseTest {
    @Test
    public void testCombinationMatchers_correctInput() {
        testParse_correctInput();  //  get list of cards from parse tests
        Assertions.assertTrue(new FlushMatcher(flushHand).match(flushHand));
        Assertions.assertTrue(new RoyalFlushMatcher(royalFlushHand).match(royalFlushHand));
        Assertions.assertTrue(new FullHouseMatcher(fullHouseHand).match(fullHouseHand));
        Assertions.assertTrue(new SetMatcher(setHand).match(setHand));
        Assertions.assertTrue(new FourOfKindMatcher(fourKindHand).match(fourKindHand));
    }
}
