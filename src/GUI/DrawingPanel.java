package GUI;

import Models.Constants;
import Models.Game;
import Models.Interfaces.IDuck;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JComponent {
    private Game game;
    private List<IDuck> ducks;
    private BufferedImage background, bullet;
    private Font scoreFont;

    public DrawingPanel(Game game){
        ducks = new ArrayList<>();
        this.game = game;
        scoreFont = new Font("Arial", 10, 36);
        try{
            background = ImageIO.read(new File("src/res/background.png"));
            bullet = ImageIO.read(new File("src/res/bullet.png"));
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawImage(background, 0, 0, Constants.windowWidth, Constants.windowHeight, this);
        ducks = game.getDucks();
        for (IDuck duck : ducks) {
            graphics2D.drawImage(duck.getImage(), duck.getX(), duck.getY(), duck.getSize(), duck.getSize(), this);
        }

        int score = game.getScore();
        graphics2D.setFont(scoreFont);
        graphics2D.drawString("SCORE: " + score, 0, 30);

        int numberOfBullets = game.getBullets();
        for (int i = 1; i <= numberOfBullets; i++) {
            graphics2D.drawImage(bullet, Constants.windowWidth - (i * Constants.sizeOfBullet), 0,
                    Constants.sizeOfBullet, Constants.sizeOfBullet, this);
        }
    }
}
