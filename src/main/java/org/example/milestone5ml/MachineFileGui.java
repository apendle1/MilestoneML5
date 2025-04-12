package org.example.milestone5ml;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MachineFileGui {

    //will import machine when functionality is added

    Tab mactab;

    public MachineFileGui(String filename){
        //constructor needs to create everything in the gui from a new file button.
        //currently modeled after the "file1" tab in the fxml file

        mactab = new Tab(); //tab that holds tabpane frame
        mactab.setText(filename);
        //apologies for the confusing language here. Each File opened will hold a tab, and each
        //file tab will hold a tabframe that holds run, command, and textbox machine tabs.
        //mactab is the highest level tab that will be added to the programs permanent
        //central tabframe.

        TabPane tpframe = new TabPane();//frame that holds all machine tabs

        Tab runtab = new Tab();//Run Tab
        runtab.setText("Run");
        //todo: create all necessary command tab architecture
        HBox rthbcontainer = new HBox();
        rthbcontainer.setSpacing(20.0);
        rthbcontainer.setPadding(new Insets(20, 20, 20, 20));
        VBox rthbvcontainer = new VBox();
        rthbvcontainer.setSpacing(20.0);
        TextArea rtinput = new TextArea();
        ScrollPane rtoutputpane = new ScrollPane();
        rtoutputpane.setPrefHeight(300);
        Text outputarea = new Text();
        Button runbutton = new Button();
        runbutton.setText("Run");
        ScrollPane rtcommandpane = new ScrollPane();
        rtcommandpane.setPrefWidth(400);
        Text rtcommandtext = new Text();

        //todo: assemble all above architecture
        rtcommandpane.setContent(rtcommandtext);//command list -> command scrollpane
        rtoutputpane.setContent(outputarea);//output text -> output scrollpane
        rthbvcontainer.getChildren().addAll(rtinput, rtoutputpane, runbutton);//run interface
        rthbcontainer.getChildren().addAll(rthbvcontainer, rtcommandpane);//interface and command panes -> tab
        runtab.setContent(rthbcontainer);

        Tab cmtab = new Tab();//Command Tab
        cmtab.setText("Command View");
        //todo: create all necessary command tab architecture
        VBox ctvbcontainer = new VBox();
        ctvbcontainer.setPadding(new Insets(20, 20, 20, 20));
        ctvbcontainer.setAlignment(Pos.TOP_LEFT);
        ctvbcontainer.setSpacing(20.0);
        ScrollPane ctcommandpane = new ScrollPane();
        ctcommandpane.setPrefWidth(600);
        ctcommandpane.setPrefHeight(415);
        VBox memcontainer = new VBox();
        HBox cthbtoolbar = new HBox();
        cthbtoolbar.setSpacing(10.0);
        cthbtoolbar.setAlignment(Pos.BASELINE_LEFT);
        Button ctaddline = new Button();
        ctaddline.setText("Add Line");
        Button ctdelline = new Button();
        ctdelline.setText("Delete Line");
        Button ctsubmit = new Button();
        ctsubmit.setText("Submit");
        Label accidxlabel = new Label();
        accidxlabel.setText("ACC: 0000    IDX: 0000");

        //todo: assemble all above architecture
        ctcommandpane.setContent(memcontainer);
        cthbtoolbar.getChildren().addAll(ctaddline, ctdelline, ctsubmit, accidxlabel);
        ctvbcontainer.getChildren().addAll(ctcommandpane, cthbtoolbar);
        cmtab.setContent(ctvbcontainer);

        Tab txttab = new Tab();//Textbox Tab
        txttab.setText("Textbox View");
        //todo: create all necessary txtbox tab architecture

        //todo: assemble all above archtecture


        //assemble machine tabs into machine tabpane into file tab (again sorry about this one)
        tpframe.getTabs().add(runtab);
        tpframe.getTabs().add(cmtab);
        tpframe.getTabs().add(txttab);

        mactab.setContent(tpframe);

    }

    Tab getTab(){
        return mactab;
    }
}
