package engine.testgame;

import engine.AbstractGame;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

public class TestGame extends AbstractGame {

    public TestGame(Stage stage) {
        super(stage, 540, 540);
    }

    @Override
    public void update() {


    }

    @Override
    public void render() {
        g.fillRect( 100, 100, 100, 100);

    }

    @Override
    public void handleClick(MouseEvent event) {

    }

    @Override
    public void handleDrag(MouseEvent event) {

    }

    @Override
    public void handleKeyPress(KeyEvent event) {

    }

    @Override
    public void handleScroll(ScrollEvent event) {

    }
}
