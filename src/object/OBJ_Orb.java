/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;


public class OBJ_Orb extends SuperObject{
    GamePanel gp;
     public OBJ_Orb(GamePanel gp){
        
        name = "Orb";
        try{
            
           image = ImageIO.read(getClass().getResourceAsStream("/objects/Orb.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            
              image3 = ImageIO.read(getClass().getResourceAsStream("/objects/Orb.png"));
            uTool.scaleImage(image3, gp.tileSize, gp.tileSize);  
            
        }catch(IOException e){
            e.printStackTrace();
    }
        collision = false;
    }
}

