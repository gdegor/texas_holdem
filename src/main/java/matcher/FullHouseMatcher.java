package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class FullHouseMatcher extends SetMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return super.match(cards) && countPairs(cards) == 1;
    }
}
