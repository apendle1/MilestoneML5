package org.example.milestone5ml;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class MachineTabController {

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
            System.out.println(a.get(i).toString());
            m.memory.setWordSingle(i, a.get(i).getValue()); //add all visual gui to machine memory
        }
    }

    /*public void addMLPlainText(){
        ArrayList<WordGui> a = MLApplication.GuiMemory;
        for(int i = 0; i < a.size(); i++){
            fileInputArea.appendText(a.get(i).getStringValue() +"\n");
        }
    }*/

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

    }
    Button runButton;

    public void setRunButton(Button runButton) {
        this.runButton = runButton;
    }

    public void onRunButtonClick(){
        ArrayList<WordGui> a = mf.GuiMemory;

        for(WordGui i : a){
            System.out.println(i.getValue());
            if(i.getStringValue().equals("-99999")){
                i.setValue("+4300");
            }
        }
        m = new Machine();
        try{
            MemGuiToMachine();
            returnString = m.run();
            ACCIDXLabel.setText("ACC: "+m.accumulator+"    "+"IDX: "+m.index);
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
