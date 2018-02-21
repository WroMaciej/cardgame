package wromaciej.cardgame.view.menu.game;

import wromaciej.cardgame.model.Card;
import wromaciej.cardgame.view.menu.Menu;

import static wromaciej.cardgame.view.menu.game.GameMenu.deck;

public class DrawMenu extends Menu {

    private Card drawnCard;

    public DrawMenu(Menu previousMenu) {
        super(previousMenu);
        setTitle("DRAW MENU");
        addOption('R', "Return to game menu", previousMenu);
        addQuitOption();
    }

    @Override
    public void run() {
        super.run();
        drawnCard=deck.draw();
        setMessage("You have drawn the card from the top. Here is your card:\n\n"+drawnCard.getBothNames()+"\n");
        showMenu();
    }
}
