/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkzprogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author manhc
 */
public class Checkzprogram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileReader fr = new FileReader("exp1.txt");
        BufferedReader br = new BufferedReader(fr);
        // Đọc input
        String line;
        while ((line = br.readLine()) != null) {
            // Xử lý input
            int numIf = 0;
            int numElseIf = 0;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'I') {
                    if (i + 2 < line.length() && line.charAt(i + 1) == 'F' && line.charAt(i + 2) == 'E') {
                        numIf++;
                    } else {
                        numElseIf++;
                    }
                }
            }

            // Xuất output
            System.out.println(numIf * 2 + numElseIf * 3);
            System.out.println(line);
        }
    
    }
    
}
