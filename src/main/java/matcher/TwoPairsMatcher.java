package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class TwoPairsMatcher extends CombinationMatcher {
    public TwoPairsMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return countPairs() == 2;
    }
}
