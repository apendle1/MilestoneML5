package org.example.milestone5ml;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class SettingsController {
    private AppController mainController;

    public void setMainController(AppController mainController) {
        this.mainController = mainController;
    }
    @FXML
    ColorPicker primaryColor;
    @FXML
    ColorPicker secondaryColor;
    @FXML
    protected void onSubmitColorButtonClick(){
        Color color1 = primaryColor.getValue();
        Color color2 = secondaryColor.getValue();
        mainController.applyColor(color1, color2);
    }

    public AppController getMainController() {
        return mainController;
    }
}
