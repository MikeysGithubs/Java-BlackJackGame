package ca.nl.cna.java1.Project;

import java.util.ArrayList;

/**
 *A simple object called Dealer that has a name.
 * @author mikey
 */
public class Dealer {
    private ArrayList<PlayingCard> hand;
    private int handValue;

    /**
     *Dealer default constructor
     */

    public Dealer() {
        this.hand = new ArrayList<>();
        this.handValue = 0;
    }

    /**
     * set the card
     * @param card card
     */
    public void dealCard(PlayingCard card) {
        this.hand.add(card);
        updateHandValue();
    }

    /**
     * Get the Hand
     * @return Hand
     */

   public ArrayList<PlayingCard> getHand() {
        return this.hand;
    }

    /**
     * UpdateHandValue method
     */

    public void updateHandValue() {
        int aceCount = 0;
        int value = 0;
        int handValueCount = 0;
        for (PlayingCard card : this.hand) {
            int cardValue = card.getFaceValue();

            if (cardValue > 10 && cardValue != PlayingCard.ACE) {
                value = 10;

            } else if (cardValue == PlayingCard.ACE) {
                aceCount++;
                value = 11;
            } else {
                value = cardValue;
            }

            handValueCount += value;
        }


        while (handValueCount > 21 && aceCount > 0) {
            handValueCount -=10;
            aceCount--;
        }
            this.handValue = handValueCount;

    }

    /**
     * getHandValue
     * @return Hand Value
     */
    public int getHandValue() {
        return this.handValue;
    }

    /**
     * showHand method that shows cards in hand
     */
    public void showHand() {
        System.out.print("Dealer's hand: ");
        for (PlayingCard card : this.hand) {
            System.out.print(card.toString() + " ");
        }
        System.out.println("(Total value: " + this.handValue + ")");
    }

    /**
     * clearHand method that clears the cards in the hand after each game
     */
    public void clearHand() {
        this.hand.clear();
        this.handValue = 0;
    }

    /**
     * addCardToHand
     * @param card card
     */
    public void addCardToHand(PlayingCard card){
        this.hand.add(card);
        this.updateHandValue();
    }

    /**
     * showTopCardInHand method that shows the dealer's top card
     */
    public void showTopCardInHand(){
        System.out.println("dealers top card");
        System.out.println(this.hand.get(0).toString() + "");

    }
}
