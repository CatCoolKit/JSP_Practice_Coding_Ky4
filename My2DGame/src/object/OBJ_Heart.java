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
public class OBJ_Heart extends Entity{
    GamePanel gp;
    
    public OBJ_Heart(GamePanel gp){
        super(gp);
        this.gp   = gp;
        
        type = type_pickupOnly;
        value = 2;
        name = "Heart";
        down1 = setup("/objects/heart_full", gp.tileSize, gp.tileSize);
        image = setup("/objects/heart_full", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/heart_half", gp.tileSize, gp.tileSize);
        image3 = setup("/objects/heart_blank", gp.tileSize, gp.tileSize);
    }
    
    public void use(Entity entity){
        gp.playSE(2);
        gp.ui.addMessage("Life +"  + value);
        entity.life += value;
    }
}
