/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;


public class OBJ_FinalPortal extends SuperObject{
    GamePanel gp;
     public OBJ_FinalPortal(GamePanel gp){
        
        name = "FinalPortal";
        try{
           image = ImageIO.read(getClass().getResourceAsStream("/objects/FinalPortal.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
    }
        collision = false;
    }
}
