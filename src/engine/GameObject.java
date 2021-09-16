package engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * representation of Any drawable, updateable game pieces
 */
public class GameObject {

    public double x, y;
    double dx, dy;
    protected double v;

    Image image;
    public double w, h;

    private Rectangle rectangle;
    private boolean spent;

    protected String dataType;

    public GameObject() {

    }

    public GameObject(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;

//        w = 50;
//        h = 50;
        this.rectangle = new Rectangle(
                x, y, w, h);
    }

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;

        w = 50;
        h = 50;
        this.rectangle = new Rectangle(
                (int)x, (int)y, (int)w, (int)h);
    }

    public GameObject(String url, double x, double y) {
        this(x, y);
        this.image = new Image("/sheep/assets/" + url + ".png");

        w = image.getWidth();
        h = image.getHeight();
        this.rectangle = new Rectangle((int)x, (int)y, (int)w, (int)h);
    }


    public void move() {
        this.x += this.dx;
        this.y += this.dy;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }


    public void render(GraphicsContext g, double x, double y) {
        if (image == null) {
            g.setFill(Color.RED);
            g.fillRect(x, y, w, h);
            return;
        }
        g.drawImage(image, x, y);
    }

    public void update() {
        move(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("GameObject{ x= %f, y= %f }", x, y);

    }
}
