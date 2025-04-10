package org.example.milestone5ml;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MachineFileGui {

    //will import machine when functionality is added

    Tab mactab;

    public MachineFileGui(){
        //constructor needs to create everything in the gui from a new file button.
        //currently modeled after the "file1" tab in the fxml file

        mactab = new Tab(); //tab that holds tabpane frame
        //apologies for the confusing language here. Each File opened will hold a tab, and each
        //file tab will hold a tabframe that holds run, command, and textbox machine tabs.
        //mactab is the highest level tab that will be added to the programs permanent
        //central tabframe.

        TabPane tpframe = new TabPane();//frame that holds all machine tabs

        Tab runtab = new Tab();//Run Tab
        //todo: create all necessary command tab architecture

        //todo: assemble all above architecture

        Tab cmtab = new Tab();//Command Tab
        //todo: create all necessary command tab architecture

        //todo: assemble all above architecture

        Tab txttab = new Tab();//Textbox Tab
        //todo: create all necessary txtbox tab architecture

        //todo: assemble all above archtecture


        //assemble machine tabs into machine tabpane into file tab (again sorry about this one)
        //tpframe.getChildren().addAll(runtab, cmtab, txttab);
        tpframe.getTabs().add(runtab);
        tpframe.getTabs().add(cmtab);
        tpframe.getTabs().add(txttab);

        mactab.setContent(tpframe);

    }

    Tab getTab(){
        return mactab;
    }
}
