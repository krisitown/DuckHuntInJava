package Models;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private int counter = 0;

    private BufferedImage spriteSheet;
    private BufferedImage[] topLeft;
    private BufferedImage[] left;
    private BufferedImage[] right;
    private BufferedImage[] topRight;

    public Sprite(){
        initializeStructures();
        loadResources();
    }

    private void loadResources() {
        try{
            spriteSheet = ImageIO.read(new File("src/res/duckSpriteSheet.png"));
            topLeft[0] = spriteSheet.getSubimage(0,0,32,32);
            topLeft[1] = spriteSheet.getSubimage(109,0,32,32);
            topRight[0] = spriteSheet.getSubimage(34,0,32,32);
            topRight[1] = spriteSheet.getSubimage(68,0,32,32);
            left[0] = spriteSheet.getSubimage(141,0,32,32);
            left[1] = spriteSheet.getSubimage(279,0,32,32);
            right[0] = spriteSheet.getSubimage(190,0,32,32);
            right[1] = spriteSheet.getSubimage(234,0,32,32);

        } catch (IOException ioException){
            ioException.printStackTrace();
        }

    }

    private void initializeStructures() {
        topLeft = new BufferedImage[2];
        left = new BufferedImage[2];
        right = new BufferedImage[2];
        topRight = new BufferedImage[2];
    }

    public BufferedImage getImage(Direction direction){
        counter+=2;
        switch (direction){
            case Left:
                return left[(counter/10) % 2];
            case Right:
                return right[(counter/10) % 2];
            case TopLeft:
                return topLeft[(counter/10) % 2];
            case TopRight:
                return topRight[(counter/10) % 2];
        }
        return null;
    }
}
