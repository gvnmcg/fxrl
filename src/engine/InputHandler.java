package engine;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

/**
 * captures all the input events
 */
public class InputHandler {

    private double mouseX, mouseY;
    private boolean held = false;

    public InputHandler(Stage root, AbstractGame game) {
        root.addEventHandler(MouseEvent.MOUSE_DRAGGED, event -> {
            held = true;
            mouseX = event.getX();
            mouseY = event.getY();
            game.handleDrag(event);
        });

        root.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            held = false;
            mouseX = event.getX();
            mouseY = event.getY();
            game.handleClick(event);
        });

        root.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> held = true);
        root.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> held = false);
        root.addEventHandler(KeyEvent.KEY_PRESSED, event -> game.handleKeyPress(event));
//        root.addEventHandler(KeyEvent.KEY_TYPED, event -> { });
//        root.addEventHandler(KeyEvent.KEY_RELEASED, event -> { });
        root.addEventHandler(ScrollEvent.SCROLL, event -> game.handleScroll(event));
    }

    public double getMouseX() {
        return mouseX;
    }

    public double getMouseY() {
        return mouseY;
    }

    public boolean isHeld() {
        return held;
    }
}
