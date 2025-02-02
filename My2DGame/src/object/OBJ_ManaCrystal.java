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
public class OBJ_ManaCrystal extends Entity{
    GamePanel gp;
    
    public OBJ_ManaCrystal(GamePanel gp) {
        super(gp);
        this.gp = gp;
        
        type = type_pickupOnly;
        value = 1;
        name = "Mana Crystal";
        down1 = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image = setup("/objects/manacrystal_full", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/manacrystal_blank", gp.tileSize, gp.tileSize);
    }
    
    public void use(Entity entity){
        gp.playSE(2);
        gp.ui.addMessage("Mana +"  + value);
        gp.player.mana += value;
    }
    
}
