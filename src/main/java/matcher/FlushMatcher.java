package main.java.matcher;

import main.java.Card;
import main.java.enums.Suit;

import java.util.ArrayList;
import java.util.HashMap;

public class FlushMatcher extends CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return countSuits(cards).size() == 1;
    }

    protected HashMap<Suit, Integer> countSuits(ArrayList<Card> cards) {
        ArrayList<Suit> suitList =  new ArrayList<>();
        for (Card c : cards) {
            suitList.add(c.getSuit());
        }
        return countIdentical(suitList);
    }
}
