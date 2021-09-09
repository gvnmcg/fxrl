package engine.propeties;

public class GameObjectPosition extends GameObjectProperty{

    public static String POSITION = "POSIIION";

    double x;
    double y;

    public GameObjectPosition(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
