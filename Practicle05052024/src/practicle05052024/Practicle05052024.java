/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicle05052024;

/**
 *
 * @author manhc
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Practicle05052024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO code application logic here
        System.out.println("Hello World");
//        String name = JOptionPane.showInputDialog("Enter your name");
//        JOptionPane.showMessageDialog(null, "Hello " + name);
        File file = new File("input.txt");
//        if(file.exists()) {
//            System.out.println("yes");
//            System.out.println(file.getPath());
//        }
        
        try {
            FileWriter writer = new FileWriter("input.txt");
//            writer.write("hello\n");
//            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Practicle05052024.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileReader reader = new FileReader("input.txt");
//            int data = reader.read();
//            while (data != -1) {                
//                System.out.println((char)data);
//                data = reader.read();
//            }
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Practicle05052024.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Practicle05052024.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File file1 = new File("coin.wav");
        try {
            AudioInputStream audioST = AudioSystem.getAudioInputStream(file1);
            Clip clip = AudioSystem.getClip();
            clip.open(audioST);
            
            String response = "";
            while (!response.equals("Q")) {                
                System.out.println("P = play, S = stop, R = reset, Q = Quit");
                System.out.println("Enter your choice: ");
                response = sc.next();
                response = response.toUpperCase();
                
                switch(response){
                    case ("P"): clip.start();
                    break;
                    case ("S"): clip.stop();
                    break;
                    case ("R"): clip.setMicrosecondPosition(0);
                    break;
                    case ("Q"): clip.close();
                    break;
                    default: System.out.println("Not a valid response");
                }  
            }
            System.out.println("Byeee");
         
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Practicle05052024.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Practicle05052024.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Practicle05052024.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
