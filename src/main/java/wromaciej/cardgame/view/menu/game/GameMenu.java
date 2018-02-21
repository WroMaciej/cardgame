package wromaciej.cardgame.view.menu.game;

import wromaciej.cardgame.controller.DeckController;
import wromaciej.cardgame.model.Deck;
import wromaciej.cardgame.view.menu.Menu;

public class GameMenu extends Menu {

    public static Deck deck;

    public GameMenu(Menu previousMenu) {
        super(previousMenu);
        deck=new Deck(DeckController.numberOfDecks);
        setTitle("GAME MENU");
        setMessage("Select what would you like to do with your cards. \n"
                + "Your decks consists of " + DeckController.numberOfDecks + " standard 52-cards deck(s).");
        addOption('S', "Sort cards", new SortMenu(this));
        addOption('M', "Mix cards", new MixMenu(this));
        addOption('D', "Draw a card from the top", new DrawMenu(this));
        addOption('V', "View cards", new ViewMenu(this));
        addQuitOption();
    }

    @Override
    public void run() {
        super.run();
        showMenu();
    }
}
