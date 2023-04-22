package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class StraightMatcher extends CombinationMatcher {
    public StraightMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return isStraight();
    }
}
