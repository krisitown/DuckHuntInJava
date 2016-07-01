package Models;

import Models.Interfaces.IDuck;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Duck implements IDuck {
    private int x, y;
    private int speed;
    private int size;
    private Direction direction;
    private Sprite sprite;
    private Random rnd;

    public Duck(int x, int y, int speed, int size) {
        rnd = new Random();
        sprite = new Sprite();
        setX(x);
        setY(y);
        randomizeDirection();
        setSpeed(speed);
        setSize(size);
    }

    @Override
    public void updateDuck() {
        //randomly changes the direction of the duck
        if(rnd.nextInt(100) < Constants.chanceToChangeDirection){
            randomizeDirection();
        }

        //MOVE DA DUCK
        try{
            move();
        } catch (IllegalArgumentException iaException){
            reverseDirection();
        }
    }

    @Override
    public BufferedImage getImage() {
        return sprite.getImage(this.direction);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void setSize(int size){
        if(size <= 0){
            throw new IllegalArgumentException("The size of the duck should be positive");
        }
        this.size = size;
    }

    private void setSpeed(int speed){
        if(speed <= 0){
            throw new IllegalArgumentException("The speed of the duck must be a positive integer");
        }
        this.speed = speed;
    }

    private void setX(int x){
        if(x < 0 || x > Constants.windowWidth){
            throw new IllegalArgumentException("The X coordinate of the duck must be more than 0 and " +
                    "less than the window's width.");
        }
        this.x = x;
    }

    private void setY(int y){
        if(y < 0 || y > Constants.windowHeight){
            throw new IllegalArgumentException("The Y coordinate of the duck must be more than 0 and " +
                    "less than the window's height.");
        }
        this.y = y;
    }

    private void move(){
        switch (direction){
            case Left:
                setX(x - speed);
                break;
            case Right:
                setX(x + speed);
                break;
            case TopLeft:
                setY(y - speed);
                setX(x - speed);
                break;
            case TopRight:
                setX(x + speed);
                setY(y - speed);
                break;
        }
    }

    private void randomizeDirection() {
        this.direction = Direction.values()[rnd.nextInt(4)]; //possible error add +1
    }


    //needs improvements
    private void reverseDirection(){
        this.direction = Constants.directionMap.get(this.direction);
    }
}
