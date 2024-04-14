/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

/**
 *
 * @author kring
 */
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
public class OBJ_LastPortal extends SuperObject {
    GamePanel gp;
     public OBJ_LastPortal(GamePanel gp){
        
        name = "LastPortal";
        try{
           image = ImageIO.read(getClass().getResourceAsStream("/objects/LastPortal.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
    }
        collision = false;
    }
}
