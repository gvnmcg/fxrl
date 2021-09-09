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
        new RLGame(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
