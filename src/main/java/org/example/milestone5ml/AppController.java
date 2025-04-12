package org.example.milestone5ml;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
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
}