import main.java.Card;
import main.java.HandFactory;
import main.java.enums.Nominal;
import main.java.enums.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PokerHandStringParseTest {
    ArrayList<Card> flushHand;
    ArrayList<Card> royalFlushHand;
    ArrayList<Card> fullHouseHand;
    ArrayList<Card> setHand;
    ArrayList<Card> fourKindHand;

    @Test
    public void testParse_correctInput() {
        flushHand = HandFactory.fromString("2S 7S 5S 9S TS");
        Assertions.assertEquals(flushHand.get(0).getSuit(), Suit.S);

        royalFlushHand = HandFactory.fromString("QD KD TD AD JD");
        Assertions.assertEquals(royalFlushHand.get(0).getSuit(), Suit.D);

        fullHouseHand = HandFactory.fromString("AS 2D 2H 2C AC");
        Assertions.assertEquals(fullHouseHand.get(0).getNominal(), Nominal.ACE);

        setHand = HandFactory.fromString("8H QC QH JD QS");
        Assertions.assertEquals(setHand.get(3).getSuit(), Suit.D);

        fourKindHand = HandFactory.fromString("6S 7S 6C 6D 6S");
        Assertions.assertEquals(fourKindHand.get(1).getNominal(), Nominal.SEVEN);
    }

    @Test
    public void testParse_incorrectInput() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, ()
                                                      -> HandFactory.fromString("7S 5S 9S TS"));
        Assertions.assertEquals("Invalid constructor argument", exception.getMessage());
    }
}
