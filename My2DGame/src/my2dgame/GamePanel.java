/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my2dgame;

import entity.Entity;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComponent;
import javax.swing.JPanel;
import tile.TileManager;
import tiles_interactive.InteractiveTile;

/**
 *
 * @author manhc
 */
public class GamePanel extends JPanel implements Runnable{
    //Screen Settings
    final int originalTileSize = 16; // 16x16 tile, kích thước nhân vật
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    //Kích thước cửa sổ game
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 48*16 = 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 48*12 = 576 pixels
    
    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    //For full screen
    int screenWidth2 = screenWidth;
    int screenHeight2 = screenHeight;
    BufferedImage tempScreen;
    Graphics2D g2;
    public boolean fullScreenOn = false;
    
    //FPS
    int FPS = 60;
    
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    
    //Sound
    Sound music = new Sound();
    Sound se = new Sound();
    
    //Time needs to run in the game as real life
    //Có thể bắt đầu và dừng
    //Một khi thread chạy nó sẽ giữ cho chương trình của bạn chạy cho đến khi bạn dừng nó
    //Khi bạn muốn lặp đi lặp lại một quy trình, vẽ màn hình 60 lần mỗi giây 
    //Implements Runnable để sử dụng luồng này
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    
    //Entity
    public Player player = new Player(this, keyH);
    //Số lượng đồ vật xuất hiện cùng một lúc
    public Entity obj[] = new Entity[20];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    public InteractiveTile iTile[] = new InteractiveTile[50];
    public ArrayList<Entity> projectileList = new ArrayList<>();
    public ArrayList<Entity> particleList = new ArrayList<>();
    ArrayList<Entity> entityList = new ArrayList<>();
    
    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int characterState = 4;
    public final int optionsState = 5; 
    
    
    //Đặt vị trí mặc định cho player
    //int playerX = 100;
    //int playerY = 100;
    //int playerSpeed = 4;
    
    
    //đặt kích thước bảng điều khiển GamePanel
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); //GamePanel có thể focus vào receive key input
    }
    
    //Add stuff
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        aSetter.setInteractiveTile();
        //playMusic(0);
        
        gameState = titleState;
        
        tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = (Graphics2D)tempScreen.getGraphics();
        
        //setFullScreen();  
    }
    
    public void setFullScreen(){
        //Get local screen device
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        gd.setFullScreenWindow(My2DGame.window);
        
        //Get full screen width and height
        screenWidth2 = My2DGame.window.getWidth();
        screenHeight2 = My2DGame.window.getHeight();
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //Khi chạy chương trình thread sẽ tự động gọi hàm run
    @Override
//    public void run() {
//        double drawInterval = 1000000000/FPS; //0.0166666 seconds
//        //Thời gian để vẽ bước kế tiếp
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        
//        while(gameThread != null){
//            
//            System.out.println("This game loop is running");
//             
//            //long currentTime = System.nanoTime();
//            //System.out.println("Current Time: " + currentTime);
//            
//            // 1 Update: cập nhật thông tin như vị trí nhân vật
//            update();
//            // 2 Draw: vẽ màn hình với cập nhật thông tin
//            repaint();
//            
//            try {
//                //khoảng thời gian còn dư sau khi cập nhật và vẽ lại dựa vào thông tin mới
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/1000000;
//                
//                if(remainingTime < 0){
//                    remainingTime = 0;
//                }
//                
//                //Sleep cho để chờ đến thời gian vẽ bước kế tiếp
//                Thread.sleep((long) remainingTime);
//                nextDrawTime += drawInterval;
//                
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//    }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        //Vòng while này sẽ chạy liên tục cho tới khi trò chơi bị tắt
        //Đảm bảo thời gian chạy của vòng while tượng ứng với PFS được đặt
        while(gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if(delta >= 1){
                update();
                repaint();
                //drawToTempScreen(); //draw everything to the buffered image
                //drawToScreen(); //draw the buffered image to the screen
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000){
                System.out.println("FPS: " + drawCount);
                timer = 0;
                drawCount = 0;
            }
        }
    }
    
    //Cập nhật thông tin lên trò chơi
    public void update(){
        //Thiết lập để dừng game
        if(gameState == playState){
            //Player
            player.update();
            //NPC
            for (int i = 0; i < npc.length; i++) {
                if(npc[i] != null){
                    npc[i].update();
                }
            }
            //Monster
            for (int i = 0; i < monster.length; i++) {
                if(monster[i] != null){
                    if(monster[i].alive == true && monster[i].dying ==false){
                        monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i].checkDrop();
                        monster[i] = null;
                    }
                }
            }
            for (int i = 0; i < projectileList.size(); i++) {
                if(projectileList.get(i) != null){
                    if(projectileList.get(i).alive == true){
                        projectileList.get(i).update();
                    }
                    if(projectileList.get(i).alive == false){
                        projectileList.remove(i);
                    }
                }
            }
            for (int i = 0; i < particleList.size(); i++) {
                if(particleList.get(i) != null){
                    if(particleList.get(i).alive == true){
                        particleList.get(i).update();
                    }
                    if(particleList.get(i).alive == false){
                        particleList.remove(i);
                    }
                }
            }
            for (int i = 0; i < iTile.length; i++) {
                if(iTile[i] != null){
                    iTile[i].update();
                }
            }
        }
        if(gameState == pauseState){
        
        }
       
    }
    
    public void drawToTempScreen(){
        
        //Debug
        long drawStart = 0;
        if(keyH.showDebugText == true){
            drawStart = System.nanoTime();
        }
        
        //Tile screen
        if(gameState == titleState){ 
            ui.draw(g2);
        }
  
        //Others
        else{
     
            //Tile
            tileM.draw(g2);
            
            //Interactive tile
            for (int i = 0; i < iTile.length; i++) {
                if(iTile[i] != null){
                    iTile[i].draw(g2);
                }
            }
            
            //Add entities to the list
            entityList.add(player);
            
            for (int i = 0; i < npc.length; i++) {
                if(npc[i] != null){
                    entityList.add(npc[i]);
                }
            }
            
            for (int i = 0; i < obj.length; i++) {
                if(obj[i] != null){
                    entityList.add(obj[i]);
                }
            }
            
            for (int i = 0; i < monster.length; i++) {
                if(monster[i] != null){
                    entityList.add(monster[i]);
                }
            }
            
            for (int i = 0; i < projectileList.size(); i++) {
                if(projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
            }
            
            for (int i = 0; i < particleList.size(); i++) {
                if(particleList.get(i) != null){
                    entityList.add(particleList.get(i));
                }
            }

            //Sort
            Collections.sort(entityList, new Comparator<Entity>(){
                @Override
                public int compare(Entity o1, Entity o2) {
                    int result = Integer.compare(o1.worldY, o2.worldY);
                    return result;
                }
                
            });
            
            //Draw entities
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            //Empty entity list
            entityList.clear();
        
            //UI
            ui.draw(g2);
        }
        
        //Debug
        if(keyH.showDebugText == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            
            g2.setFont(new Font("Arial",Font.PLAIN,20));
            g2.setColor(Color.white);
            int x = 10;
            int y = 400;
            int lineHeight = 20;
            
            g2.drawString("WorldX" + player.worldX, x, y); y += lineHeight;
            g2.drawString("WorldY" + player.worldY, x, y); y += lineHeight;
            g2.drawString("Col" + (player.worldX + player.solidArea.x)/tileSize, x, y); y += lineHeight;
            g2.drawString("Row" + (player.worldY + player.solidArea.y)/tileSize, x, y); y += lineHeight;
            
            g2.drawString("Draw Time: " + passed, x, y);
            System.out.println("Draw Time: " + passed);
        }
        
    }
    
    public void drawToScreen(){
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
        g.dispose();
    }
    
    
    //Vẽ lại với thông tin cập nhật
    public void paintComponent(Graphics g){
        super.paintComponent(g); //Định dạng mỗi khi sử dụng
        //Thay đổi g thành đồ họa 2D, để có thể dùng nhiều chức năng hơn khi vẽ
        Graphics2D g2 = (Graphics2D)g;
        
        //Debug
        long drawStart = 0;
        if(keyH.showDebugText == true){
            drawStart = System.nanoTime();
        }
        
        //Tile screen
        if(gameState == titleState){
            ui.draw(g2);
        }
        //Others
        else{
     
            //Tile
            tileM.draw(g2);
            
            //Interactive tile
            for (int i = 0; i < iTile.length; i++) {
                if(iTile[i] != null){
                    iTile[i].draw(g2);
                }
            }
            
            //Add entities to the list
            entityList.add(player);
            
            for (int i = 0; i < npc.length; i++) {
                if(npc[i] != null){
                    entityList.add(npc[i]);
                }
            }
            
            for (int i = 0; i < obj.length; i++) {
                if(obj[i] != null){
                    entityList.add(obj[i]);
                }
            }
            
            for (int i = 0; i < monster.length; i++) {
                if(monster[i] != null){
                    entityList.add(monster[i]);
                }
            }
            
            for (int i = 0; i < projectileList.size(); i++) {
                if(projectileList.get(i) != null){
                    entityList.add(projectileList.get(i));
                }
            }
            
            for (int i = 0; i < particleList.size(); i++) {
                if(particleList.get(i) != null){
                    entityList.add(particleList.get(i));
                }
            }

            //Sort
            Collections.sort(entityList, new Comparator<Entity>(){
                @Override
                public int compare(Entity o1, Entity o2) {
                    int result = Integer.compare(o1.worldY, o2.worldY);
                    return result;
                }
                
            });
            
            //Draw entities
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            //Empty entity list
            entityList.clear();
        
            //UI
            ui.draw(g2);
        }
        
        //Debug
        if(keyH.showDebugText == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            
            g2.setFont(new Font("Arial",Font.PLAIN,20));
            g2.setColor(Color.white);
            int x = 10;
            int y = 400;
            int lineHeight = 20;
            
            g2.drawString("WorldX" + player.worldX, x, y); y += lineHeight;
            g2.drawString("WorldY" + player.worldY, x, y); y += lineHeight;
            g2.drawString("Col" + (player.worldX + player.solidArea.x)/tileSize, x, y); y += lineHeight;
            g2.drawString("Row" + (player.worldY + player.solidArea.y)/tileSize, x, y); y += lineHeight;
            
            g2.drawString("Draw Time: " + passed, x, y);
            System.out.println("Draw Time: " + passed);
        }
        
        //Loại bỏ bối cảnh đồ họa này và giải phóng mọi tài nguyên hệ thống mà nó đang sử dụng 
        g2.dispose();
    }
    
    
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
        
    }
    
    public void stopMusic(){
        music.stop();
        
    }
    
    public void playSE(int i){
        se.setFile(i);
        se.play();
    
    }
}
