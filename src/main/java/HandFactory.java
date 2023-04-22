package main.java;

import java.util.ArrayList;
import java.util.List;

public class HandFactory {
    static public ArrayList<Card> fromString(String input) {
        List<String> cardsInHand = List.of(input.split(" "));
        if (cardsInHand.size() != 5) {
            throw new IllegalArgumentException("Invalid constructor argument");
        }

        ArrayList<Card> result = new ArrayList<>();
        for (String card : cardsInHand) {
            result.add(CardFactory.fromString(card));
        }
        return result;
    }
}
