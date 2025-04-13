# MilestoneML5
## Objective:

#### Our goal is to create a program in java that works as a simple virtual machine. It will be capable of performing basicML programs. The purpose of this program is to teach students CS principles.

#### The program has five classes:  WordGui, AppController, MachineTabcontroller MLApplication, Machine, and Memory. WordGui and MLapplication work together to create the GUI. The AppController and MachineTabController bridges the gap between machine and the GUI, so that all the buttons work and the information displays. The two functions in Machine that pull everything together are Parse and Run. Parse organizes the file into a readable format for the run function. Run goes through each basicML command and calls a use case depending on the contents of the command. 

## How to Run Our Program on your Computer:
1. check that you have java installed
3. To manually run the program click on the zipfile(This option will only work with macBook. it may think the program is a virus go to System Prefernces-> privacy-> scroll down to open anyways). We assumed you have a MacBook, if you have windows it will have to be opened through a compiler.
4. Then go to bin. Then double click on app(it should open up through the terminal).
5. A window should appear you can now either update the list of commands by clicking in the boxes with numbers or click the file button to upload a file.
6. Once the file is done uploading you can now click run the output text box will inform you of anything you have to enter in the input text box
7. If the file does not run after clicking the run button, check the discriptions next to the list of commands(The descriptions will say whether the command is valid or not)
8. The output field will keep you updated on when the program is finished
## Navigating our program
At first glance you will see a tab system and two buttons. 
The two buttons: 
 * new file will create a new file tab that you can enter in new commands
 * open file will allow you to open an existing file from your computer
The tab system:
 * Readme contains a breif discription of what is in this document
 * settings allows you to change the color scheme
 * all subsequent tabs are files
File Tabs
 * When you click on a file an additional tab system will appear
 * run contains an input and output field and a run a and save button
 * command view contains a view of all the commands with descriptions
 * textbox View contians a view of all the commands without the commands in their own text areas so that multiple commands can be pasted at once
## Running Test Files
1. Open a compiler
2. Navigate to the test files and run

## How to copy and paste
1. At the top of the page there will be three tabs click on the tab that says "Textbox View"
2. This window contains all commands saved from file or inputed in a text box and allows text to be easily copy and pasted
3. Copy and paste the input and ensure that it is formatted correctly(ie. one 4 letter command per line)
4. click submit
5. The commands will now be saved and appear on this tab and the run tab.
## Changing Colors
1. At the top of the page there will be three tabs click on the tab that says "Settings"
2. There will be two drop down labeled primary and secondary color.
3. Select your desired colors and click submit
4. If you want to go back to the default colors click reset.
## Adding and deleting new Mlcommand lines
1. At the top of the page there will be three tabs make sure you are on the tab that is labeled "run"
2. On the page to the right there will be a scroll pane that lists all the commands loaded
3. Beneath that there will be three buttons "add line", "delete line", and "submit changes"
4. To add a new command select a box and click add line and a new line to type command in a will be added to the above the selected command
5. To remove a command select a box click delete command and the line will be removed
6. To edit current commands type into one of the text boxes and type in your new command. After click submit changes
