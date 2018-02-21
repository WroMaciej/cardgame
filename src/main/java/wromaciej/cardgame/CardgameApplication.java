package wromaciej.cardgame;

import wromaciej.cardgame.view.menu.MainMenu;
import wromaciej.cardgame.view.menu.Menu;

public class CardgameApplication {


    public static void main(String[] args) {
        //create and run the main menu
        Menu mainMenu = new MainMenu();
        mainMenu.run();
    }
}