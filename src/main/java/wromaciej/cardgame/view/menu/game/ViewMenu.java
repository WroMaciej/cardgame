package wromaciej.cardgame.view.menu.game;

import wromaciej.cardgame.view.menu.Menu;

import static wromaciej.cardgame.view.menu.game.GameMenu.deck;

public class ViewMenu extends Menu {


    public ViewMenu(Menu previousMenu) {
        super(previousMenu);
        setTitle("VIEW MENU");

        addOption('R', "Return to game menu", previousMenu);
        addQuitOption();
    }

    @Override
    public void run() {
        super.run();
        setMessage("Below you can see the actual deck \n\n" + deck.show() + "\n");
        showMenu();
    }
}
