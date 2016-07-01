package Models;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static int windowWidth = 1280;
    public static int windowHeight = 720;
    public static String windowTitle = "DuckHunt";

    public static int chanceToChangeDirection = 5;

    public static int sizeOfBullet = 55;

    //speed could be randomized in the future
    public static int speed = 5;
    public static int size = 125;

    public static int maxNumberOfDucksToSpawn = 3;
    public static int numberOfBulletsToStart = 3;

    public static int scorePerDuck = 250;

    public static final Map<Direction, Direction> directionMap;
    static
    {
        directionMap = new HashMap<>();
        directionMap.put(Direction.Left, Direction.Right);
        directionMap.put(Direction.Right, Direction.Left);
        directionMap.put(Direction.TopLeft, Direction.TopRight);
        directionMap.put(Direction.TopRight, Direction.TopLeft);
    }
}
