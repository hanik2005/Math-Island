/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author kring
 */
public class OBJ_enemy extends SuperObject {
    GamePanel gp;
     public OBJ_enemy(GamePanel gp){
        
        name = "enemy";
        try{
           
           image = ImageIO.read(getClass().getResourceAsStream("/objects/enemy.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
           
                 image3 = ImageIO.read(getClass().getResourceAsStream("/objects/enemy.png"));
            uTool.scaleImage(image3, gp.tileSize, gp.tileSize);
            
            
        }catch(IOException e){
            e.printStackTrace();
    }
        collision = true;
    }
}

