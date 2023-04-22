package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class PairMatcher extends CombinationMatcher {
    public PairMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return countPairs() == 1;
    }
}
