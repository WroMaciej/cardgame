package wromaciej.cardgame.view.menu.game;

import wromaciej.cardgame.view.menu.Menu;

import static wromaciej.cardgame.view.menu.game.GameMenu.deck;

public class MixMenu extends Menu {
    public MixMenu(Menu previousMenu) {
        super(previousMenu);
        setTitle("MIXINNG MENU");
        addOption('R', "Return to game menu", previousMenu);
        addQuitOption();
    }

    @Override
    public void run() {
        super.run();
        deck.mix();
        setMessage("You have shuffled the deck. Below you can see the result.\n\n"+deck.show()+"\n");
        showMenu();
    }
}
