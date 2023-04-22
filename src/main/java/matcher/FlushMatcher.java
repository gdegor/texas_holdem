package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class FlushMatcher extends CombinationMatcher {
    public FlushMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return isFlush();
    }
}
