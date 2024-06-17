/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import my2dgame.GamePanel;
import my2dgame.KeyHandler;
import my2dgame.UtilityTool;
import object.OBJ_Axe;
import object.OBJ_Fireball;
import object.OBJ_Key;
import object.OBJ_Rock;
import object.OBJ_Shield_Wood;
import object.OBJ_Sword_Normal;

/**
 *
 * @author manhc
 */
public class Player extends Entity{

    KeyHandler keyH;
    
    int standCounter = 0;
    public boolean attackCanceled = false;
    
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
    
    //Tọa độ của player
    public final int screenX;
    public final int screenY;
    //public int hasKey = 0;
    
    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        setDefaultValue();
        getPlayerImage();
        getPlayerAttackImage();
        setItems();
    }
    
    public void setDefaultValue(){
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        
        //Khởi tạo vùng va chạm cho nhân vật
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.height = 32;
        solidArea.width = 32;
        
        //attackArea.height = 36;
        //attackArea.width = 36;
        
        speed = 4;
        direction = "down";
        
        //Player status
        level = 1;
        maxLife = 6;
        life = maxLife;
        maxMana = 4;
        mana = maxMana;
        ammo = 10;
        strength = 1; //the more strength he has, the more damage he gives.
        dexterity = 1; //the more dexterity he has, the less damage he receives.
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        //currentWeapon = new OBJ_Sword_Normal(gp);
        currentWeapon = new OBJ_Axe(gp);
        currentShield = new OBJ_Shield_Wood(gp);
        projectile = new OBJ_Fireball(gp);
        //projectile = new OBJ_Rock(gp);
        attack = getAttack(); //the total attack value is decided by strength and weapon
        defense = getDefense(); //the total defense value is decided by dexterity and shield
    }
    
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new OBJ_Key(gp));
    }
    
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue;
    }
    
    public int getDefense(){
        return defense = dexterity * currentShield.defensevalue;
    }
    
    //Lấy hình ảnh pixel
    public void getPlayerImage(){
        up1 = setup("/player/boy_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/player/boy_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/player/boy_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/player/boy_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/player/boy_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/player/boy_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/player/boy_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/player/boy_right_2", gp.tileSize, gp.tileSize);
    }
    
    public void getPlayerAttackImage(){
        
        if(currentWeapon.type == type_sword){
            attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize, gp.tileSize*2);
            attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize, gp.tileSize*2);
            attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize, gp.tileSize*2);
            attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize, gp.tileSize*2);
            attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize*2, gp.tileSize);
            attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize*2, gp.tileSize);
            attackRight1 = setup("/player/boy_attack_right_1", gp.tileSize*2, gp.tileSize);
            attackRight2 = setup("/player/boy_attack_right_2", gp.tileSize*2, gp.tileSize);
        }
        if(currentWeapon.type == type_axe){
            attackUp1 = setup("/player/boy_axe_up_1", gp.tileSize, gp.tileSize*2);
            attackUp2 = setup("/player/boy_axe_up_2", gp.tileSize, gp.tileSize*2);
            attackDown1 = setup("/player/boy_axe_down_1", gp.tileSize, gp.tileSize*2);
            attackDown2 = setup("/player/boy_axe_down_2", gp.tileSize, gp.tileSize*2);
            attackLeft1 = setup("/player/boy_axe_left_1", gp.tileSize*2, gp.tileSize);
            attackLeft2 = setup("/player/boy_axe_left_2", gp.tileSize*2, gp.tileSize);
            attackRight1 = setup("/player/boy_axe_right_1", gp.tileSize*2, gp.tileSize);
            attackRight2 = setup("/player/boy_axe_right_2", gp.tileSize*2, gp.tileSize);
        }
    }
    
    public BufferedImage setup(String imagePath){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath +".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return image;
    }
    
    //Xử lí khi player nhấn nút điều khiển nhân vật, sau đó xử lí va chạm
    public void update(){
        
        if(attacking == true){
            attacking();
        }        
        else if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.leftPressed == true || keyH.rightPressed == true || keyH.enterPressed == true){
            
        if(keyH.upPressed == true){
            direction = "up";
            
        }
        else if(keyH.downPressed == true){
            direction = "down";
            
        }
        else if(keyH.leftPressed == true){
            direction = "left";
            
        }
        else if(keyH.rightPressed == true){
            direction = "right";
            
        }
        
        //Check Tile collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //Check object collsion
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        
        //Check npc collision
        int npcIndex = gp.cChecker.checkEtity(this, gp.npc);
        interactNPC(npcIndex);
        
        //Check monster collision
        int monsterIndex = gp.cChecker.checkEtity(this, gp.monster);
        contactMonster(monsterIndex);
        
        //Check interactive tile collision
        int iTileIndex = gp.cChecker.checkEtity(this, gp.iTile);
        
        //Check event
        gp.eHandler.checkEvent();
        
        //If collision is false, player can move
        if(collisionOn == false && keyH.enterPressed == false){
            switch(direction){
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        
        if(keyH.enterPressed == true && attackCanceled ==false){
            gp.playSE(7);
            attacking = true;
            spireCounter = 0;
        }
        attackCanceled = false;
        gp.keyH.enterPressed = false;
        
        //Với FPS 60 thì sẽ có 6 lần thay đổi hình ảnh trong một giây với điều kiện ở dưới
        //Cứ mỗi 0,1 giây sẽ thay đổi ảnh liên tục khiến chuyển động mượt hơn
        spireCounter++;
        if(spireCounter > 10){
            if(spireNum == 1){
                spireNum = 2;
            }else if(spireNum == 2){
                spireNum = 1;
            }
            spireCounter = 0;
        }               
        }
        else {
            standCounter++;
            if(standCounter == 20){
                spireNum =1;
                standCounter = 0;
            }
        }
        if(gp.keyH.shotKeyPressed == true && projectile.alive == false 
                && shotAvaiableCounter == 30 && projectile.haveResource(this) == true){
            //Set default coordinates, direction and user
            projectile.set(worldX, worldY, direction, true, this);
            
            //Stract the cost (mana, ammo, etc)
            projectile.subtractResource(this);
            
            //Add it to the list
            gp.projectileList.add(projectile);
            shotAvaiableCounter = 0;
            
            gp.playSE(10);
        }
        
        //This needs to be outside of key if statement!
        if(invincible == true){
            invincibleCounter++;
            if(invincibleCounter > 60){
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(shotAvaiableCounter < 30){
            shotAvaiableCounter++;
        }
        if(life > maxLife){
            life = maxLife;
        }
        if(mana > maxMana){
            mana = maxMana;
        }
    }
    
    public void attacking(){
        spireCounter++;
        if(spireCounter <= 5){
            spireNum = 1;
        }
        if(spireCounter > 5 && spireCounter <= 25){
            spireNum = 2;
            
            //Save the current worldX, worldY, solidArea
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            
            //Adjust player's worldX/Y for the attackArea
            switch(direction){
                case "up": worldY -= attackArea.height; break;
                case "down": worldY += attackArea.height; break;
                case "left": worldX -= attackArea.width; break;
                case "right": worldX += attackArea.width; break;   
            }
            //attackArea becomes solidArea
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            //Check monster collision with the updated worldX, worldY and solidArea
            int monsterIndex = gp.cChecker.checkEtity(this, gp.monster);
            damageMonster(monsterIndex, attack);
            
            int iTileIndex = gp.cChecker.checkEtity(this, gp.iTile);
            damageInteractiveTile(iTileIndex);
            //After checking collision, restore the original data
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if(spireCounter > 25){
            spireNum = 1;
            spireCounter = 0;
            attacking = false;
        }
    }
    
    public void pickUpObject(int i){
        if(i != 999){
            
            //Pickup only items
            if(gp.obj[i].type == type_pickupOnly){
                gp.obj[i].use(this);
                gp.obj[i] = null;
                
            }
            //Inventory items
            else{
                String text;
            
                if(inventory.size() != maxInventorySize){
                    inventory.add(gp.obj[i]);
                    gp.playSE(1);
                    text = "Got a " + gp.obj[i].name + "!";
                }
                else {
                    text = "You cannot carry any more!";
                }
                gp.ui.addMessage(text);
                gp.obj[i] = null;
            }
        }
    }
    
    public void interactNPC(int i){
        if(gp.keyH.enterPressed == true){
            if(i != 999){
                attackCanceled = true;
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            
            }
        }
    }
    
    public void contactMonster(int i){
        if(i != 999){
            if(invincible == false && gp.monster[i].dying == false){
                gp.playSE(6);
                
                int damage = gp.monster[i].attack - defense;
                if(damage < 0){ damage = 0;}
                life -= damage;
                invincible = true;
            }
        }
    }
    
    public void damageMonster(int i, int attack){
        if(i != 999){
            if(gp.monster[i].invincible == false){
                gp.playSE(5);
                int damage = attack - gp.monster[i].defense;
                if(damage < 0){ damage = 0;}
                
                gp.monster[i].life -= damage;
                gp.ui.addMessage(damage + " damage!");
                
                gp.monster[i].invincible = true;
                gp.monster[i].damageReaction();
                if(gp.monster[i].life <=0){
                    gp.monster[i].dying = true;
                    gp.ui.addMessage("Kill the " + gp.monster[i].name + "!");
                    gp.ui.addMessage("Exp + " + gp.monster[i].exp);
                    exp += gp.monster[i].exp;
                    checkLevelUp();
                }
            }
        }
    }
    
    public void damageInteractiveTile(int i){
    
        if(i != 999 && gp.iTile[i].destructible == true 
                && gp.iTile[i].isCorrectItem(this) == true && gp.iTile[i].invincible == false){
            gp.iTile[i].playSE();
            gp.iTile[i].life--;
            gp.iTile[i].invincible = true;
            
            //Generate particle
            generateParticle(gp.iTile[i], gp.iTile[i]);
            
            if(gp.iTile[i].life == 0){
                gp.iTile[i] = gp.iTile[i].getDestroyedForm();
            }
        }
    }
    
    public void checkLevelUp(){
        if(exp >= nextLevelExp){
            level++;
            nextLevelExp = nextLevelExp*2;
            maxLife += 2;
            strength++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            
            gp.playSE(8);
            gp.gameState = gp.dialogueState;
            gp.ui.currentDialogue = "You are level " + level + " now!\n"
                    + "You feel stronger!";
        }
    }
    
//    public void pickUpObject(int i){
//        if(i != 999){
//            String objectName = gp.obj[i].name;
//            
//            switch(objectName){
//                case "Key":
//                    gp.playSE(1);
//                    hasKey++;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("You got a key!");
//                    break;
//                case "Door":
//                    gp.playSE(3);
//                    if(hasKey > 0){
//                        gp.obj[i] = null;
//                        hasKey--;
//                        gp.ui.showMessage("You opned the door!");
//                    }else {
//                        gp.ui.showMessage("You need a key!");
//                    }
//                    break;
//                case "Boots":
//                    gp.playSE(2);
//                    speed += 1;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("Speed up!");
//                    break;
//                case "Chest":
//                    gp.ui.gameFinished = true;
//                    gp.stopMusic();
//                    gp.playSE(4);
//                    break;    
//            }
//        }
//    }
    
    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexOnSlot();
        
        if(itemIndex < inventory.size()){
            Entity selectedItem = inventory.get(itemIndex);
            
            if(selectedItem.type == type_sword || selectedItem.type == type_axe){
                currentWeapon = selectedItem;
                attack = getAttack();
                getPlayerAttackImage();
            }
            if(selectedItem.type == type_shield){
                currentShield = selectedItem;
                defense = getDefense();
            }
            if(selectedItem.type == type_consumable){
                selectedItem.use(this);
                inventory.remove(itemIndex);
            }
        }
    }
    
    //Vẽ nhân vật tương ứng với nút mà người chơi ấn sau khi cập nhật để vẽ lại nhân vật
    //Hình ảnh cũng được thay đổi theo chỉ số đã được cài ở hàm update()
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        
        switch(direction){
            case "up":
                if(attacking == false){
                    if(spireNum == 1){ image = up1;}
                    if(spireNum == 2){ image = up2;}     
                }
                if(attacking == true){
                    tempScreenY = screenY - gp.tileSize;
                    if(spireNum == 1){ image = attackUp1;}
                    if(spireNum == 2){ image = attackUp2;}
                }         
                break;
            case "down":
                if(attacking == false){
                    if(spireNum == 1){ image = down1;}
                    if(spireNum == 2){ image = down2;}     
                }
                if(attacking == true){
                    if(spireNum == 1){ image = attackDown1;}
                    if(spireNum == 2){ image = attackDown2;}
                }
                break;
            case "left":
                if(attacking == false){
                    if(spireNum == 1){ image = left1;}
                    if(spireNum == 2){ image = left2;}     
                }
                if(attacking == true){
                    tempScreenX = screenX - gp.tileSize;
                    if(spireNum == 1){ image = attackLeft1;}
                    if(spireNum == 2){ image = attackLeft2;}
                }
                break;
            case "right":
                if(attacking == false){
                    if(spireNum == 1){ image = right1;}
                    if(spireNum == 2){ image = right2;}     
                }
                if(attacking == true){
                    if(spireNum == 1){ image = attackRight1;}
                    if(spireNum == 2){ image = attackRight2;}
                }
                break;
        }
        if(invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        
        //Reset alpha   
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
//        //Debug
//        g2.setFont(new Font("Arial", Font.PLAIN, 26));
//        g2.setColor(Color.white);
//        g2.drawString("Invincible:"+invincibleCounter, 10, 400);
    }
}
