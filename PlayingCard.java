package ca.nl.cna.java1.Project;

/**
 * A standard playing card.
 *
 * A "standard" deck of playing cards consists of 52 Cards in each of the 4 suits of Spades, Hearts, Diamonds, and Clubs.
 *  Each suit contains 13 cards: Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King.
 */
public class PlayingCard {
    public static final int ACE = 14;
    public static final int KING = 13;
    public static final int QUEEN= 12;
    public static final int JACK = 11;

    //Two attributes - suit and value
    private int faceValue;
    private Suit suit;

    /**
     * Constructor that creates a playing cards. Note: this is really for testing. Cards are created properly in a deck.
     * @param faceValue
     * @param suit
     */

    public PlayingCard(int faceValue, Suit suit) {
        //You can check the value and default it to something
        this.faceValue = faceValue;
        this.suit = suit;
    }

    /**
     * Get Face Value
     * @return face value
     */

    public int getFaceValue() { return faceValue; }

    /**
     * Get Suit
     * @return suit
     */
    public Suit getSuit() { return suit; }

    /**
     * A method to print out what a card looks like
     * @return
     */

    public String toString(){
        String string = "";

        if(this.faceValue == ACE){
            string = "A";
        }else if (this.faceValue == KING){
            string = "K";
        }else if(this.faceValue == QUEEN) {
            string = "Q";
        }else if (this.faceValue == JACK) {
            string = "J";
        }else{
            string = String.valueOf(this.faceValue);
        }

        //TODO replace this
        if(this.suit == Suit.HEARTS){
            string +=  '\u2665';
        }else if (this.suit == Suit.CLUBS) {
            string += '\u2663';
        }else if (this.suit == Suit.DIAMONDS) {
            string += '\u2666';
        } else {
            string += '\u2660';
        }
        return string;
    }

    public enum Suit {HEARTS, DIAMONDS, SPADES, CLUBS}
    //TODO Add symbols to the enumeration

}
