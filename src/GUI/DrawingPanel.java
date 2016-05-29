package GUI;

import Models.Constants;
import Models.Game;
import Models.Interfaces.IDuck;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JComponent {
    private Game game;
    private List<IDuck> ducks = new ArrayList<>();

    public DrawingPanel(Game game){
        this.game = game;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0, Constants.windowWidth, Constants.windowHeight);
        ducks = game.getDucks();
        for (IDuck duck : ducks) {
            graphics2D.setColor(Color.BLUE);
            graphics2D.fillRect(duck.getX(), duck.getY(), duck.getSize(), duck.getSize());
        }
    }
}
