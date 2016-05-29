package Models;

import Models.Constants;
import Models.Duck;
import Models.Interfaces.IDuck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<IDuck> ducks;
    private int bullets;
    private int score;
    private Random rnd;

    public void start(){
        rnd = new Random();
        ducks = new ArrayList<>();
        score = 0;
        while(true){
            bullets = Constants.numberOfBulletsToStart;
            spawnDucks();
            whileShooting();
        }
    }
    
    public void shootDuck(int x, int y){
        bullets--;
        for (int i = 0; i < ducks.size(); i++) {
            //possible mistake, test this
            if(ducks.get(i).getY() < y && y < ducks.get(i).getY() + ducks.get(i).getSize() &&
                    ducks.get(i).getX() < x && x < ducks.get(i).getX() + ducks.get(i).getSize()){
                ducks.remove(i);
                score += Constants.scorePerDuck;
                i--;
            }
        }
    }

    public List<IDuck> getDucks() { return this.ducks; }

    private void spawnDucks(){
        int numOfDucks = rnd.nextInt(Constants.maxNumberOfDucksToSpawn) + 1;
        for (int i = 0; i < numOfDucks; i++) {
            ducks.add(new Duck(rnd.nextInt(Constants.windowWidth),
                    rnd.nextInt(Constants.windowHeight), Constants.speed, Constants.size));
        }
    }

    private void whileShooting(){
        while (true) {
            if (ducks.size() == 0 || bullets == 0) {
                return;
            }
            for (int i = 0; i < ducks.size(); i++) {
                ducks.get(i).updateDuck();
            }
            try {
                Thread.sleep(16);
            } catch (InterruptedException interruptedException) {

            }
        }
    }
}
