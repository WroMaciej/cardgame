package wromaciej.cardgame.view.menu;

import wromaciej.cardgame.controller.DeckController;
import wromaciej.cardgame.controller.MenuController;

import java.util.ArrayList;

/**
 * General context Menu - extend it for each special menu
 */
public class Menu {

    /**
     * Title of menu to show
     */
    private String title;

    /**
     * Message to show with menu
     */
    private String message;

    /**
     * Previous menu
     */
    private Menu previousMenu;

    /**
     * List of all options available in this menu
     */
    private ArrayList<MenuOption> options;

    public Menu(Menu previousMenu) {
        this.previousMenu = previousMenu;
        this.options = new ArrayList<MenuOption>();
    }


    /**
     * Converting string from input to option
     *
     * @param optionInput
     * @return
     */
    public MenuOption stringToOption(String optionInput) {
        for (MenuOption option : options) {
            if (Character.toString(option.getCharToChoose()).toLowerCase().equals(optionInput.toLowerCase())) {
                return option;
            }
        }
        return null;
    }


    /**
     * Receiving input from keyboard and entering proper menu
     */
    public void selectOption() {
        try {
            stringToOption(MenuController.getInput()).getMenuIfChosen().run();
        } catch (Exception exception) {
            showMenu();
        }
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    protected void setMessage(String message) {
        this.message = message;
    }


    /**
     * Clearing a system console (by adding new lines)
     */
    public static void clearView() {
        for (int i = 0; i < 10; i++) System.out.println();
    }

    /**
     * Add an Option to Menu
     *
     * @param charToChoose char to choose this option
     * @param message      message to show with this option
     * @param menuIfChosen a menu to show when option has been chose. If none - NULL
     */
    protected void addOption(char charToChoose, String message, Menu menuIfChosen) {
        options.add(new MenuOption(charToChoose, message, menuIfChosen));
    }

    protected void addQuitOption() {
        addOption('Q', "Quit application", new QuitMenu(this));
    }

    protected void getNumberOfDecks() {
        DeckController.getNumberOfDecksFromKeyboard();
    }

    /**
     * Run a menu
     */
    public void run(){

    }

    /**
     * Show a full context menu with all options
     */
    public void showMenu() {
        clearView(); //clear view in console
        System.out.println("********   " + title + "   ********");  //show title
        System.out.println();
        System.out.println(message); //show message
        System.out.println();
        //show all available options
        for (MenuOption option : options) {
            System.out.println(option.getCharToChoose()
                    + ": "
                    + option.getMessage());
        }
        //show keyboard input if it is not a quit menu
        if (this.getClass() != QuitMenu.class) selectOption();
    }


}
