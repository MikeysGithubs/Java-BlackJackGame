package ca.nl.cna.java1.Project;
import java.util.ArrayList;
public class Hand {
    private ArrayList<PlayingCard> cards;

    public Hand() {
        this.cards = new ArrayList<PlayingCard>();
    }
    public void addCard(PlayingCard card) {
        this.cards.add(card);
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public int getTotalValue() {
        int total = 0;
        int numAces = 0;

        // Add up all cards except Aces
        for (PlayingCard card : this.cards){
            if (card.getFaceValue() == PlayingCard.ACE) {
                numAces++;
            }else if (card.getFaceValue() >= PlayingCard.JACK) {
                total += 10;
            } else {
                total += card.getFaceValue();
            }
        }
        // Add up Aces
        for (int i = 0; i < numAces; i++) {
            if (total + 11 <= 21) {
                total += 11;
            } else {
                total += 1;
            }

        }
        return total;
    }

    public boolean isBust() {
        return this.getTotalValue() > 21;
    }
    public boolean isBlackJack() {
        return this.getTotalValue() == 21 && this.cards.size() == 2;
    }

    public void clear() {
        this.cards.clear();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlayingCard card : this.cards) {
            sb.append(card.toString()).append(" ");
        }
        return sb.toString().trim();
    }


}
