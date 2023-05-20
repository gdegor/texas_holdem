package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class StraightFlushMatcher extends StraightMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return super.match(cards) && new FlushMatcher().match(cards);
    }
}
