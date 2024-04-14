package entity;

import main.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Entity {
    // Variable Declarations
    GamePanel gp;
    public int worldX, worldY;
    public int speed;
    
    public BufferedImage up1, up2,down1, down2, left1, left2, right1, right2, picture1, picture2, picture3, up_special, down_special, left_special,
            right_special, Gup1, Gup2, Gdown1, Gdown2, Gleft1, Gleft2, Gright1, Gright2, background_image;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNumber = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public boolean gCollisionOn = false;
     public int actionLockCounter = 0;
     String dialogues[] = new String[20];
}