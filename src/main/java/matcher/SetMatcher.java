package main.java.matcher;

import main.java.Card;

import java.util.ArrayList;

public class SetMatcher extends CombinationMatcher {
    public SetMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return countNominals().containsValue(3);
    }
}
