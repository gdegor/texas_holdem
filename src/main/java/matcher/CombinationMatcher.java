package main.java.matcher;

import main.java.Card;
import main.java.enums.Nominal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public abstract class CombinationMatcher {
    abstract public boolean match(ArrayList<Card> cards);
    protected ArrayList<Nominal> getSortedNominals(ArrayList<Card> cards) {
        ArrayList<Nominal> sortedNominals = new ArrayList<>();
        for (Card card : cards) {
            sortedNominals.add(card.getNominal());
        }
        sortedNominals.sort(Comparator.comparingInt(Enum::ordinal));
        return sortedNominals;
    }

    protected int countPairs(ArrayList<Card> cards) {
        int res = 0;
        for (Map.Entry<Nominal, Integer> entry : countNominals(cards).entrySet()) {
            if (entry.getValue() == 2) res++;
        }
        return res;
    }

    protected HashMap<Nominal, Integer> countNominals(ArrayList<Card> cards) {
        ArrayList<Nominal> nominalList =  new ArrayList<>();
        for (Card c : cards) {
            nominalList.add(c.getNominal());
        }
        return countIdentical(nominalList);
    }

    protected <T> HashMap<T, Integer> countIdentical(ArrayList<T> list) {
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
