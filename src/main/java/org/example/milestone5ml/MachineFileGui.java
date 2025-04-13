package org.example.milestone5ml;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.ListView;

import java.util.ArrayList;


import java.io.File;

public class MachineFileGui {

    final int MEMORY_LENGTH = 250;
    private static MachineFileGui instance;
    public  ArrayList<WordGui> GuiMemory;

    //will import machine when functionality is added

    Tab mactab;
    public MachineTabController MController;
    public MachineFileGui(String filename) {
        instance = this;
        MController = new MachineTabController(instance);
        mactab = new Tab();
        mactab.setText(filename);

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
        createFramework();
        MController.loadFile(filename, GuiMemory);

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
        runtab.setClosable(false);
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

        ScrollPane rtoutputpane = new ScrollPane();
        rtoutputpane.setPrefHeight(300);
        Text outputarea = new Text();

        Button runbutton = new Button();

        runbutton.setOnAction(event -> MController.onRunButtonClick());
        runbutton.setText("Run");
        ScrollPane rtcommandpane = new ScrollPane();
        rtcommandpane.setPrefWidth(400);
        Text rtcommandtext = new Text();
        rtcommandtext.setFont(Font.font("Courier"));
        MController.setComRunList(rtcommandtext);
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
        MController.setInputArea(rtinput);

        Tab cmtab = new Tab();//Command Tab
        cmtab.setClosable(false);
        cmtab.setText("Command View");
        MController.setRunButton(runbutton);
        MController.SetOutputArea(outputarea);
        //todo: create all necessary command tab architecture
        VBox ctvbcontainer = new VBox();
        ctvbcontainer.setPadding(new Insets(20, 20, 20, 20));
        ctvbcontainer.setAlignment(Pos.TOP_LEFT);
        ctvbcontainer.setSpacing(20.0);
        ListView<HBox> ctcommandpane = new ListView<HBox>();
        HBox cthbtoolbar = new HBox();
        cthbtoolbar.setSpacing(10.0);
        cthbtoolbar.setAlignment(Pos.BASELINE_LEFT);
        Button ctaddline = new Button();
        ctaddline.setText("Add Line");
        MController.setAddLineButton(ctaddline);
        ctaddline.setOnAction(event -> MController.onAddButtonClick());
        Button ctdelline = new Button();
        ctdelline.setText("Delete Line");
        MController.setDelLineButton(ctdelline);
        ctdelline.setOnAction(event -> MController.onDeleteButtonClick());
        Button ctsubmit = new Button();
        ctsubmit.setText("Sync With Textbox View");
        ctsubmit.setOnAction(event -> MController.onCTSubmitButtonClick());

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
        txttab.setClosable(false);
        txttab.setText("Textbox View");
        //todo: create all necessary txtbox tab architecture
        HBox txthbox = new HBox();
        txthbox.setAlignment(Pos.TOP_CENTER);
        txthbox.setSpacing(20.0);
        VBox txtvbox = new VBox();
        txtvbox.setId("interior4");
        txtvbox.setAlignment(Pos.TOP_LEFT);
        txtvbox.setSpacing(20.0);
        txtvbox.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));
        TextArea descriptionArea = new TextArea("file in text view. Each line is a new MLcommand. When submit is clicked file will be sync and run with new commands. Only accepts first 250 lines.");
        descriptionArea.setMaxHeight(50);
        descriptionArea.setWrapText(true);
        descriptionArea.setEditable(false);
        TextArea fileInputArea = new TextArea();

        fileInputArea.setId("fileInputArea");
        Button txtfilesubmitButton = new Button("Sync With Command View");
        txtfilesubmitButton.setOnAction(event -> MController.onSubmitfileButtonclick());
        //todo: assemble all above archtecture
        txtvbox.getChildren().addAll(descriptionArea, fileInputArea, txtfilesubmitButton);
        txthbox.getChildren().add(txtvbox);
        txttab.setContent(txtvbox);
        //assemble machine tabs into machine tabpane into file tab (again sorry about this one)
        tpframe.getTabs().add(runtab);
        tpframe.getTabs().add(cmtab);
        tpframe.getTabs().add(txttab);

        mactab.setContent(tpframe);
        MController.setFileInputArea(fileInputArea);
        MController.onCTSubmitButtonClick();

    }

    Tab getTab(){
        return mactab;
    }



}
