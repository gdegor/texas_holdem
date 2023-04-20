package main.java;

import java.util.*;

public class PokerHand implements Comparable<PokerHand> {
    public static final List<Character> SUITS = Arrays.asList('S', 'H', 'D', 'C');  //  Spades, Hearts, Diamonds, Clubs
    private final String hand;
    private final ArrayList<Integer> nominals = new ArrayList<>();
    private final ArrayList<Character> suits = new ArrayList<>();

    private final int rank;   //  0..9

    public Combinations getCombination() {
        return Combinations.values()[rank];
    }

    public PokerHand(String hand) {
        this.hand = hand;
        List<String> cardsInHand = List.of(hand.split(" "));
        if (cardsInHand.size() != 5) {
            throw new RuntimeException("Invalid constructor argument");
        }
        separateByNominalsAndSuits(cardsInHand);
        rank = rankDetection();
    }

    private void separateByNominalsAndSuits(List<String> cardsInHand) {
        for (String card : cardsInHand) {
            char tmpChar = card.charAt(0);
            if (Character.isDigit(tmpChar)) {
                int num = Character.getNumericValue(tmpChar);
                if (num < 2 || num > 9) {
                    throw new RuntimeException("Invalid card nominal");
                } else {
                    nominals.add(num);
                }
            } else {
                switch (tmpChar) {
                    case 'T' -> nominals.add(Nominals.TEN.getIndex());
                    case 'J' -> nominals.add(Nominals.JACK.getIndex());
                    case 'Q' -> nominals.add(Nominals.QUEEN.getIndex());
                    case 'K' -> nominals.add(Nominals.KING.getIndex());
                    case 'A' -> nominals.add(Nominals.ACE.getIndex());
                    default -> throw new RuntimeException("Invalid card nominal");
                }
            }
            char suit = card.charAt(1);
            if (SUITS.contains(suit)) {
                suits.add(suit);
            } else {
                throw new RuntimeException("Invalid card suit");
            }
        }
    }

    private <T> HashMap<T, Integer> countingIdentical(ArrayList<T> list) {
        HashMap<T, Integer> countMap =  new HashMap<>();
        for (T c : list) {
            int count = countMap.containsKey(c) ? countMap.get(c) + 1 : 1;
            countMap.put(c, count);
        }
        return countMap;
    }

    private boolean isStraight() {
        ArrayList<Integer> tmpSortedNominals = new ArrayList<>(nominals);
        tmpSortedNominals.sort(Comparator.comparingInt(o -> o));
        for (int i = 0; i < tmpSortedNominals.size() - 1; i++) {
            if (tmpSortedNominals.get(i + 1) - tmpSortedNominals.get(i) != 1) return false;
        }
        return true;
    }

    private boolean isRoyal() {
        for (int i = Nominals.TEN.getIndex(); i <= Nominals.ACE.getIndex(); i++) {
            if (!nominals.contains(i)) break;
            if (i == Nominals.ACE.getIndex()) return true;
        }
        return false;
    }

    private int rankDetection() {
        HashMap<Integer, Integer> countNominals = countingIdentical(nominals);
        HashMap<Character, Integer> countSuits = countingIdentical(suits);

        boolean isStraight = isStraight();
        boolean isFlush = countSuits.get(suits.get(0)) == 5;

        if (isFlush) {
            if (isRoyal()) return Combinations.ROYAL_FLUSH.ordinal();
            if (isStraight) return Combinations.STRAIGHT_FLUSH.ordinal();
        }

        int countPair = 0;
        boolean hasThree = false;
        for (Map.Entry<Integer, Integer> entry : countNominals.entrySet()) {
            switch (entry.getValue()) {
                case 5, 4 -> {
                    return Combinations.FOUR_OF_KIND.ordinal();
                }
                case 3 -> hasThree = true;
                case 2 -> countPair++;
            }
            if (countPair == 1 && hasThree) return Combinations.FULL_HOUSE.ordinal();
        }

        if (isFlush) return Combinations.FLUSH.ordinal();
        else if (isStraight) return Combinations.STRAIGHT.ordinal();
        else if (hasThree) return Combinations.SET.ordinal();
        else if (countPair == 2) return Combinations.TWO_PAIRS.ordinal();
        else if (countPair == 1) return Combinations.PAIR.ordinal();

        return Combinations.HIGH_CARD.ordinal();
    }

    @Override
    public String toString() {
        return "\nPokerHand{" +
                "hand=" + hand +
                ", combo=" + Combinations.values()[rank] +
                '}';
    }

    @Override
    public int compareTo(PokerHand o) {
        return o.rank - this.rank;
    }
}
