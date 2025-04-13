package org.example.milestone5ml;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;

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

        MachineFileGui m = new MachineFileGui(selectedFile);
        ctabframe.getTabs().add(m.getTab());
    }

    @FXML
    ColorPicker primaryColor;
    @FXML
    ColorPicker secondaryColor;
    @FXML
    VBox background1;
    @FXML
    HBox interior3;
    @FXML
    HBox interior;
    @FXML
    VBox interior2;
    @FXML
    protected void onSubmitColorButtonClick(){
        Color color1 = primaryColor.getValue();
        Color color2 = secondaryColor.getValue();
        interior2.setBackground(Background.fill(color2));
        interior3.setBackground(Background.fill(color2));
        interior.setBackground(Background.fill(color2));
        background1.setBackground(Background.fill(color1));
    }
}