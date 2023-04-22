package main.java.enums;

public enum Suit {
    S,
    H,
    D,
    C;

    public static Suit findByName(char name) {
        for (Suit suit : values()) {
            if (suit.name().equalsIgnoreCase(String.valueOf(name))) {
                return suit;
            }
        }
        return null;
    }
}
