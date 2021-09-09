package rlgame;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
////        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//
//        Group root = new Group();
//
//        root.getChildren().add(new Circle(100,100,100, Color.BLACK));
////        Canvas root = new Canvas();
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//
//
//    }

//    AbstractGame game;

    @Override
    public void start(Stage primaryStage) {
        new RLGame(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
