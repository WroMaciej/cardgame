package wromaciej.cardgame.view.menu;

public class QuitMenu extends Menu {

    public QuitMenu(Menu previousMenu) {
        super(previousMenu);
        setTitle("YOU HAVE QUIT THE CARD GAME");
        setMessage("Thank you for your time spent for play and test the game. Have a nice day :).");
    }

    @Override
    public void run() {
        super.run();
        showMenu();
    }
}
