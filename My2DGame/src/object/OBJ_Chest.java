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
public class OBJ_Chest extends Entity{
    
    GamePanel gp;
    
    public OBJ_Chest(GamePanel gp){
        
        super(gp);
        name = "Chest";
        down1 = setup("/objects/chest", gp.tileSize, gp.tileSize);
        
    }
}
