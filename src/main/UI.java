package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

import backend.UserData;
import java.awt.FontMetrics;
import object.OBJ_Orb;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import backend.*;
import java.awt.BasicStroke;
import object.OBJ_ManaCrystal;

public class UI {

    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public int commandNum = 0;
    public GamePanel gp;
    public Graphics2D g2d;
    public Font arial_40, arial_80B;
    public BufferedImage orbImage;
     public String currentProblem;
    public String userAnswer;
    String dialogues[] = new String[20];
    
    public BufferedImage blankManaCrystal;
    public BufferedImage blankManaCrystal2;
    public BufferedImage blankManaCrystal3;
    public BufferedImage blankManaCrystal4;
    
    public BufferedImage fullManaCrystal;
    public BufferedImage fullManaCrystal2;
    public BufferedImage fullManaCrystal3;
    public BufferedImage fullManaCrystal4;
    
    
    
    public boolean paused = false; // Added variable to track game pause state
    private BufferedImage background_image;
     public double finalTime;
     public DecimalFormat dFormat = new DecimalFormat("#0.00");
     public double playTime;
     public Container parentContainer;
     private boolean slowTimer = false;
     private boolean previousTimerSpeed = false;
      public String username;

    public UI(GamePanel gp) {
        
        this.gp = gp;
        this.parentContainer = parentContainer;
        this.g2d = (Graphics2D) gp.getGraphics(); // Initialize g2d here  
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
       
        
        OBJ_Orb orb = new OBJ_Orb(gp);
        orbImage = orb.image;
        
        OBJ_ManaCrystal blankCrystal = new OBJ_ManaCrystal(gp);
        blankManaCrystal = blankCrystal.image;
        
        OBJ_ManaCrystal blankCrystal2 = new OBJ_ManaCrystal(gp);
        blankManaCrystal2 = blankCrystal2.image;
        
        OBJ_ManaCrystal blankCrystal3 = new OBJ_ManaCrystal(gp);
        blankManaCrystal3 = blankCrystal3.image;
        
        OBJ_ManaCrystal blankCrystal4 = new OBJ_ManaCrystal(gp);
        blankManaCrystal4 = blankCrystal4.image;
        
        OBJ_ManaCrystal fullCrystal = new OBJ_ManaCrystal(gp);
        fullManaCrystal = fullCrystal.image2;
        
        OBJ_ManaCrystal fullCrystal2 = new OBJ_ManaCrystal(gp);
        fullManaCrystal2 = fullCrystal2.image2;
        
        OBJ_ManaCrystal fullCrystal3 = new OBJ_ManaCrystal(gp);
        fullManaCrystal3 = fullCrystal3.image2;
        
        OBJ_ManaCrystal fullCrystal4 = new OBJ_ManaCrystal(gp);
        fullManaCrystal4 = fullCrystal4.image2;
        
//        try {
//            background_image = ImageIO.read(getClass().getResource("../background_image/Background_Certificate.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g) {
        
        if(gameFinished == true){
            
            // Draw congratulations message and play time
        g.setFont(arial_40);
        g.setColor(Color.WHITE);
        String text = "You Escaped The Island!";
        int textLength = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
        int x = gp.screenW / 2 - textLength / 2;
        int y = gp.screenH / 2 - (gp.tileSize * 3);
        g.drawString(text, x, y);

        text = "Your Time is: " + dFormat.format(gp.playTime) + "!";
        textLength = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
        x = gp.screenW / 2 - textLength / 2;
        y = gp.screenH / 2 + (gp.tileSize * 5);
        g.drawString(text, x, y);

        // Draw congratulations message
        g.setFont(arial_80B);
        g.setColor(Color.YELLOW);
        text = "Congratulations";
        textLength = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
        x = gp.screenW / 2 - textLength / 2;
        y = gp.screenH / 2 + (gp.tileSize * 2);
        g.drawString(text, x, y);

        // Stop the game timer
        gp.stopGameTimer();
        
        UserData userData = new UserData(); // Create an instance of UserData
        String Username = userData.getUserName();
        
     if (Username != null) {
    // User exists, update playtime
     g.setFont(arial_40);
     g.setColor(Color.BLACK);
     text = Username;
     textLength = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
     x = gp.screenW / 2 - textLength / 2;
     y = gp.screenH / 2 + (gp.tileSize * 4);
     g.drawString(text, x, y);
     
     UserData.updatePlayTime(Username, gp.playTime);
     } else {
     
     g.setFont(arial_40);
     g.setColor(Color.BLACK);
     text = "User";
     textLength = (int) g.getFontMetrics().getStringBounds(text, g).getWidth();
     x = gp.screenW / 2 - textLength / 2;
     y = gp.screenH / 2 + (gp.tileSize * 4);
     g.drawString(text, x, y);
    System.out.println("User not found. Please create a profile");
   }
        

        gp.gameThread = null;
    
        }
        else{
            // Draw orb count
            if(gp.gender == 0){
        g.setFont(arial_40);
        g.setColor(Color.white);
        g.drawImage(orbImage, gp.tileSize / 3, gp.tileSize * 3, gp.tileSize, gp.tileSize, null);
        g.drawString("x " + gp.player.hasOrb, 74, 180);
            }
               else if(gp.gender == 1){
        g.setFont(arial_40);
        g.setColor(Color.white);
        g.drawImage(orbImage, gp.tileSize / 3, gp.tileSize * 3, gp.tileSize, gp.tileSize, null);
        g.drawString("x " + gp.Gplayer.hasOrb, 74, 180);
            }
            
        
        if (!gp.player.isSpecialAnimation && !gp.Gplayer.isSpecialAnimation) {
            if (gp.gender == 0){
            switch (gp.player.mana) {
                case 0:
                    // If mana is equal to zero, draw the blankManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal, gp.tileSize * 0 , gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                case 1:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    // Hide the blankManaCrystal
                    // (Optional: You may remove this if statement if you want to simply overwrite the previous image)
                    // Commenting out the following lines will overwrite the previous image without hiding it
                    // g.setFont(arial_40);
                    // g.setColor(Color.white);
                    // g.drawImage(blankManaCrystal, gp.tileSize / 2, gp.tileSize * 4, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                case 3:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                case 4:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                default:
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
            }
            }else if (gp.gender == 1){
             switch (gp.Gplayer.mana) {
                case 0:
                    // If mana is equal to zero, draw the blankManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal, gp.tileSize * 0 , gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                case 1:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    // Hide the blankManaCrystal
                    // (Optional: You may remove this if statement if you want to simply overwrite the previous image)
                    // Commenting out the following lines will overwrite the previous image without hiding it
                    // g.setFont(arial_40);
                    // g.setColor(Color.white);
                    // g.drawImage(blankManaCrystal, gp.tileSize / 2, gp.tileSize * 4, gp.tileSize, gp.tileSize, null);
                    break;
                case 2:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                case 3:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(blankManaCrystal4, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                case 4:
                    // If mana is equal to one, draw the fullManaCrystal
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
                default:
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal, gp.tileSize * 0, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal2, gp.tileSize * 1, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 2, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    g.setFont(arial_40);
                    g.setColor(Color.white);
                    g.drawImage(fullManaCrystal3, gp.tileSize * 3, gp.tileSize * 1, gp.tileSize, gp.tileSize, null);
                    break;
            }
            }
        }
        
    
        if (messageOn == true) {
            g.setFont(g.getFont().deriveFont(30F));
            g.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
            messageCounter++;

            if (messageCounter > 120) {
                messageCounter = 0;
                messageOn = false;
            }
        }
        
        }
        

        this.g2d = (Graphics2D) g;
        
        if (!paused) {
        if (gp.gameState == gp.titleState) {
            drawTitleScreen(g);
        }
//        if (gp.gameState == gp.leaderboardState) {
//            leaderboard();
//        }
        if(gp.gameState == gp.optionsState){
            drawOptionMenu(g);
        }
        if(gp.gameState == gp.instructionState){
            drawInstructions(g);
        }
         if (gp.gameState == gp.dialogueState){
             drawDialogueState("mama");
         }
         if(gp.gameState == gp.pickState){
             drawPickState(g);
         }
         if(gp.gameState == gp.anotherTitleState){
             newDrawTitleScreen(g);
         }
        }
    }
     public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
    
     public void drawDialogueState(String dialogue1){
         int x = gp.tileSize*2;
         int y = gp.tileSize/2;
         int width = gp.screenW - (gp.tileSize*4);
         int height = gp.tileSize*5;
         
         
         drawSubWindow(x, y, width, height);
         
         x += gp.tileSize;
         y += gp.tileSize;
         g2d.drawString(dialogue1, x, y);
       
     }
     public void drawSubWindow (int x, int y, int width, int height){
         
         Color c = new Color (0,0,0,210);
         g2d.setColor(c);
         g2d.fillRoundRect(x, y, width, height, 35, 35);
         
         c = new Color(255,255,255);
         g2d.setColor(c);
         g2d.setStroke(new BasicStroke(5));
         g2d.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
         
     }
     public void newDrawTitleScreen(Graphics g) {
    // Create a temporary graphics object for drawing
    Graphics2D g2d = (Graphics2D) g.create();
    
//            try {
//            background_image = ImageIO.read(getClass().getResource("../background_image/Background_Certificate.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    // Draw background image
    g2d.drawImage(gp.player.background_image, 0, 0, gp.screenW, gp.screenH, null);
// g2d.setColor(new Color(0, 100, 0));
// g2d.fillRect(0, 0, gp.screenW, gp.screenH);
    // Draw text and other elements on top of the background image
    g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 96F));
    String text = "Math Island";
    int x = gp.tileSize * 5;
    int y = gp.tileSize * 3;

