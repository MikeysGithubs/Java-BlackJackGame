package ca.nl.cna.java1.Project;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of playing cards. All the cards are stored in a list
 * A deck should be created with 52 cards.
 * You can shuffle a deck (randomize a full deck)
 * You can draw a card from the deck which removes the card
 */

public class DeckOfCards {

    private ArrayList<PlayingCard> playingCardArrayList;

    /**
     * Create a new deck of cards. Not shuffled!
     */
    public DeckOfCards() {
        this.initializeDeck();
    }

    /**
     * Draw a card off the top of the deck
     * @return Playing card
     */
    public PlayingCard drawCard() {
        //Let's use the first card in the list as the top of the deck
        return this.playingCardArrayList.remove(0);

        }

    /**
     * shuffle the deck
     */
    public void shuffle() {Collections.shuffle(this.playingCardArrayList); }
    /**
     * This method sets up the deck correctly
     */
    private void initializeDeck(){
        playingCardArrayList = new ArrayList<>();
        // Add the hearts
        for (int i = 2; i <= PlayingCard.ACE ; i++) {
            playingCardArrayList.add(new PlayingCard(i, PlayingCard.Suit.HEARTS));
        }
        //Add the clubs
        for (int i = 2; i <= PlayingCard.ACE ; i++) {
            playingCardArrayList.add(new PlayingCard(i, PlayingCard.Suit.CLUBS));

        }
        //Add the diamonds
        for (int i = 2; i <= PlayingCard.ACE ; i++) {
            playingCardArrayList.add(new PlayingCard(i, PlayingCard.Suit.DIAMONDS));
        }
        //Add the spades
        for (int i = 2; i <= PlayingCard.ACE ; i++) {
            playingCardArrayList.add(new PlayingCard(i, PlayingCard.Suit.SPADES));
        }
    }

    /**
     * For TESTING PURPOSES
     * Print the deck to the printstream
     * @param printStream
     */
    public void printDeck(PrintStream printStream){
        printStream.println("\nPrinting deck of cards:  ");
        for (PlayingCard playingCard: this.playingCardArrayList) {
            printStream.print(playingCard.toString() + ", ");
        }
    }
}


