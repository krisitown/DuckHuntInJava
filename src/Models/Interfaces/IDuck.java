package Models.Interfaces;

import java.awt.image.BufferedImage;

public interface IDuck {
    int getX();
    int getY();
    int getSize();

    void updateDuck();
    BufferedImage getImage();
}
