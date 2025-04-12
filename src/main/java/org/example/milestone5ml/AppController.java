package org.example.milestone5ml;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class AppController {
    @FXML
    private TabPane ctabframe;

    @FXML
    public void onNewFileButtonClick(){

        MachineFileGui m = new MachineFileGui("new file");
        ctabframe.getTabs().add(m.getTab());
    }
}