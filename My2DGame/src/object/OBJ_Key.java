/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import entity.Entity;
import my2dgame.GamePanel;

/**
 *
 * @author manhc
 */
public class OBJ_Key extends Entity{
    
    GamePanel gp;
    
    public OBJ_Key(GamePanel gp){
        super(gp);
        name = "Key";
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
        description = "[" + name + "] \nIt opens a door.";
    }
    
}
