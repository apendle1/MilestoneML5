package org.example.milestone5ml;

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Arrays;



import java.io.File;

public class MachineFileGui {

    final int MEMORY_LENGTH = 250;
    private static MachineFileGui instance;
    public  ArrayList<WordGui> GuiMemory;

    //will import machine when functionality is added

    Tab mactab;
    public MachineTabController MController;
    public MachineFileGui(String filename) {
        MController = new MachineTabController(instance);
        mactab = new Tab();
        mactab.setText(String.valueOf(filename));

        GuiMemory = new ArrayList<WordGui>();
        for(int i = 0; i < MEMORY_LENGTH; i++){
            GuiMemory.add(new WordGui(i));
        }
        createFramework();
    }
    public MachineFileGui(File filename) {
        instance = this;
        MController = new MachineTabController(instance);
        mactab = new Tab(); //tab that holds tabpane frame
        mactab.setText(String.valueOf(filename));

        GuiMemory = new ArrayList<WordGui>();
        for(int i = 0; i < MEMORY_LENGTH; i++){
            GuiMemory.add(new WordGui(i));
        }
        MController.loadFile(filename, GuiMemory);

        createFramework();
    }
    public void createFramework(){
        //constructor needs to create everything in the gui from a new file button.
        //currently modeled after the "file1" tab in the fxml file


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
        HBox rthbvtoolbox = new HBox();
        rthbvtoolbox.setSpacing(10.0);
        rthbvtoolbox.setAlignment(Pos.BASELINE_LEFT);
        TextArea rtinput = new TextArea();
        MController.setInputArea(rtinput);
        ScrollPane rtoutputpane = new ScrollPane();
        rtoutputpane.setPrefHeight(300);
        Text outputarea = new Text();
        MController.SetOutputArea(outputarea);
        Button runbutton = new Button();
        MController.setRunButton(runbutton);
        runbutton.setOnAction(event -> MController.onRunButtonClick());
        runbutton.setText("Run");
        ScrollPane rtcommandpane = new ScrollPane();
        rtcommandpane.setPrefWidth(400);
        Text rtcommandtext = new Text();
        Label accidxlabel = new Label();
        MController.setACCIDXLabel(accidxlabel);
        accidxlabel.setText("ACC: 0000    IDX: 0000");
        Button savebutton = new Button();
        savebutton.setText("Save");
        MController.setSaveButton(savebutton);
        savebutton.setOnAction(event -> MController.onSaveButtonClick());

        //todo: assemble all above architecture
        rtcommandpane.setContent(rtcommandtext);//command list -> command scrollpane
        rtoutputpane.setContent(outputarea);//output text -> output scrollpane
        rthbvtoolbox.getChildren().addAll(runbutton, savebutton, accidxlabel);
        rthbvcontainer.getChildren().addAll(rtinput, rtoutputpane, rthbvtoolbox);//run interface
        rthbcontainer.getChildren().addAll(rthbvcontainer, rtcommandpane);//interface and command panes -> tab
        runtab.setContent(rthbcontainer);

        Tab cmtab = new Tab();//Command Tab
        cmtab.setText("Command View");
        //todo: create all necessary command tab architecture
        VBox ctvbcontainer = new VBox();
        ctvbcontainer.setPadding(new Insets(20, 20, 20, 20));
        ctvbcontainer.setAlignment(Pos.TOP_LEFT);
        ctvbcontainer.setSpacing(20.0);
        //ScrollPane ctcommandpane = new ScrollPane();
        //ctcommandpane.setPrefWidth(600);
        //ctcommandpane.setPrefHeight(415);
        //VBox memcontainer = new VBox();
        ListView<HBox> ctcommandpane = new ListView<HBox>();
        HBox cthbtoolbar = new HBox();
        cthbtoolbar.setSpacing(10.0);
        cthbtoolbar.setAlignment(Pos.BASELINE_LEFT);
        Button ctaddline = new Button();
        ctaddline.setText("Add Line");
        Button ctdelline = new Button();
        ctdelline.setText("Delete Line");
        Button ctsubmit = new Button();
        ctsubmit.setText("Submit");

        //todo: assemble all above architecture

        for (int i = 0; i < GuiMemory.size(); i++){
            //memcontainer.getChildren().addAll(GuiMemory.get(i).gethbox());
            ctcommandpane.getItems().add(GuiMemory.get(i).gethbox());
        }

        //ctcommandpane.setContent(memcontainer);
        cthbtoolbar.getChildren().addAll(ctaddline, ctdelline, ctsubmit);
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
