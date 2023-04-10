package ca.nl.cna.java1.Project;

import java.util.ArrayList;
import java.util.function.DoubleFunction;

public class FunWithDeckOfCards {

    public static void main(String[] args) {
        System.out.println("Fun with Deck of Cards! ");

        DeckOfCards deckOfCards = new DeckOfCards();

        deckOfCards.printDeck(System.out);

        deckOfCards.shuffle();
        //DEBUG - pass in the System.out so the deck can dump to the console
        deckOfCards.printDeck(System.out);

        //Testing drawing a card
        System.out.printf("\nDraw card: %s", deckOfCards.drawCard().toString());
        deckOfCards.printDeck(System.out);

        //Create a simple test hand and add two cards
        ArrayList<PlayingCard> testHand = new ArrayList<>();
        testHand.add(deckOfCards.drawCard());
        testHand.add(deckOfCards.drawCard());

        System.out.printf("Hand value: %d", BlackJackHand.getTotalValue(testHand));


    }
}
