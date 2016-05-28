package Models;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static int windowWidth = 640;
    public static int windowHeight = 480;
    public static int chanceToChangeDirection = 5;

    //speed could be randomized in the future
    public static int speed = 20;

    public static final Map<Direction, Direction> directionMap;
    static
    {
        directionMap = new HashMap<>();
        directionMap.put(Direction.Down, Direction.Up);
        directionMap.put(Direction.Left, Direction.Right);
        directionMap.put(Direction.DownLeft, Direction.TopRight);
        directionMap.put(Direction.TopLeft, Direction.DownRight);
        directionMap.put(Direction.Up, Direction.Down);
        directionMap.put(Direction.Right, Direction.Left);
        directionMap.put(Direction.TopRight, Direction.DownLeft);
        directionMap.put(Direction.DownRight, Direction.TopLeft);
    }
}
