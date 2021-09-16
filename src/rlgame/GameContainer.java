package rlgame;

import engine.AbstractGame;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * creates Game, in this case RLGame
 */
public class GameContainer extends Application {

//    AbstractGame game;

    @Override
    public void start(Stage primaryStage) {

        int SCALE = 20;
        int NUM_H = 30;
        int NUM_W = 20;


//    final static int WIDTH = 600;
//    final static int HEIGHT = 400;
        int WIDTH = NUM_W * SCALE;
        int HEIGHT = NUM_H * SCALE;
        new RLGame(primaryStage, WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
