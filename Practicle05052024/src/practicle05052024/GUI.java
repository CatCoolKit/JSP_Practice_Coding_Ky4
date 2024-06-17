/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicle05052024;

import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author manhc
 */
public class GUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Border boder = BorderFactory.createLineBorder(Color.green,3);
        
        JLabel label = new JLabel();
        ImageIcon image2 = new ImageIcon("images.jpg");
        label.setText("Bro, do you even code?");
        label.setIcon(image2);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(0x00FF00)); //set font color of text
        label.setFont(new Font("MV Boli", Font.PLAIN,20)); //set font of text
        label.setIconTextGap(25); //set gap of text to image
        label.setBackground(Color.black); //set background color
        label.setOpaque(true); //display background color
        label.setBorder(boder);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label.setBounds(0, 0, 350, 350);
        
        JFrame frame = new JFrame();
        frame.setTitle("JFrame title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.setSize(800, 600);
        //frame.setLayout(null);
        frame.setVisible(true);
        
        ImageIcon image = new ImageIcon("favicon-32x32.png");
        frame.setIconImage(image.getImage());
        //frame.getContentPane().setBackground(Color.DARK_GRAY);
       
        frame.add(label);
        frame.pack();
    }
}
