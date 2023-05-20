package main.java.matcher;

import main.java.Card;
import main.java.enums.Nominal;

import java.util.ArrayList;

public class StraightMatcher extends CombinationMatcher {
    @Override
    public boolean match(ArrayList<Card> cards) {
        return isStraight(cards);
    }

    protected boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Nominal> sortedNominals = getSortedNominals(cards);
        for (int i = 0; i < sortedNominals.size() - 1; i++) {
            if (sortedNominals.get(i + 1).ordinal() - sortedNominals.get(i).ordinal() != 1) return false;
        }
        return true;
    }
}
