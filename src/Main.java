import GUI.Window;
import Models.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        new Window(game);
        game.start();
    }

}
