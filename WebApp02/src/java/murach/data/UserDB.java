/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import murach.business.User;

/**
 *
 * @author manhc
 */
public class UserDB {
    private static PrintWriter pw;
    
    public static long insert(User user, String path) {
        // TODO: Add code that adds the user to the database
        // NOTE: This is shown in chapters 11-13
        String res = user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName();
        res = res + "|" + user.getMusic();
        
        File f = new File(path);
        try {
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(res);
            bw.write("\n");
            
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public boolean emailExisted(String email, String path){
        File file = new File(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {                
                String[] temps = line.trim().split("\\|");
                if(temps[0].equalsIgnoreCase(email)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        return false;
    }
}