    g2d.setColor(Color.gray);
    g2d.drawString(text, x + 5, y + 5);

    g2d.setColor(Color.white);
    g2d.drawString(text, x, y);

    x = gp.screenW / 2 - (gp.tileSize * 2) / 3;
    y += gp.tileSize * 2;
    g2d.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
    g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48F));

    text = "NEW GAME";
    x = getXforCenteredText(text);
    y += gp.tileSize * 4;
    g2d.drawString(text, x, y);
    if (commandNum == 0) {
        g2d.drawString(">", x - gp.tileSize, y);
    }
    
    text = "LEADERBOARD";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2d.drawString(text, x, y);
    if (commandNum == 1) {
        g2d.drawString(">", x - gp.tileSize, y);
    }

    text = "QUIT";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2d.drawString(text, x, y);
    if (commandNum == 2) {
        g2d.drawString(">", x - gp.tileSize, y);
    }

    // Dispose of the temporary graphics object
    g2d.dispose();
    
    
}
    public void drawTitleScreen(Graphics g) {
    // Create a temporary graphics object for drawing
    Graphics2D g2d = (Graphics2D) g.create();
    
//     try {
//            background_image = ImageIO.read(getClass().getResource("../background_image/Background_Certificate.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    // Draw background image
    g2d.drawImage(gp.player.background_image, 0, 0, gp.screenW, gp.screenH, null);
// g2d.setColor(new Color(0, 100, 0));
// g2d.fillRect(0, 0, gp.screenW, gp.screenH);
    // Draw text and other elements on top of the background image
    g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 96F));
    String text = "Math Island";
    int x = gp.tileSize * 5;
    int y = gp.tileSize * 3;

    g2d.setColor(Color.gray);
    g2d.drawString(text, x + 5, y + 5);

    g2d.setColor(Color.white);
    g2d.drawString(text, x, y);

    x = gp.screenW / 2 - (gp.tileSize * 2) / 3;
    y += gp.tileSize * 2;
    g2d.drawImage(gp.player.down1, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
    g2d.setFont(g2d.getFont().deriveFont(Font.BOLD, 48F));

    text = "CONTINUE";
    x = getXforCenteredText(text);
    y += gp.tileSize * 3.5;
    g2d.drawString(text, x, y);
    if (commandNum == 0) {
        g2d.drawString(">", x - gp.tileSize, y);
    }

    text = "NEW GAME";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2d.drawString(text, x, y);
    if (commandNum == 1) {
        g2d.drawString(">", x - gp.tileSize, y);
    }
    
    text = "LEADERBOARD";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2d.drawString(text, x, y);
    if (commandNum == 2) {
        g2d.drawString(">", x - gp.tileSize, y);
    }

    text = "QUIT";
    x = getXforCenteredText(text);
    y += gp.tileSize;
    g2d.drawString(text, x, y);
    if (commandNum == 3) {
        g2d.drawString(">", x - gp.tileSize, y);
    }

    // Dispose of the temporary graphics object
    g2d.dispose();
    
    
}



    public int getXforCenteredText(String text) {
        int length = (int) g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
        int x = gp.screenW / 2 - length / 2;
        return x;
    }
    public void leaderboard() {
        try {
        Runtime.getRuntime().exec("cmd /c start chrome http://localhost/Math%20Island%20Website/phpHtml/leaderboard.php");
    } catch (java.io.IOException e) {
        System.out.println(e.getMessage());
    }
    }
    



    public void drawOptionMenu(Graphics g) {
        // Check if the game state is optionsState
        if (gp.gameState == gp.optionsState) {
            // Define menu dimensions and position
            int menuWidth = 300; // Adjust as needed
            int menuHeight = 200; // Adjust as needed
            int menuX = (gp.screenW - menuWidth) / 2; // Center horizontally
            int menuY = (gp.screenH - menuHeight) / 2; // Center vertically

            // Draw menu background
            g.setColor(new Color(1, 50, 32));
            g.fillRect(menuX, menuY, menuWidth, menuHeight);

            // Set font and color
            g.setFont(g.getFont().deriveFont(Font.BOLD, 24F));
            g.setColor(Color.white);

            // Define menu options
            String[] options = {"BACK", "RESUME", "INSTRUCTIONS", "QUIT"}; // Adjust as needed

            // Draw options
            int optionHeight = 40; // Adjust spacing between options
            int currentY = menuY + 40; // Initial Y position for the first option
            for (int i = 0; i < options.length; i++) {
                String option = options[i];
                int textWidth = g.getFontMetrics().stringWidth(option);
                int textX = menuX + (menuWidth - textWidth) / 2;
                g.drawString(option, textX, currentY);
                if (commandNum == i) {
                    // Draw ">" next to the selected option
                    int arrowX = menuX - 30; // Adjust the distance of ">" from the option text
                    g.drawString(">", arrowX, currentY);
                }
                currentY += optionHeight;
            }
            
        }
    }
    
  public void drawInstructions(Graphics g) {
    // Define instructions dimensions and position
    int instructionsWidth = 600; // Adjust as needed
    int instructionsHeight = 400; // Adjust as needed
    int instructionsX = (gp.screenW - instructionsWidth) / 2; // Center horizontally
    int instructionsY = (gp.screenH - instructionsHeight) / 2; // Center vertically

    // Draw instructions background
    g.setColor(new Color(1, 50, 32));
    g.fillRect(instructionsX, instructionsY, instructionsWidth, instructionsHeight);

    // Set font and color for the instructions
    g.setFont(g.getFont().deriveFont(Font.BOLD, 13F));
    g.setColor(Color.white);

    // Define instruction steps
    String[] steps = {
        "Movement: Use W, A, S, D keys to move the character.",
        "Interact with Stones: Press ENTER to interact with stones and solve math problems.",
        "Answer the Question: To answer the question, simply press ENTER.",
        "Cancel Answer: To cancel the answer, simply press ENTER again.",
        "Math Symbol:",
        "Parenthesis = ( )",
        "Exponent = ^2 or other numbers",
        "Multiplication = *",
        "Division = /",
        "Addition = +",
        "Subtraction = -"
    }; // Adjust as needed

    // Draw instruction steps
    int lineSpacing = 10; // Adjust line spacing between steps
    int currentY = instructionsY + 40; // Initial Y position for the first step
    for (int i = 0; i < steps.length; i++) {
        String step = steps[i];
        int textX = instructionsX + 10; // Align text to the left within the instructions box
        g.drawString(step, textX, currentY);
        currentY += g.getFontMetrics().getHeight() + lineSpacing; // Increase Y position by font height plus line spacing
    }

    // Draw "Back" button
    g.setFont(g.getFont().deriveFont(Font.BOLD, 16F));
    String backButton = "Back";
    int backButtonWidth = g.getFontMetrics().stringWidth(backButton);
    int backButtonX = instructionsX + (instructionsWidth - backButtonWidth) / 2;
    int backButtonY = instructionsY + instructionsHeight - 30; // Adjust vertical position of the back button
    g.drawString(backButton, backButtonX, backButtonY);
    int arrowX = backButtonX - 20; // Adjust the distance of ">" from the option text
    g.drawString(">", arrowX, backButtonY);

    // Check if the enter key is pressed to return to optionsState
   
    
       if (gp.keyH.isEnterPressed() && commandNum == 0) {
        // Change game state to optionsState
        gp.gameState = gp.optionsState;
        // Reset commandNum when returning to optionsState
        commandNum = 0;
    }
       
      
}





