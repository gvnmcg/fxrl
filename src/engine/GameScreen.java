package engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * Set of Game that overrides Game update/render/input
 * loops at the same speed of game
 */
public abstract class GameScreen {

    protected InputHandler inputHandler;
    protected GraphicsContext g;

    protected boolean done = false;

    public GameScreen(InputHandler inputHandler, GraphicsContext g){
        this.inputHandler = inputHandler;
        this.g = g;
    }

    public abstract void update();

    public abstract void render();

    public abstract void handleClick(MouseEvent event);

    public abstract void handleDrag(MouseEvent event);

    public abstract void handleKeyPress(KeyEvent event);

    public boolean isDone() {
        return done;
    }
}
