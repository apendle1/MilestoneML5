package org.example.milestone5ml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;

import java.io.IOException;

public class MLApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MLApplication.class.getResource("MLApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("MLApp");
        stage.setScene(scene);
        stage.show();

        TabPane c = (TabPane)scene.lookup("#ctabframe");

        MachineFileGui m = new MachineFileGui("new file");
        c.getTabs().add(m.getTab());
    }

    public static void main(String[] args) {
        launch();
    }
}