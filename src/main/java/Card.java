package main.java;

import main.java.enums.Nominal;
import main.java.enums.Suit;

public class Card {
    private final Nominal nominal;
    private final Suit suit;

    public Card(Nominal nominal, Suit suit) {
        this.nominal = nominal;
        this.suit = suit;
    }

    public Nominal getNominal() { return nominal; }
    public Suit getSuit() { return suit; }

    @Override
    public String toString() {
        return "Card{" +
                "nominal=" + nominal +
                ", suit=" + suit +
                '}';
    }
}
