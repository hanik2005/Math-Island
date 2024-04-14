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
public class OBJ_ManaCrystal extends SuperObject {
    GamePanel gp;
     public OBJ_ManaCrystal(GamePanel gp){
        
        name = "ManaCrystal";
        try{
           image = ImageIO.read(getClass().getResourceAsStream("/objects/manacrystal_blank.png"));
           image2 = ImageIO.read(getClass().getResourceAsStream("/objects/manacrystal_full.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e){
            e.printStackTrace();
    }
        collision = false;
    }
}
