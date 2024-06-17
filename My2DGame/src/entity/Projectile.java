/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import my2dgame.GamePanel;

/**
 *
 * @author manhc
 */
public class Projectile extends Entity{
    
    Entity user;
    
    public Projectile(GamePanel gp) {
        super(gp);
    }
    
    public void set(int worldX, int worldY, String direction, boolean alive, Entity user){
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;
    }
    
    public void update(){
        
        if(user == gp.player){
            int monsterIndex = gp.cChecker.checkEtity(this, gp.monster);
            if(monsterIndex != 999){
                gp.player.damageMonster(monsterIndex, attack);
                generateParticle(user.projectile, gp.monster[monsterIndex]);
                alive = false;
            }
        }
        if(user != gp.player){
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if(gp.player.invincible == false && contactPlayer == true){
                damagePlayer(attack);
                generateParticle(user.projectile, gp.player);
                alive = false;
            }
        }
        
        switch(direction){
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;   
            }
        
        life--;
        if(life <= 0){
            alive = false;
        }
        
        spireCounter++;
        if(spireCounter > 12){
            if(spireNum == 1){
                spireNum = 2;
            }else if(spireNum == 2){
                spireNum = 1;
            }
            spireCounter = 0;
        }
    }
    
    public Boolean haveResource(Entity user){
        boolean haveResource = false;
        return haveResource;
    }
    public void subtractResource(Entity user){
        
    }
    
}
