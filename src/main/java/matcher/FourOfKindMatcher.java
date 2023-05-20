package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class FourOfKindMatcher extends CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return countNominals(cards).containsValue(4);
    }
}
