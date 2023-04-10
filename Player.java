package ca.nl.cna.java1.Project;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * A simple object player that has a name
 * @author mikey
 */
public class Player {
    private ArrayList<PlayingCard> hand;
    private int bet;
    private int money;
    private int handValue;

    /**
     * Constructor that takes startingMoney
     * @param startingMoney
     */

    public Player(int startingMoney) {
        this.hand = new ArrayList<PlayingCard>();
        this.bet = 0;
        this.handValue = 0;
        this.money = startingMoney;
    }

    /**
     * Get the hand
     * @return getHand
     */
    public ArrayList<PlayingCard> getHand() {
        return this.hand;
    }

    /**
     * ShowHand method that shows the player's hand
     */

    public void showHand() {
        System.out.print("Player's hand: ");
        for (PlayingCard card : this.hand) {
            System.out.print(card.toString() + " ");
        }
        System.out.println("(Total value: " + this.handValue + ")");
    }

    /**
     * Get the hand value
     * @return getHandValue
     */

    public int getHandValue(){
        return this.handValue;
    }

    /**
     * Constructor that adds card to the hand
     * @param card card
     */
    public void addCardToHand(PlayingCard card) {
        this.hand.add(card);
        this.updateHandValue();
    }

    /**
     * UpdateHandValue method that updates the value of the cards in the hand
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
     * Get the bet
     * @return bet
     */
    public int getBet() {
        return this.bet;
    }

    /**
     * Set the bet
     * @param bet bet
     */

    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * Get the money
     * @return money
     */

    public int getMoney() {
        return money;
    }

    /**
     * Set the money
     * @param money money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Adjust the money
     * @param amount amount
     */
    public void adjustMoney(int amount) {
        this.money += amount;
    }

    /**
     * clearHand method that clears the cards in the hand after each game
     */
    public void clearHand() {
        this.hand.clear();
    }
}
