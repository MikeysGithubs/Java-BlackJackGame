/**
 * Java 1 Course Project Outline
 *
 * Black Jack Rules:
 * Cards 2-10 are worth the value of the number on the face of the card. Numbered cards are worth the corresponding
 * number indicated on the card. Face cards (those with pictures on them) are worth 10, except for the Ace,
 * which is worth 1 or 11. A picture combined with an Ace is Blackjack (a value of 21).
 *
 * The most important blackjack rule is simple: beat the dealer’s hand without going over 21.
 * If you go over 21 you are Bust. If you get 21 points exactly on the deal, that is called a “blackjack.”
 *
 * Note: To keep this simple, the player at the interface will hit or stay (or bust) until they decide to quit and
 * then the dealer will go. There is no need to go back and forth – keep it simple.
 * The player can see one of the dealers card up during their turn. Keep it simple – no splitting or doubling down.
 * <br/>
 * I recommend you use the following objects
 * <br/>- PlayingCard
 * <br/>- DeckOfCards (or CardDeck)
 * <br/>- Hand (for holding cards)
 * <br/>- Dealer (has a hand)
 * <br/>- Player (has a hand and money to bet)
 * <br/>- BlackJackGame (tracks the score, stores the Deck, Player and Dealer objects)
 * <br/>- BlackJackGameApplication (main application with the menu)
 *
 */
package ca.nl.cna.java1.Project;