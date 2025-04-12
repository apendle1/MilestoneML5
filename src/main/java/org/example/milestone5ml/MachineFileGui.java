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
    static ArrayList<WordGui> GuiMemory;
    final int MEMORY_LENGTH = 250;

    //will import machine when functionality is added

    Tab mactab;
    public MachineTabController MController;
    public MachineFileGui(String filename) {
        MController = new MachineTabController();
        mactab = new Tab();
        mactab.setText(String.valueOf(filename));

        createFramework();
    }
    public MachineFileGui(File filename) {
        MController = new MachineTabController();
        mactab = new Tab(); //tab that holds tabpane frame
        mactab.setText(String.valueOf(filename));
        MController.loadFile(filename);
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
        Label accidxlabel = new Label();
        MController.setACCIDXLabel(accidxlabel);
        accidxlabel.setText("ACC: 0000    IDX: 0000");

        //todo: assemble all above architecture

        GuiMemory = new ArrayList<WordGui>();
        for(int i = 0; i < MEMORY_LENGTH; i++){
            GuiMemory.add(new WordGui(i));
        }
        for (int i = 0; i < GuiMemory.size(); i++){
            //memcontainer.getChildren().addAll(GuiMemory.get(i).gethbox());
            ctcommandpane.getItems().add(GuiMemory.get(i).gethbox());
        }

        //ctcommandpane.setContent(memcontainer);
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
/*
<Tab text="Run" closable="false">
                    <HBox spacing="20.0">
                        <padding>
                            <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
                        </padding>
                        <VBox fx:id="interior3" spacing = "20.0">
                            <TextArea fx:id="InputArea"/>
                            <ScrollPane prefHeight="300">
                                <Text fx:id="OutputArea"></Text>
                            </ScrollPane>
                            <Button text="Run"/>
                        </VBox>
                        <ScrollPane prefWidth="400">
                            <Text>eh</Text>
                        </ScrollPane>
                    </HBox>
                </Tab>
                <Tab text="Command View" closable="false">
                    <VBox fx:id="interior1" alignment="TOP_LEFT" spacing="20.0">
                        <ScrollPane prefWidth="600" prefHeight="415">
                            <VBox fx:id="MemContainer">
                            </VBox>
                        </ScrollPane>
                        <HBox spacing="10.0">
                            <Button text="Add Line"/>
                            <Button text="Delete Line"/>
                            <Button text="Submit"/>
                            <Label fx:id="ACCIDXLabel">ACC: 0000    IDX: 0000</Label>
                        </HBox>
                    </VBox>
                </Tab>
                <Tab text="Textbox View" closable="false">
                    <HBox  alignment="TOP_CENTER" spacing= "20.0">
                        <VBox fx:id="interior4" alignment="TOP_LEFT" spacing="20.0">
                            <padding>
                                <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
                            </padding>
                            <TextArea text="file in text version. Each line is a new MLcommand. Edits to text edit run code." maxHeight="40"/>
                            <TextArea fx:id="fileInputArea"/>
                            <Button text ="submit"/>
                        </VBox>
                    </HBox>
                </Tab>
 */
