/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import main.UtilityTool;
import main.GamePanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class SuperObject {
    
    public BufferedImage image, image2, image3;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    UtilityTool uTool = new UtilityTool();
        
    public void draw(Graphics g, GamePanel gp){
        
        
             int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            int screenXX = worldX - gp.Gplayer.worldX + gp.Gplayer.screenX;
            int screenYY = worldY - gp.Gplayer.worldY + gp.Gplayer.screenY;
            
            if (worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && 
                worldX - gp.tileSize< gp.player.worldX + gp.player.screenX && 
                worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && 
                worldY - gp.tileSize< gp.player.worldY + gp.player.screenY && gp.gender == 0){
                
                 g.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                 
            }else if (worldX + gp.tileSize> gp.Gplayer.worldX - gp.Gplayer.screenX && 
                worldX - gp.tileSize< gp.Gplayer.worldX + gp.Gplayer.screenX && 
                worldY + gp.tileSize> gp.Gplayer.worldY - gp.Gplayer.screenY && 
                worldY - gp.tileSize< gp.Gplayer.worldY + gp.Gplayer.screenY && gp.gender == 1){
                
                 g.drawImage(image, screenXX, screenYY, gp.tileSize, gp.tileSize, null);
            }
    }
}
