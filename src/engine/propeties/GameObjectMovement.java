package engine.propeties;

import engine.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameObjectMovement extends GameObjectProperty{


    public static final String MOVMENT = "MOVEMENT";
    private double x, y;
    private double v;
    private double dx, dy;

    //actor class
    private double destX, destY;
    private boolean hasDestination;
    private boolean dead = false;



    public void setDestination(double i, double j) {

        this.hasDestination = true;

        destX = i;
        destY = j;
//        setTarget(i, j);
    }

    public boolean hasDestination() {
        return hasDestination;
    }

    public double getDestX() {
        return destX;
    }

    public double getDestY() {
        return destY;
    }

    public void move() {

        if (hasDestination) {
            if (Math.abs(x - destX) <= 5
                    && Math.abs(y - destY) <= 5) {
                dx = 0;
                dy = 0;
                hasDestination = false;
            }
        }

    }

    public void setDead(boolean dead) {
        this.dead = dead;
        v = 0;
        dx = 0;
        dy = 0;

    }

    public void setTarget(double i, double j) {

        dx = i - x;
        dy = j - y;

        double mag = Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0));

        dx /= mag;
        dy /= mag;

        dx *= v;
        dy *= v;

    }


    protected void renderDestinationMarker(GraphicsContext g) {
        if (hasDestination) {
            g.setFill(Color.GREEN);
            g.strokeOval(
                    getDestX(),
                    getDestY(), 20, 12);
        }
    }

    protected void cameraRenderDestinationMarker(GraphicsContext g, GameObject camera) {
        if (hasDestination) {
            g.setFill(Color.GREEN);
//            g.strokeOval(
//                    getDestX() - camera.getX() - 10,
//                    getDestY() - camera.getY() - 6, 20, 12);
//
            g.strokeOval(
                    getDestX() - camera.getX(),
                    getDestY() - camera.getY(), 20, 12);
        }
    }

    //actor

}