// Helper method to draw wrapped text


// Helper method to draw wrapped text

 
  
    public void displayMessage(String message) {
    g2d.setFont(new Font("Arial", Font.BOLD, 40));
    g2d.setColor(Color.WHITE);
    int messageWidth = g2d.getFontMetrics().stringWidth(message);
    int messageX = (gp.screenW - messageWidth) / 2;
    int messageY = gp.screenH / 2;
    g2d.drawString(message, messageX, messageY);

    if (messageOn) {
        g2d.setFont(g2d.getFont().deriveFont(30F));
        g2d.drawString(message, gp.tileSize / 2, gp.tileSize * 5);
        messageCounter++;

        if (messageCounter > 120) {
            messageCounter = 0;
            messageOn = false;
        }
    }
}
  

    public void drawPickState(Graphics g) {
    try {
        String text;
        String textTitle = "Choose Character";
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, gp.screenW, gp.screenH);

        g.setFont(arial_40);
        g.setColor(Color.white);

        int x = gp.tileSize * 5;
        int xx = gp.tileSize * 6;
        int yy = gp.tileSize * 3;
        int y = gp.tileSize * 3;
        int yyy = gp.tileSize * 1;
        int xxx = gp.tileSize * 6;

        g.setColor(Color.gray);
        g.drawString(textTitle, xxx += gp.tileSize * .5, yyy += gp.tileSize * 0.5);

        if (gp.player.down1 != null) {
            g.drawImage(gp.player.down1, xx += gp.tileSize * .3, y, gp.tileSize * 2, gp.tileSize * 2, null);
        }

        text = "Male";
        x += gp.tileSize * 1.5;
        y += gp.tileSize * 4.0;
        g.drawString(text, x, y);
        if (commandNum == 0) {
            g.drawString(">", x - gp.tileSize, y);
        }

        if (gp.Gplayer.down1 != null) {
            g.drawImage(gp.Gplayer.down1, xx += gp.tileSize * 5.5, yy, gp.tileSize * 2, gp.tileSize * 2, null);
        }
        text = "Female";
        x += gp.tileSize * 5.0;
        y += gp.tileSize * 0;
        g.drawString(text, x, y);
        if (commandNum == 1) {
            g.drawString(">", x - gp.tileSize, y);
        }

        text = "Back";
        x += gp.tileSize * -2.5;
        y += gp.tileSize * 4;
        g.drawString(text, x, y);
        if (commandNum == 2) {
            g.drawString(">", x - gp.tileSize, y);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
   

}
