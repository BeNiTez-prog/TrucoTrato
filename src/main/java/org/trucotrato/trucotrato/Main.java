package org.trucotrato.trucotrato;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("entrada.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("halloween.css").toExternalForm());
        primaryStage.setTitle("Túnel del Terror");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
