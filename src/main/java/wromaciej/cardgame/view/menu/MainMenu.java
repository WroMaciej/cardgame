package wromaciej.cardgame.view.menu;

import wromaciej.cardgame.view.menu.game.GameMenu;

public class MainMenu extends Menu {


    public MainMenu(Menu previousMenu) {
        super(previousMenu);
        getNumberOfDecks();
        setTitle("MAIN MENU");
        setMessage("Welcome to the simply CARD GAME \n" +
                "Please feel free to test all options and try to find a bug! :) \n" +
                "Many thanks to Mr Thomas and Mr Marcin from iStone for this challenge. \n" +
                "Application developed by Maciej Wroblewski wro.maciej@gmail.com");
        addOption('P', "Play a game", new GameMenu(this));
        addQuitOption();
    }

    public MainMenu() {
        this(null);
    }

    @Override
    public void run() {
        super.run();
        showMenu();
    }
}
