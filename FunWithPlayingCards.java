package ca.nl.cna.java1.Project;

public class FunWithPlayingCards {

    public static void main(String[] args) {
        System.out.println("Fun with Playing Cards");

        PlayingCard playingCard = new PlayingCard(PlayingCard.KING, PlayingCard.Suit.SPADES);
        

        System.out.printf("Card: %s", playingCard.toString());


        char spade = '\u2660';


        System.out.printf("\nSpade %c", spade);

    }
}
