package main.java.matcher;

import main.java.Card;
import main.java.enums.Nominal;
import main.java.enums.Suit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class CombinationMatcher {
    private final ArrayList<Card> cards;

    abstract public boolean match(ArrayList<Card> cards);

    protected CombinationMatcher(ArrayList<Card> cards) {
        this.cards = cards;
    }

    protected boolean isStraight() {
        ArrayList<Nominal> sortedNominals = getSortedNominals();
        for (int i = 0; i < sortedNominals.size() - 1; i++) {
            if (sortedNominals.get(i + 1).ordinal() - sortedNominals.get(i).ordinal() != 1) return false;
        }
        return true;
    }

    private ArrayList<Nominal> getSortedNominals() {
        ArrayList<Nominal> sortedNominals = new ArrayList<>();
        for (Card card : cards) {
            sortedNominals.add(card.getNominal());
        }
        sortedNominals.sort(Comparator.comparingInt(Enum::ordinal));
        return sortedNominals;
    }

    protected boolean isFlush() {
        return countSuits().size() == 1;
    }

    protected int countPairs() {
        int res = 0;
        for (Map.Entry<Nominal, Integer> entry : countNominals().entrySet()) {
            if (entry.getValue() == 2) res++;
        }
        return res;
    }

    protected Nominal highestNominal() {
        ArrayList<Nominal> sortedNominals = getSortedNominals();
        return sortedNominals.get(sortedNominals.size() - 1);
    }

    protected HashMap<Nominal, Integer> countNominals() {
        ArrayList<Nominal> nominalList =  new ArrayList<>();
        for (Card c : cards) {
            nominalList.add(c.getNominal());
        }
        return countIdentical(nominalList);
    }

    protected HashMap<Suit, Integer> countSuits() {
        ArrayList<Suit> suitList =  new ArrayList<>();
        for (Card c : cards) {
            suitList.add(c.getSuit());
        }
        return countIdentical(suitList);
    }

    private <T> HashMap<T, Integer> countIdentical(ArrayList<T> list) {
        HashMap<T, Integer> countMap =  new HashMap<>();
        for (T c : list) {
            int count = countMap.containsKey(c) ? countMap.get(c) + 1 : 1;
            countMap.put(c, count);
        }
        if (list.get(0).getClass().equals(Nominal.class) && countMap.containsValue(5)) {
            throw new RuntimeException("5 cards with the same nominal");
        }
        return countMap;
    }
}
