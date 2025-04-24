package org.example.milestone5ml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class AppController {
    @FXML
    private TabPane ctabframe;

    @FXML
    public void onNewFileButtonClick(){

        MachineFileGui m = new MachineFileGui("new file");
        ctabframe.getTabs().add(m.getTab());
    }

    @FXML
    public void onOpenFileButtonClick(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Machine Language File");
        File selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile != null){
            MachineFileGui m = new MachineFileGui(selectedFile);
            ctabframe.getTabs().add(m.getTab());
        }
    }


    @FXML
    VBox background1;
    @FXML
    HBox interior;


    @FXML
    protected void onSettingButtonClick() throws IOException {
        openSettingsWindow();
    }

    public void applyColor(Color color1, Color color2){
        interior.setBackground(Background.fill(color2));
        background1.setBackground(Background.fill(color1));
    }
    @FXML
    private void openSettingsWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("setting.fxml"));
        //Parent root = fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.load(),400, 250);

        SettingsController settingsController = fxmlLoader.getController();
        settingsController.setMainController(this);

        Stage stage = new Stage();
        stage.setTitle("Settings");
        stage.setScene(scene);
        stage.show();
    }
}