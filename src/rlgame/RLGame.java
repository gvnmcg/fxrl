package rlgame;

import engine.AbstractGame;
import engine.GameData;
import engine.GameObject;
import engine.GameScreen;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Random;

/**
 * Purpose  - The root of the RL Game
 *          - Renders w/r/t Game Screens
 */
public class RLGame extends AbstractGame {

    private GameObject player = new GameObject(3,3);
//    private GameObject nextTile = new GameObject(3,3);

//    private LinkedList<String> actions = new LinkedList<>();

    private Random random = new Random();
    private Image ground = new Image("file:sheep/assets/grnd.png");

    //screen modes
    private boolean handleGameScreen = false;
    private GameScreen gameScreen = null;
    RLRenderer rlRenderer;

    //feature flags
    private boolean readLevelFlag = false;

    final private int SCALE = 20;

    boolean renderDebugflag = true;
    boolean DEBUG = true;
    String debugData = "debug";

    RLGame(Stage stage) {
        super(stage, RLRenderer.WIDTH, RLRenderer.HEIGHT);
        gameData = new GameData(RLRenderer.WIDTH, RLRenderer.HEIGHT);
        rlRenderer = new RLRenderer(g, RLRenderer.WIDTH, RLRenderer.HEIGHT, gameData );

        //spawn player
        gameData.addObject(RLGameData.PLAYER, player);

        GameObject go;
        // just make some markers

        // 600 / 20 = 30,
        // 20 px, #30
        for (int i = 0; i < 30; i++) {
            //400 / 20 = 20
            for (int j = 0; j < 20; j++) {

                go = new GameObject( i, j, 15, 15);
                gameData.addObject(RLGameData.MARK, go );
            }
        }
        System.out.println("list size "+gameData.getList(RLGameData.MARK).size());

        timer.start();

    }

    @Override
    public void update() {

        if (handleGameScreen) {
            gameScreen.update();
            return;
        }

    }


    @Override
    public void render() {


        if (handleGameScreen) {
            debugData = "gamescreen: " + gameScreen.toString();
            gameScreen.render();
            return;
        }


        // render Background
        renderBackground(Color.LIGHTBLUE);

        //render all relevent game data
        String key = RLGameData.MARK;
        rlRenderer.renderList(key);

        // test marker
        g.setFill(Color.LIGHTGREEN);
        g.fillRect(20,20,50,50);

        // render debug text
        g.setFill(Color.BLACK);
        g.fillText(debugData, 10, 10);
    }

    @Override
    public void handleClick(MouseEvent event) {

        if (handleGameScreen) {
            gameScreen.handleClick(event);

            if (gameScreen.isDone()) {
                handleGameScreen = false;
                gameScreen = null;
            }

            return;
        }

    }
//
//    private void handleMove(MouseEvent event) {
//
//    }

    @Override
    public void handleDrag(MouseEvent event) {

        if (handleGameScreen) {
            gameScreen.handleDrag(event);
            return;
        }

        if (event.getButton() == MouseButton.PRIMARY) {
//            handleMove(event);
        }
    }

    @Override
    public void handleKeyPress(KeyEvent event) {

        if (handleGameScreen) {
            gameScreen.handleKeyPress(event);
            return;
        }

        System.out.println(event);

    }

    @Override
    public void handleScroll(ScrollEvent event) {

//        if (event.getDeltaY() > 0) {
//            actions.add(actions.removeFirst());
//        } else if (event.getDeltaY() < 0) {
//            actions.addFirst(actions.removeLast());
//        }
    }

    @Override
    public void renderBackground() {
        g.drawImage(ground, 0, 0);
    }

    public static void main(String[] args) {
//        new TestLevel();
    }
}
