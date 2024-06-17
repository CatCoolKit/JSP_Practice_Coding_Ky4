/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles_interactive;

import entity.Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import my2dgame.GamePanel;

/**
 *
 * @author manhc
 */
public class InteractiveTile extends Entity{
    GamePanel gp;
    public boolean destructible = false;
    
    public InteractiveTile(GamePanel gp, int col, int row) {
        super(gp);
        this.gp = gp;
    }
    
    public boolean isCorrectItem(Entity entity){
        boolean isCorrectItem = false;
        return isCorrectItem;
    }
    
    public void playSE(){
    
    }
    
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile = null;
        return tile;
    }
    
    public void update(){
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 20){
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2){

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        //kiểm tra ranh giới vẽ, chỉ vẽ trong phạm vi trên màn hình thấy được
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
                && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
                && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
                && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(down1, screenX, screenY, null);
        }
    }
    
}
