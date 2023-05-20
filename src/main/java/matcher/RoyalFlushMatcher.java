package main.java.matcher;

import main.java.Card;
import main.java.enums.Nominal;

import java.util.ArrayList;

public class RoyalFlushMatcher extends StraightFlushMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        ArrayList<Nominal> sortedNominals = getSortedNominals(cards);
        Nominal nominalHighestCard = sortedNominals.get(sortedNominals.size() - 1);
        return super.match(cards) && nominalHighestCard == Nominal.ACE;
    }
}
