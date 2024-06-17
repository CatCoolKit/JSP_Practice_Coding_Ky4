/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import entity.Entity;
import java.io.IOException;
import javax.imageio.ImageIO;
import my2dgame.GamePanel;

/**
 *
 * @author manhc
 */
public class OBJ_Boots extends Entity{
    
    GamePanel gp;
    
    public OBJ_Boots(GamePanel gp){
        
        super(gp);
        name = "Boots";
        down1 = setup("/objects/boots", gp.tileSize, gp.tileSize);
       
    }
}
