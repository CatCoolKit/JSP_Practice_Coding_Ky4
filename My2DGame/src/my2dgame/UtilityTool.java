/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my2dgame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author manhc
 */
public class UtilityTool {

    public BufferedImage scaleImage(BufferedImage original, int with, int height) {
        BufferedImage scaledImage = new BufferedImage(with, height, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, with, height, null);
        g2.dispose();
        
        return scaledImage;
    }

}
