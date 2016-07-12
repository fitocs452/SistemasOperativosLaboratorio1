/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemasoperativoslaboratorio1;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author GustavoAdolfo
 */
public class SistemasOperativosLaboratorio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char[] vectorChars = new char[10000];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        
        for (int i = 0; i < 10000; i++) {
            vectorChars[i] = alphabet.charAt(r.nextInt(alphabet.length()));
        }
        
        int totalThreads = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de threads a utilizar"));
        
        String head = "Universidad del Valle de Guatemala" + "\r\n"
                + "Adolfo Morales 13014" + "\r\n"
                + "Caractér normal y codificado" + "\r\n\r\t\r\tLaboratorio 1 \r\n\r\n";
        
        String finalOutput = "";
        String executionSummary = "Con " + totalThreads + " Threads \r\n\r\n";
        
        
        for (int i = 1; i <= totalThreads; i++) {
            int rangePerThread = (int) (9999 / i);
            int initialRange = 0;
            int endRange = rangePerThread;

            int finalExecutionTime = 0;
            
            executionSummary += "Para " + i + " Thread(s) " + "\r\n";
            
            for (int j = 0; j < i; j++) {
                if (endRange > 9999) {
                    endRange = 9999;
                }
                CustomRunnable xi =  new CustomRunnable(vectorChars, initialRange, endRange);
                Thread ti = new Thread(xi);
                
                long startTimeSub = System.currentTimeMillis();
                
                ti.run();
                if (i == totalThreads) {
                    finalOutput += xi.getOutput();
                }
                
                long stopTimeSub = System.currentTimeMillis();
                long elapsedTimeSub = stopTimeSub - startTimeSub;
                
                finalExecutionTime += elapsedTimeSub;
                
                initialRange = endRange + 1;
                endRange += rangePerThread + 1;
            }
            executionSummary += "Tiempo de ejecucion: " + finalExecutionTime + " ms \r\n\r\n";
        }

        String printInFile = head + executionSummary + finalOutput;
        
        try (
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("laboratorio1_AdolfoMorales13014.txt"), "utf-8"))) {
                writer.write(printInFile);
                System.out.println(head + executionSummary);
                
        } catch (Exception e) {
            System.out.println("Falló al crear archivo");
            System.out.println(printInFile);
        }
    }
    
}
