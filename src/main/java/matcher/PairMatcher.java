package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class PairMatcher extends CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return countPairs(cards) == 1;
    }
}
