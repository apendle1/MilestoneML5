package org.example.milestone5ml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MLApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MLApplication.class.getResource("MLApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("MLApp");
        stage.setScene(scene);
        stage.show();

        //ctabframe
        //VBox v = (VBox)scene.lookup("#MemContainer");

        TabPane c = (TabPane)scene.lookup("#ctabframe");

        TextArea t = (TextArea)scene.lookup("#rm");
        String text = "# MilestoneML5\n" +
                "## Objective:\n" +
                "\n" +
                "#### Our goal is to create a program in java that works as a simple virtual machine. It will be capable of performing basicML programs. The purpose of this program is to teach students CS principles.\n" +
                "\n" +
                "#### The program has five classes:  WordGui, AppController, MachineTabcontroller MLApplication, Machine, and Memory. WordGui and MLapplication work together to create the GUI. The AppController and MachineTabController bridges the gap between machine and the GUI, so that all the buttons work and the information displays. The two functions in Machine that pull everything together are Parse and Run. Parse organizes the file into a readable format for the run function. Run goes through each basicML command and calls a use case depending on the contents of the command.\n" +
                "\n" +
                "## How to Run Our Program on your Computer:\n" +
                "1. check that you have java installed\n" +
                "3. To manually run the program click on the zipfile(This option will only work with macBook. it may think the program is a virus go to System Prefernces-> privacy-> scroll down to open anyways). We assumed you have a MacBook, if you have windows it will have to be opened through a compiler.\n" +
                "4. Then go to bin. Then double click on app(it should open up through the terminal).\n" +
                "5. A window should appear you can now either update the list of commands by clicking in the boxes with numbers or click the file button to upload a file.\n" +
                "6. Once the file is done uploading you can now click run the output text box will inform you of anything you have to enter in the input text box\n" +
                "7. If the file does not run after clicking the run button, check the discriptions next to the list of commands(The descriptions will say whether the command is valid or not)\n" +
                "8. The output field will keep you updated on when the program is finished\n" +
                "## Navigating our program\n" +
                "At first glance you will see a tab system and two buttons\n" +
                "<p>\n" +
                "  The two buttons:  </p>\n" +
                "\n" +
                "- new file will create a new file tab that you can enter in new commands\n" +
                "- open file will allow you to open an existing file from your computer\n" +
                "\n" +
                "<p>\n" +
                "  The tab system: </p>\n" +
                "\n" +
                "- Readme contains a breif discription of what is in this document\n" +
                "- settings allows you to change the color scheme\n" +
                "- all subsequent tabs are files\n" +
                "\n" +
                "<p>\n" +
                "  File Tabs </p>\n" +
                "\n" +
                "- When you click on a file an additional tab system will appear\n" +
                "- run contains an input and output field and a run a and save button\n" +
                "- command view contains a view of all the commands with descriptions\n" +
                "- textbox View contians a view of all the commands without the commands in their own text\n" +
                "  areas so that multiple commands can be pasted at once\n" +
                "\n" +
                "## Running Test Files\n" +
                "1. Open a interpreter for java\n" +
                "2. Navigate to the test files and run\n" +
                "\n" +
                "## How to copy and paste\n" +
                "1. At the top of the page there will be three tabs click on the tab that says \"Textbox View\"\n" +
                "2. This window contains all commands saved from file or inputed in a text box and allows text to be easily copy and pasted\n" +
                "3. Copy and paste the input and ensure that it is formatted correctly(ie. one 4 letter command per line)\n" +
                "4. click submit\n" +
                "5. The commands will now be saved and appear on this tab and the run tab.\n" +
                "## Changing Colors\n" +
                "1. At the top of the page there will be three tabs click on the tab that says \"Settings\"\n" +
                "2. There will be two drop down labeled primary and secondary color.\n" +
                "3. Select your desired colors and click submit\n" +
                "4. If you want to go back to the default colors click reset.\n" +
                "## Adding and deleting new Mlcommand lines\n" +
                "1. At the top of the page there will be three tabs make sure you are on the tab that is labeled \"run\"\n" +
                "2. On the page to the right there will be a scroll pane that lists all the commands loaded\n" +
                "3. Beneath that there will be three buttons \"add line\", \"delete line\", and \"submit changes\"\n" +
                "4. To add a new command select a box and click add line and a new line to type command in a will be added to the above the selected command\n" +
                "5. To remove a command select a box click delete command and the line will be removed\n" +
                "6. To edit current commands type into one of the text boxes and type in your new command. After click submit changes\n" +
                "\n";
                t.setText(text);
    }

    public static void main(String[] args) {
        launch();
    }
}