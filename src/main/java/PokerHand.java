package main.java;

import main.java.enums.Combination;
import main.java.matcher.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class PokerHand implements Comparable<PokerHand> {
    private final String hand;
    private final ArrayList<Card> cards;
    private final Combination combination;

    public Combination getCombination() {
        return combination;
    }

    public PokerHand(String hand) {
        this.hand = hand;
        cards = HandFactory.fromString(hand);
        combination = rankDetection();
    }

    private Map<Combination, CombinationMatcher> initMatchers() {
        Map<Combination, CombinationMatcher> combinationMatchers = new LinkedHashMap<>();

        combinationMatchers.put(Combination.ROYAL_FLUSH, new RoyalFlushMatcher(cards));
        combinationMatchers.put(Combination.STRAIGHT_FLUSH, new StraightFlushMatcher(cards));
        combinationMatchers.put(Combination.FOUR_OF_KIND, new FourOfKindMatcher(cards));
        combinationMatchers.put(Combination.FULL_HOUSE, new FullHouseMatcher(cards));
        combinationMatchers.put(Combination.FLUSH, new FlushMatcher(cards));
        combinationMatchers.put(Combination.STRAIGHT, new StraightMatcher(cards));
        combinationMatchers.put(Combination.SET, new SetMatcher(cards));
        combinationMatchers.put(Combination.TWO_PAIRS, new TwoPairsMatcher(cards));
        combinationMatchers.put(Combination.PAIR, new PairMatcher(cards));

        return combinationMatchers;
    }

    private Combination rankDetection() {
        Map<Combination, CombinationMatcher> combinationMatchers = initMatchers();
        for (Map.Entry<Combination, CombinationMatcher> entry : combinationMatchers.entrySet()) {
            if (entry.getValue().match(cards)) {
                return entry.getKey();
            }
        }
        return Combination.HIGH_CARD;
    }

    @Override
    public String toString() {
        return "\nPokerHand{" +
                "hand=" + hand +
                ", combo=" + combination +
                '}';
    }

    @Override
    public int compareTo(PokerHand o) {
        return o.combination.ordinal() - this.combination.ordinal();
    }
}
