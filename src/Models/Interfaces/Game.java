package Models.Interfaces;

import Models.Constants;
import Models.Duck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<IDuck> ducks = new ArrayList<>();
    private int bullets;
    private int score;
    private Random rnd;

    public void start(){
        while(true){
            spawnDucks();
            whileShooting();
        }
    }

    private void spawnDucks(){
        int numOfDucks = rnd.nextInt(3) + 1;
        for (int i = 0; i < numOfDucks; i++) {
            ducks.add(new Duck(rnd.nextInt(Constants.windowWidth),
                    rnd.nextInt(Constants.windowHeight), Constants.speed));
        }
    }

    private void whileShooting(){
        //todo: implement shooting
    }
}
