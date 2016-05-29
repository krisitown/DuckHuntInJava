package GUI;

import Models.Constants;
import Models.Game;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Window extends JFrame{

    public Window(Game game){
        super(Constants.windowTitle);
        this.setSize(Constants.windowWidth, Constants.windowHeight);
        DrawingPanel drawingPanel = new DrawingPanel(game);
        drawingPanel.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                game.shootDuck(x, y);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
            @Override
            public void mouseDragged(MouseEvent e) {

            }
            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        this.add(drawingPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        executor.scheduleAtFixedRate(new RepaintTheWindow(this),0,16L, TimeUnit.MILLISECONDS);
        this.setVisible(true);
    }
}
