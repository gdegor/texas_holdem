package main.java;

import main.java.enums.Nominal;
import main.java.enums.Suit;

public class CardFactory {
    public static Card fromString(String card) {
        char tmpNominal = card.charAt(0);
        char tmpSuit = card.charAt(1);
        Nominal nominal;
        Suit suit;
        if (Character.isDigit(tmpNominal)) {
            int num = Character.getNumericValue(tmpNominal);
            if (num < 2 || num > 9) {
                throw new IllegalArgumentException("Invalid card nominal");
            } else {
                nominal = Nominal.values()[num - 2];
            }
        } else {
            switch (tmpNominal) {
                case 'T' -> nominal = Nominal.TEN;
                case 'J' -> nominal = Nominal.JACK;
                case 'Q' -> nominal = Nominal.QUEEN;
                case 'K' -> nominal = Nominal.KING;
                case 'A' -> nominal = Nominal.ACE;
                default -> throw new IllegalArgumentException("Invalid card nominal");
            }
        }
        suit = Suit.findByName(tmpSuit);
        if (suit == null) {
            throw new IllegalArgumentException("Invalid card suit");
        }
        return new Card(nominal, suit);
    }
}
