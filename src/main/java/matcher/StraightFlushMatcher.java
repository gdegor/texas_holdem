package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class StraightFlushMatcher extends StraightMatcher {
    public StraightFlushMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return super.match(cards) && isFlush();
    }
}
