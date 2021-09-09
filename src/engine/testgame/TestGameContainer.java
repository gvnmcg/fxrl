package engine.testgame;

import javafx.application.Application;
import javafx.stage.Stage;

public class TestGameContainer extends Application {

    @Override
    public void start(Stage stage){
        new TestGame(stage);
    }
}
