package wromaciej.cardgame.view.menu.game;

import wromaciej.cardgame.view.menu.Menu;

import static wromaciej.cardgame.view.menu.game.GameMenu.deck;

public class SortMenu extends Menu {
    public SortMenu(Menu previousMenu) {
        super(previousMenu);
        setTitle("SORT MENU");
        addOption('R', "Return to game menu", previousMenu);
        addQuitOption();
    }

    @Override
    public void run() {
        super.run();
        deck.sort();
        setMessage("You have sorted the deck. Below you can see the result. \n\n" + deck.show() + "\n");
        showMenu();
    }
}
