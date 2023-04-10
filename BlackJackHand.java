package ca.nl.cna.java1.Project;

import java.util.ArrayList;

/**
 * A BlackJack hand class
 * @Josh
 */
public class BlackJackHand {

    /**
     * Calculate the value of a blackjack hand that stored in an arraylist of playing cards.
     * @param hand hand to value
     * @return value as an int (>21) is bust
     */
    public static int getTotalValue(ArrayList<PlayingCard> hand){
        int total = 0;

        for (PlayingCard playingCard: hand) {
            //TODO Check for Jack, Queen and King and add as 10
            total += playingCard.getFaceValue();
        }

        //TODO You have to handle ACES!

        return total;
    }

}
