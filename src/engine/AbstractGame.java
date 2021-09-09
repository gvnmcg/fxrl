package engine;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * purpose - the abstract root to any JFX Game projects I may make
 */
public abstract class AbstractGame {

    private final static int WIDTH = 600;
    private final static int HEIGHT = 400;

    protected InputHandler inputHandler;
    protected GraphicsContext g;
    protected double width, height;

    protected GameData gameData = new GameData(WIDTH, HEIGHT);
//    protected Renderer renderer;

    protected AnimationTimer timer;

    public AbstractGame(Stage stage, int width, int height) {

        //inputHandler
        Group root = new Group();
        stage.setScene(new Scene(root, width, height));

        //input handling
        this.inputHandler = new InputHandler(root, this);

//        stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                handleKeyPress(event);
//            }
//        });


        //renderer
        Canvas canvas = new Canvas(width, height);
        this.g = canvas.getGraphicsContext2D();
        this.width = canvas.getWidth();
        this.height = canvas.getHeight();

        root.getChildren().add(canvas);
        stage.show();

        //game loop
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (now % 10 != 0) return;
                update();
                render();
            }
        };

    }

    public AbstractGame(Group root, GraphicsContext g) {
        this.g = g;
        width = g.getCanvas().getWidth();
        height = g.getCanvas().getHeight();

        inputHandler = new InputHandler(root, this);
    }

    public void renderBackground() {

        g.setFill(Color.BLACK);
        g.fillRect(0, 0, width, height);
    }


    public void renderBackground(Color color) {

        g.setFill(color);
        g.fillRect(0, 0, width, height);
    }

    /**
     * called every loop
     * Its Recommended adjust object properties w/r/t movement and action
     */
    public abstract void update();

    public abstract void render();

    public abstract void handleClick(MouseEvent event);

    public abstract void handleDrag(MouseEvent event);

    public abstract void handleKeyPress(KeyEvent event);

    public abstract void handleScroll(ScrollEvent event);
}
