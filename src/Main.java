import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PokerHand> hands = new ArrayList<>();
//        hands.add(new PokerHand("KS 2H 5C JD TD"));
//        hands.add(new PokerHand("2C 3C AC 4C 5C"));
//
//        System.out.println(hands);
//        Collections.sort(hands);

         hands.add(new PokerHand("AS JS QS KS TS")); // ROYAL FLUSH
         hands.add(new PokerHand("2C 3C AC 4C 5C"));  // FLUSH
         hands.add(new PokerHand("6S 7S 8S 9S TS"));  // STRAIGHT FLUSH
         hands.add(new PokerHand("TS 4Q 4S TD 4H")); // FULL HOUSE
         hands.add(new PokerHand("TS 2S 4S 6S AS"));  // FLUSH
         hands.add(new PokerHand("7S 3D 4H 6S 5S")); // STRAIGHT
         hands.add(new PokerHand("7H 7S 7D 7D 7S")); // FOUR
         hands.add(new PokerHand("7H 7S 5D 2D 5S")); // TWO PAIRS
         hands.add(new PokerHand("2H 5S 7D 7D 3S")); // PAIR
        hands.add(new PokerHand("7H 5S 5D 2D 5S")); // SET


//        hands.add(new PokerHand("7S 3D 4H 6S 5S")); // STRAIGHT
//        hands.add(new PokerHand("2H 5S 7D 7D 3S")); // PAIR
//        hands.add(new PokerHand("AS JS QS KS TS")); // ROYAL FLUSH
//        hands.add(new PokerHand("2C 3C AC 4C 5C"));  // FLUSH
//        hands.add(new PokerHand("6S 7S 8S 9S TS"));  // STRAIGHT FLUSH
//        hands.add(new PokerHand("TS 4Q 4S TD 4H")); // FULL HOUSE
//        hands.add(new PokerHand("7H 7S 7D 7D 7S")); // FOUR
//        hands.add(new PokerHand("7H 7S 5D 2D 5S")); // TWO PAIRS

        System.out.println(hands);

//        Collections.sort(hands);
//        System.out.println(hands);
    }
}