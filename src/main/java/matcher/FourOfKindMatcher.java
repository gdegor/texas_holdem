package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class FourOfKindMatcher extends CombinationMatcher {
    public FourOfKindMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return countNominals().containsValue(4);
    }
}
