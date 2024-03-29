package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root, 730, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
