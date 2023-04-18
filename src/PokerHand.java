import java.util.*;

public class PokerHand implements Comparable<PokerHand> {
//    private final static ArrayList<Character> NOMINALS =
//            new ArrayList<>(List.of('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
    public static final ArrayList<Character> SUITS = new ArrayList<>(List.of('S', 'H', 'K', 'A'));
//    S(pades), H(earts), D(iamonds), C(lubs)
//    пики      сердца    ромбик      трефы

    private final List<String> cardsInHand;
    private int rank;   //  0..9

    public PokerHand(String hand) {
        cardsInHand = List.of(hand.split(" "));
        rank = rankDetection();
    }

    private int rankDetection() {
        ArrayList<Integer> nominals = new ArrayList<>();
        ArrayList<Character> suits = new ArrayList<>();

        for (String card : cardsInHand) {
            char tmpChar = card.charAt(0);
            int tmpInt = Character.getNumericValue(tmpChar);
            if (tmpInt < 1 || tmpInt > 9) {
                switch (tmpChar) {
                    case 'T' -> nominals.add(Nominals.TEN.getIndex());
                    case 'J' -> nominals.add(Nominals.JACK.getIndex());
                    case 'Q' -> nominals.add(Nominals.QUEEN.getIndex());
                    case 'K' -> nominals.add(Nominals.KING.getIndex());
                    case 'A' -> nominals.add(Nominals.ACE.getIndex());
                }
            } else {
                nominals.add(tmpInt);
            }
            suits.add(card.charAt(1));
        }

        nominals.sort(Comparator.comparingInt(o -> o));

        HashMap<Integer, Integer> countNominals =  new HashMap<>();
        for (Integer c : nominals) {
            int count = countNominals.containsKey(c) ? countNominals.get(c) + 1 : 1;
            countNominals.put(c, count);
        }

        HashMap<Character, Integer> countSuits =  new HashMap<>();
        for (Character c : suits) {
            int count = countSuits.containsKey(c) ? countSuits.get(c) + 1 : 1;
            countSuits.put(c, count);
        }

        if (countSuits.get(suits.get(0)) == 5) {
            for (int x = 0, i = Nominals.TEN.getIndex(); i <= Nominals.ACE.getIndex(); i++) {
                if (nominals.contains(i)) x++;
                if (x == 5) return Combinations.ROYAL_FLUSH.ordinal();
            }

            for (int x = 0; x < nominals.size(); x++) {
                if (x == nominals.size() - 1) return Combinations.STRAIGHT_FLUSH.ordinal();
                if (nominals.get(x + 1) - nominals.get(x) != 1) break;
            }
        }

        System.out.println(nominals);

        int pair = 0;
        boolean set = false;
        for (Map.Entry<Integer, Integer> entry : countNominals.entrySet()) {
            if (entry.getValue() == 4 || entry.getValue() == 5) return Combinations.FOUR_OF_KIND.ordinal();

            if (entry.getValue() == 3) {
                set = true;
            }
            if (entry.getValue() == 2) {
                pair++;
            }

            if (pair == 1 && set) return Combinations.FULL_HOUSE.ordinal();
        }

        if (countSuits.get(suits.get(0)) == 5) return Combinations.FLUSH.ordinal();


        for (int x = 0; x < nominals.size(); x++) {
            if (x == nominals.size() - 1) return Combinations.STRAIGHT.ordinal();
            if (nominals.get(x + 1) - nominals.get(x) != 1) break;
        }

        if (set) return Combinations.SET.ordinal();
        if (pair == 2) return Combinations.TWO_PAIRS.ordinal();
        if (pair == 1) return Combinations.PAIR.ordinal();

        return Combinations.HIGH_CARD.ordinal();
    }

    @Override
    public String toString() {
        return "PokerHand{" +
                "cardsInHand=" + cardsInHand +
                ", rank=" + rank +
                ", combo=" + Combinations.values()[rank] +
                '}';
    }

    @Override
    public int compareTo(PokerHand o) {
        return this.rank - o.rank;
    }
}
