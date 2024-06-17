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
public class OBJ_Door extends Entity{
    
    GamePanel gp;
    
    public OBJ_Door(GamePanel gp){
        
        super(gp);
        name = "Door";
        down1 = setup("/objects/door", gp.tileSize, gp.tileSize);
        collision = true;
        
        solidArea.x = 0;
        solidArea.y = 16;
        solidArea.width = 48;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
