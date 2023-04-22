package main.java.matcher;

import main.java.Card;
import main.java.enums.Nominal;

import java.util.ArrayList;

public class RoyalFlushMatcher extends StraightFlushMatcher {
    public RoyalFlushMatcher(ArrayList<Card> cards) {
        super(cards);
    }

    @Override
    public boolean match(ArrayList<Card> cards) {
        return super.match(cards) && highestNominal() == Nominal.ACE;
    }
}
