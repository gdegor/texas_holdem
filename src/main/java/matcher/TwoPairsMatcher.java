package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class TwoPairsMatcher extends CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return countPairs(cards) == 2;
    }
}
