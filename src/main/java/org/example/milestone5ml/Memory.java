package org.example.milestone5ml;

public class Memory {
    private int[] wordlist;
    public Memory() {
        wordlist = new int[100];
    }

    //set
    public int[] getWordlist() {
        return wordlist;
    }

    //get
    public void setWordlist(int[] wordlist) {
        this.wordlist = wordlist;
    }

    //get single word
    public int getWordSingle(int index){
        return wordlist[index];
    }

    //set single word
    public void setWordSingle(int index, int value){
        wordlist[index] = value;
    }

    public void printMemory(){
        for(int i : wordlist){
            System.out.println(i);
        }
    }
}
