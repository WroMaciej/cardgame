package wromaciej.cardgame.view.menu;


/**
 * An option in context menu with its all data
 */
public class MenuOption {
    /**
     * Char of option in context menu which should be typed to choose this option
     */
    private char charToChoose;

    /**
     * Message to show in menu
     */
    private String message;

    /**
     * Menu to show if the option has been chosen
     */
    private Menu menuIfChosen;

    public MenuOption(char charToChoose, String message, Menu menuIfChosen) {
        this.charToChoose = charToChoose;
        this.message = message;
        this.menuIfChosen = menuIfChosen;
    }

    public char getCharToChoose() {
        return charToChoose;
    }

    public String getMessage() {
        return message;
    }

    public Menu getMenuIfChosen() {
        return menuIfChosen;
    }
}
