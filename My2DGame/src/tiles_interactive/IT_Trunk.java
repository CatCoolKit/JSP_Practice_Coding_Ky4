/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles_interactive;

import my2dgame.GamePanel;

/**
 *
 * @author manhc
 */
public class IT_Trunk extends InteractiveTile{
    GamePanel gp;
    
    public IT_Trunk(GamePanel gp, int col, int row) {
        super(gp,col,row);
        this.gp = gp;
        
        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;
        down1 = setup("/tiles_interactive/trunk", gp.tileSize, gp.tileSize);
        
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 0;
        solidArea.height = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

    }
    
    
}
