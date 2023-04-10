package ca.nl.cna.java1.Project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple Blackjack game
 *
 * Note: In this class holds the loop for the Blackjack game itself
 *
 * @author mikey
 */
public class BlackJackGame {
    private DeckOfCards deck;
    private Dealer dealer;
    private Player player;
    private int bet;
    private int playerMoney;

    /**
     * Constructor BlackJackGame
     * constructor initializes Blackjack game with no parameters
     */


    public BlackJackGame() {
        this.deck = new DeckOfCards();
        this.dealer = new Dealer();
        this.bet = 0;
        this.playerMoney = 100;
        this.player = new Player(this.playerMoney);
    }

    /**
     * method that runs the BlackJack game
     */

    public void run(){
        this.dealCards();
        Scanner input = new Scanner(System.in);
        int choice;
        GAME_CONDITION gameCondition = GAME_CONDITION.GAMESTART;
        // Show Hands
        while(true){
            System.out.println("==========New Game============");
            if(gameCondition == GAME_CONDITION.GAMESTART || gameCondition == GAME_CONDITION.PLAYERWIN
                    || gameCondition == GAME_CONDITION.DEALERWIN ) {

                System.out.printf("Player money %d\n", this.playerMoney);
                System.out.println("Player enter your bet money");
                this.bet = input.nextInt();

            }
           // this.dealer.showHand();
            this.dealer.showTopCardInHand();
            this.player.showHand();
            System.out.println("Player choose: 1-Hit  2-Stay  3-Quit");
            choice = input.nextInt();
            if (choice == 3){
                System.out.println("Player quits: Game over");
                break;
                // Player quits game
            }
            else if (choice == 1) {
                this.player.addCardToHand(this.deck.drawCard());

            }
            else if ( choice == 2){

                if(this.dealer.getHandValue() < 19){
                    this.dealer.addCardToHand(this.deck.drawCard());
                }
                if (this.dealer.getHandValue() > 21) {
                    // dealer busts
                    System.out.println("Dealer busts, Player Wins!!");
                    this.playerMoney += this.bet;
                    this.player.setMoney(this.playerMoney);
                    this.dealer.clearHand();
                    this.player.clearHand();
                    this.dealCards();
                }
                else{
                    if (this.dealer.getHandValue() >= this.player.getHandValue()){
                        System.out.println("Dealer wins!!");
                        this.player.showHand();
                        this.dealer.showHand();
                        this.playerMoney -= this.bet;
                        this.player.setMoney(this.playerMoney);
                        this.dealer.clearHand();
                        this.player.clearHand();
                        this.dealCards();
                        continue;
                    }
                    else{
                        System.out.println("Player Win!!");
                        this.player.showHand();
                        this.dealer.showHand();
                        this.playerMoney += this.bet;
                        this.player.setMoney(this.playerMoney);
                        this.dealer.clearHand();
                        this.player.clearHand();
                        this.dealCards();
                        continue;
                    }
                }

            }

            gameCondition = this.getResult();
            if (gameCondition == GAME_CONDITION.DEALERWIN) {
                System.out.println("Dealer wins!!");
                this.player.showHand();
                this.dealer.showHand();


               this.playerMoney -= this.bet;
               this.player.setMoney(this.playerMoney);
               this.dealer.clearHand();
               this.player.clearHand();
               this.dealCards();

               if (this.playerMoney <= 0 ){
                   System.out.println("No money left, game over.");
                   break;
               }
            }
            else if (gameCondition == GAME_CONDITION.PLAYERWIN) {
                System.out.println("Player Win!!");
                this.player.showHand();
                this.dealer.showHand();
                this.playerMoney += this.bet;
                this.player.setMoney(this.playerMoney);
                this.dealer.clearHand();
                this.player.clearHand();
                this.dealCards();
            }

        }
    }

    /**
     * Set the bet
     * @param bet bet
     */

        public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * method that deals the cards
     */
    public void dealCards() {
        this.deck.shuffle();
        this.player.clearHand();
        this.dealer.clearHand();

    // Deal two cards to the player
    this.player.addCardToHand(this.deck.drawCard());
    this.player.addCardToHand(this.deck.drawCard());

    //Deal two cards to the dealer
    this.dealer.addCardToHand(this.deck.drawCard());
    this.dealer.addCardToHand(this.deck.drawCard());

    }

    /**
     * method for hitting cards
     */
    public void playerHit() {
        this.player.addCardToHand(this.deck.drawCard());
    }

    /**
     * Player busts
     * @return playerBust
     */

    public boolean playerBust() {
        return this.player.getHandValue() > 21;
    }

    /**
     * Method for DealerPlay
     */
    public void dealerPlay() {
        while (this.dealer.getHandValue() < 17) {
            this.dealer.addCardToHand(this.deck.drawCard());
        }
    }

    /**
     * GAME_CONDITION
     * @return GAME_CONDITION.NOWIN
     */
    public  GAME_CONDITION getResult() {
        int playerValue = this.player.getHandValue();
        int dealerValue = this.dealer.getHandValue();

        if (playerValue > 21) {
            //player busts
            return GAME_CONDITION.DEALERWIN;
        }else if (dealerValue > 21){
            //Dealer busts
            return GAME_CONDITION.PLAYERWIN;
        } else if (playerValue == dealerValue && dealerValue == 21){
            //Player Wins
            return GAME_CONDITION.DEALERWIN;
        } else if (dealerValue == 21){
            return GAME_CONDITION.DEALERWIN;
        }
        else if (playerValue == 21){
            // Dealer wins
            return GAME_CONDITION.PLAYERWIN;
        }
        return GAME_CONDITION.NOWIN;
    }

    /**
     * Get the result
     * @param result result
     */
    public void updatePlayerMoney(int result) {
        this.playerMoney += result;
    }

    /**
     * Get the player money
     * @return player money
     */
    public int getPlayerMoney() {
        return this.playerMoney;
    }

    /**
     * Get the player hand
     * @return player hand
     */
    public ArrayList<PlayingCard> getPlayerHand() {
        return this.player.getHand();
    }

    /**
     * Get the dealer hand
     * @return dealer hand
     */
    public ArrayList<PlayingCard> getDealerHand() {
        return this.dealer.getHand();
    }

    /**
     * Enumeration for the game conditions
     */

   public enum GAME_CONDITION { PLAYERWIN, DEALERWIN, NOWIN, GAMESTART}

}
