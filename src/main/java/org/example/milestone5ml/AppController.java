package org.example.milestone5ml;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AppController {

    public AppController (){

    }
    //this is the controller for anything in the fxml file
    @FXML
    protected void onNewFileButtonClick() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Machine Language File");
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            MachineFileGui mf = new MachineFileGui(selectedFile);

            //MemMachineToGui();
            //addMLPlainText();
        }
    }




}