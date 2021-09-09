package engine;

import engine.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * purpose - render into window canvas
 *  w/r/t
 *      camera   and
 *      scale of board
 */
public class Renderer {

    protected final double width;
    protected final double height;
    protected GraphicsContext g;
    protected GameObject camera;


    public Renderer(GraphicsContext g, double width, double height) {
        this.g = g;
        this.width = width;
        this.height = height;
    }

    public Renderer(GraphicsContext g, double width, double height, GameObject camera) {
        this.g = g;
        this.width = width;
        this.height = height;
        this.camera = camera;
    }

    public void setColor(Paint paint) {
        g.setFill(paint);
    }

    protected void renderBackground() {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height);
    }

    protected void drawMarker(double x, double y) {
        g.setFill(Color.GREEN);
        g.strokeOval(
                x - 10,
                y - 6, 20, 12);
    }

    protected void cameraRender(GameObject o, GameObject camera) {
        g.drawImage(o.image,
                o.getX() + camera.getX(),
                o.getY() + camera.getY());
    }

}
