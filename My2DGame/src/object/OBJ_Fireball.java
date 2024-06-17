/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import entity.Entity;
import entity.Projectile;
import java.awt.Color;
import my2dgame.GamePanel;

/**
 *
 * @author manhc
 */
public class OBJ_Fireball extends Projectile{
    
    GamePanel gp;
    
    public OBJ_Fireball(GamePanel gp) {
        super(gp);
        
        this.gp = gp;
        name = "Fireball";
        speed = 5;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
        
    }
    
    public void  getImage(){
        up1 = setup("/projectile/fireball_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/projectile/fireball_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/projectile/fireball_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/projectile/fireball_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/projectile/fireball_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/projectile/fireball_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/projectile/fireball_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/projectile/fireball_right_2", gp.tileSize, gp.tileSize);
    }
    
    public Boolean haveResource(Entity user){
        boolean haveResource = false;
        
        if(user.mana >= useCost){
            haveResource = true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        user.mana -= useCost;
    }
    
    public Color getParticleColor(){
        Color color = new Color(240,50,0);
        return color;
    }
    
    public int getParticleSize(){
        int size = 10; //6 pixels
        return size;
    }
    
    public int getParticleSpeed(){
        int speed = 1;
        return speed;
    }
    
    public int getParticleMaxlife(){
        int maxLife = 20;
        return maxLife;
    }
}
