package wromaciej.cardgame.controller;

import wromaciej.cardgame.model.Deck;
import wromaciej.cardgame.view.menu.game.GameMenu;

public abstract class DeckController {

    public static int numberOfDecks = 1;

    /**
     * Gets number of standard decks to play a game with from keyboard input
     */

    public static void getNumberOfDecksFromKeyboard() {
        System.out.println("How many decks would you like to play?");
        try {
            System.out.println("Number of decks: ");
            numberOfDecks = Integer.parseInt(MenuController.getInput());
            if (numberOfDecks < 1) throw new IllegalArgumentException();
            else GameMenu.deck=new Deck(numberOfDecks);
        } catch (Exception exception) {
            System.out.println("It looks that you tried to type incorrect number. Please try again.");
            getNumberOfDecksFromKeyboard();
        }

    }
}
