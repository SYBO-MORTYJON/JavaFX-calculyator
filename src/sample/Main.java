package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator.app");
        primaryStage.setOnCloseRequest(x -> {
            Platform.exit();
        });
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 280, 300));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
