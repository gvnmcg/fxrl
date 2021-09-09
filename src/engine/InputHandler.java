package engine;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;

/**
 * captures all the input events
 */
public class InputHandler {

    private double mouseX, mouseY;
    private boolean held = false;

    public InputHandler(Group root, AbstractGame game) {
        root.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                held = true;
                mouseX = event.getX();
                mouseY = event.getY();
                game.handleDrag(event);
            }
        });

        root.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                held = false;
                mouseX = event.getX();
                mouseY = event.getY();
                game.handleClick(event);
            }
        });


        root.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                held = true;
            }
        });


        root.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                held = false;
            }
        });

        root.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println(event);
                game.handleKeyPress(event);
            }
        });

        root.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println("why?!");
                System.out.println(event);
            }
        });

        root.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println(event);
            }
        });

        root.setOnKeyPressed( (event -> System.out.println(event)));

        root.addEventHandler(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                game.handleScroll(event);
            }
        });
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
