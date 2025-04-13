package org.example.milestone5ml;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MachineTabController {

    int numlength = 6; //by default we should be displaying 6 digit words

    Machine m;
    String returnString="";
    MachineFileGui mf;

    public MachineTabController(MachineFileGui instance){
         mf = instance;
        m = new Machine();
    }
    // this is the controller for anything in the MachineFileGui
    public Text OutputArea;
    public void MemGuiToMachine(){
        //THIS ASSUMES ALL MEMORY IS VALID WORDS. PLEASE RUN A VALIDITY CHECK BEFORE USING
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = 0; i < 100; i++){//change to size
            //System.out.println(a.get(i).toString());
            m.memory.setWordSingle(i, a.get(i).getValue()); //add all visual gui to machine memory
        }
    }

    public TextArea fileInputArea;
    public void setFileInputArea(TextArea fileInputArea){
        this.fileInputArea = fileInputArea;
        if(fileInputArea == null){ System.out.println("list is null"); }
    }

    public void addMLPlainText(){
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = 0; i < a.size(); i++){
            if(fileInputArea == null){ System.out.println("list is null"); }
            fileInputArea.appendText(a.get(i).getStringValue() +"\n");
        }
    }

    public void SetOutputArea(Text outputArea) {
        OutputArea = outputArea;
    }

    public Label ACCIDXLabel;
    public void setACCIDXLabel(Label ACCIDXLabel) {
        this.ACCIDXLabel = ACCIDXLabel;
    }
    public TextArea InputArea;
    public void setInputArea(TextArea InputArea) {
        this.InputArea = InputArea;
    }

    protected void loadFile(File selectedFile, ArrayList<WordGui> a) {
        try {
            int index = 0;
            Scanner sc = new Scanner(selectedFile);
            while (sc.hasNextLine() && index < 100) {
                String line = sc.nextLine();
                a.get(index).setValue(line);
                index++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        addMLPlainText();
    }
    Button saveButton;

    public void setSaveButton(Button saveButton){
        this.saveButton = saveButton;
    }

    public void onSaveButtonClick(){
        Stage stage = (Stage) saveButton.getScene().getWindow(); // Get the current window

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File fileToSave = fileChooser.showSaveDialog(stage);

        if (fileToSave != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                for (WordGui wordGui : mf.GuiMemory) {
                    writer.write(wordGui.getStringValue() + "\n"); // Save each value
                }
                writer.flush();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("File saved successfully: " + fileToSave.getAbsolutePath());
                alert.showAndWait();
            } catch (IOException e) {
                Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Error saving file: " + e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

    Button runButton;

    public void setRunButton(Button runButton) {
        this.runButton = runButton;
    }

    Text comrunlist;

    public void setComRunList(Text a){
        this.comrunlist = a;
    }

    public void onRunButtonClick(){
        ArrayList<WordGui> a = mf.GuiMemory;

        for(WordGui i : a){
            if(i.getStringValue().equals("-99999")){
                i.setValue("+4300");
            }
        }
        m = new Machine();
        try{
            MemGuiToMachine();
            returnString = m.run();
            ACCIDXLabel.setText("ACC: "+m.accumulator+"    "+"IDX: "+m.index);
            String tbstring = "";
            int id = 0;
            for(int i : m.memory.getWordlist()){
                tbstring = tbstring + String.format("%03d", id) + ": " + String.format("%+07d", i) + "\n";
                id++;
            }
            comrunlist.setText(tbstring);


            if(m.awaitingRead) {
                OutputArea.setText(OutputArea.getText() + returnString);
                InputArea.setOnKeyReleased(event -> handleKeyRelease(event, 4));
            } else {
                OutputArea.setText(OutputArea.getText() + returnString);
            }
        } catch(Exception e){
            OutputArea.setText(OutputArea.getText() + "Cannot Run: Illegal Line\n");
        }
    }

    public void onSubmitfileButtonclick(){
        Scanner scan = new Scanner (fileInputArea.getText());
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = 0; i < a.size(); i++){
            a.get(i).setValue(scan.nextLine());
        }
    }

    private void handleKeyRelease(KeyEvent keyEvent, int len){
        ACCIDXLabel.setText("ACC: "+m.accumulator+"    "+"IDX: "+m.index);
        if (keyEvent.getCode() == KeyCode.ENTER) {
            String userInput = InputArea.getText().trim();
            InputArea.clear();
            try {
                if (userInput.length() <= len) {
                    int word = Integer.parseInt(userInput);
                    OutputArea.setText(OutputArea.getText() + "User entered " + word + "\n");
                    returnString = "";
                    ACCIDXLabel.setText("ACC: "+m.accumulator+"    "+"IDX: "+m.index);
                    m.read(word);
                } else {
                    OutputArea.setText(OutputArea.getText() + "Invalid input. Must be a "+ len +"-digit number.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println(userInput);
                OutputArea.setText(OutputArea.getText() + "User input is not a number. Try again\n");
            }
            returnString = m.run2();
            OutputArea.setText(OutputArea.getText() + returnString);
            ACCIDXLabel.setText("ACC: "+m.accumulator+"    "+"IDX: "+m.index);
            String tbstring = "";
            int id = 0;
            for(int i : m.memory.getWordlist()){
                tbstring = tbstring + String.format("%03d", id) + ": " + String.format("%+07d", i) + "\n";
                id++;
            }
            comrunlist.setText(tbstring);
        }
    }

    Button addlineButton;

    public void setAddLineButton(Button addlineButton){
        this.addlineButton = addlineButton;
    }

    protected void onAddButtonClick(){
        System.out.println(AmountOfSelectedWordGui());
        System.out.println(AmountOfAvailableLines());
        if(AmountOfSelectedWordGui() == 0){
            OutputArea.setText(OutputArea.getText() + "No Selected Locations\n");
            return;
        }
        if(AmountOfSelectedWordGui() > AmountOfAvailableLines()){
            OutputArea.setText(OutputArea.getText() + "Not enough blank lines at the end for requested addition\n");
            return;
        }
        ArrayList<WordGui> a = mf.GuiMemory;
        AddLine(3);
        for(int i = 99; i > -1; i--){
            if(a.get(i).isChecked()){
                AddLine(i);
            }
        }
        for(WordGui i : a){
            i.deselect();
        }
    }

    public void AddLine(int index){
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = 99; i > index; i--){
            String storage = a.get(i - 1).getStringValue();
            a.get(i).setValue(storage);
        }
        a.get(index).setValue("+0000");
    }

    Button dellineButton;

    public void setDelLineButton(Button dellineButton){
        this.dellineButton = dellineButton;
    }

    protected void onDeleteButtonClick(){
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = 99; i > -1; i--){
            if(a.get(i).isChecked()){
                DeleteLine(i);
            }
        }
        for(WordGui i : a){
            i.deselect();
        }
    }

    public void DeleteLine(int index){
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = index; i < 99; i++){
            String storage = a.get(i + 1).getStringValue();
            a.get(i).setValue(storage);
        }
        a.get(99).setValue("+0000");
    }

    public int AmountOfAvailableLines(){
        ArrayList<WordGui> a = mf.GuiMemory;
        for(int i = 99; i > 0; i--){
            if(!a.get(i).getStringValue().equals("+0000")){
                System.out.println(a.get(i).getStringValue());
                return 99 - i;
            }
        }
        return 99;
    }

    public int AmountOfSelectedWordGui(){
        ArrayList<WordGui> a = mf.GuiMemory;
        int b = 0;
        for(int i = 99; i > -1; i--){
            if(a.get(i).isChecked()){
                b++;
            }
        }
        return b;
    }
}
