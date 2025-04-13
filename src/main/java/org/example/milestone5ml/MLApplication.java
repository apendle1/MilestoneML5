package org.example.milestone5ml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MLApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MLApplication.class.getResource("MLApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("MLApp");
        stage.setScene(scene);
        stage.show();

        //ctabframe
        //VBox v = (VBox)scene.lookup("#MemContainer");

        TabPane c = (TabPane)scene.lookup("#ctabframe");

        MachineFileGui m = new MachineFileGui("new file");
        c.getTabs().add(m.getTab());

        TextArea t = (TextArea)scene.lookup("#rm");
        try{
            File file = new File("README.md");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                t.setText(t.getText() + sc.nextLine() + "\n");
            }
            sc.close();
        } catch(Exception e){
            System.out.println("didn't find it");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}