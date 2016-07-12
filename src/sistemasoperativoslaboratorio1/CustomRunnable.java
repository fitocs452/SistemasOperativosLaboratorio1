/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasoperativoslaboratorio1;

/**
 *
 * @author GustavoAdolfo
 */
public class CustomRunnable implements Runnable{

    private char[] charsArray;
    private int initialIndex;
    private int finalIndex;
    private String output;

    public CustomRunnable(char[] charsArray, int initialIndex, int finalIndex) {
        this.charsArray = charsArray;
        this.initialIndex = initialIndex;
        this.finalIndex = finalIndex;
        this.output = new String();
    }
    
    @Override
    public void run() {
        for (int i = initialIndex; i <= finalIndex; i++) {
            output  += "Index: " + i + " Normal: " + charsArray[i] + " Codificado: " + caesar(charsArray[i], 2) + "\r\n";
            //System.out.println("Normal: " + charsArray[i] + " Codificated: " + caesar(charsArray[i], 2) + "\n");
        }
    }
    
    public char caesar(char letter, int shift) {
        letter = (char) (letter + shift);
        if (letter > 'z') {
            letter = (char) (letter - 26);
        } else if (letter < 'a') {
            letter = (char) (letter + 26);
        }
        
	return letter;
    }

    public char[] getCharsArray() {
        return charsArray;
    }

    public void setCharsArray(char[] charsArray) {
        this.charsArray = charsArray;
    }

    public int getInitialIndex() {
        return initialIndex;
    }

    public void setInitialIndex(int initialIndex) {
        this.initialIndex = initialIndex;
    }

    public int getFinalIndex() {
        return finalIndex;
    }

    public void setFinalIndex(int finalIndex) {
        this.finalIndex = finalIndex;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
