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
public class OBJ_Shield_Blue extends Entity{
    
    public OBJ_Shield_Blue(GamePanel gp) {
        super(gp);
        
        type = type_shield;
        name = "Blue Shield";
        down1 = setup("/objects/shield_blue", gp.tileSize, gp.tileSize);
        defensevalue = 2;
        description = "[" + name + "] \nA shiny blue shield.";
    }
    
}
