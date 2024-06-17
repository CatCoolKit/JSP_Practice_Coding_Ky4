/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my2dgame;

import javax.swing.JFrame;

/**
 *
 * @author manhc
 */
public class My2DGame {
    
    public static JFrame window;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        window = new JFrame();
        //Để đóng cửa sổ đúng cách
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Để không thay đổi kích thước cửa sổ này
        window.setResizable(false);
        //Đặt tên trò chơi
        window.setTitle("2D Adventure");
        //window.setUndecorated(true);
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        //Làm cho cửa sổ này có kích thước phù hợp với kích thước ưa thích
        window.pack();
        
        //Cửa sổ trò chơi được hiển thị ở giữa màn hình
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.setupGame();
        
        gamePanel.startGameThread();
        
        
    }
    
}
