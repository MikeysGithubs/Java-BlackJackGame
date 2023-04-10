package ca.nl.cna.java1.Project;
import java.util.Scanner;

/**
 * An application that calls the run game method and plays the Blackjack game.
 *
 * @author mikey
 */
public class BlackJackGameApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to the Blackjack game!");

        // Create Blackjack game
        BlackJackGame Game = new BlackJackGame();
        Game.run();
        System.out.println("Game Over!");

    }
}
