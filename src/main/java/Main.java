package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PokerHand> hands = new ArrayList<>();
//        hands.add(new PokerHand("KS 2H 5C JD TD"));
//        hands.add(new PokerHand("2C 3C AC 4C 5C"));


        hands.add(new PokerHand("2S 3H 5C 2D 8D"));
        hands.add(new PokerHand("2S 3H 5C AD AD"));


        Collections.sort(hands);
        System.out.println(hands);
    }

}