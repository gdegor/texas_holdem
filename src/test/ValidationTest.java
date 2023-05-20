package test;

import main.java.PokerHand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {
    @Test
    void testWrongInput_shortInputString() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new PokerHand("AS 2D"));
        Assertions.assertEquals("Invalid constructor argument", exception.getMessage());
    }

    @Test
    void testWrongInput_invalidSuit() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new PokerHand("AH 2D 3D 5X TS"));
        Assertions.assertEquals("Invalid card suit", exception.getMessage());
    }

    @Test
    void testWrongInput_invalidNominal() {
        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> new PokerHand("AH BD 3D 5H TS"));
        Assertions.assertEquals("Invalid card nominal", exception.getMessage());
    }

    @Test
    void testWrongInput_invalidNominals() {
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> new PokerHand("5H 5D 5D 5H 5S"));
        Assertions.assertEquals("5 cards with the same nominal", exception.getMessage());
    }
}
