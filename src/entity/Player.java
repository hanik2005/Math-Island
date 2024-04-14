package entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import main.GamePanel;
import main.KeyHandler;
import main.MathProblems;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.TimerTask;

public class Player extends Entity {
    GamePanel gp;
     public Graphics2D g2d;
     public Graphics2D g;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasOrb = 0;
    public int mana = 0;
    public boolean pick = true;
    public boolean isDisplayDialog = false;
    public boolean dFormat = false;
    public boolean isSpecialAnimation = false;
    public String currentProblem;
    public String userAnswer;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        int gender;
        
 
        solidArea = new Rectangle(0, 0, 32, 32);
        solidArea.x = 8;
        solidArea.y = 8;
        solidArea.width = 28;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        screenX = gp.screenW / 2 - (gp.tileSize / 2);
        screenY = gp.screenH / 2 - (gp.tileSize / 2);
        
        setDefaultValues();
        
       getPlayerImage();
        
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 18;
        worldY = gp.tileSize * 38;
        speed = 5;
        direction = "down";
        
        
//        worldX = gp.tileSize * 26;
//        worldY = gp.tileSize * 24;
//        speed = 5;
//        direction = "up";
    }

    public void getPlayerImage() {
        try {
            // Loading images...
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/front_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/front_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/side_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/side_left_walk_1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/side_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/side_right_walk_1.png"));
            picture1 = ImageIO.read(getClass().getResourceAsStream("/objects/FinalPortal.png"));
            picture2 = ImageIO.read(getClass().getResourceAsStream("/objects/Orb.png"));
            picture3 = ImageIO.read(getClass().getResourceAsStream("/objects/MagicalDoor.png"));
            up_special = ImageIO.read(getClass().getResourceAsStream("/player/up_2_specialNew.png"));
            down_special = ImageIO.read(getClass().getResourceAsStream("/player/front_2_specialNew.png"));
             left_special = ImageIO.read(getClass().getResourceAsStream("/player/side_left_specialNew.png"));
             right_special = ImageIO.read(getClass().getResourceAsStream("/player/side_right_specialNew.png"));
             background_image = ImageIO.read(getClass().getResource("/background_image/Background_Certificate.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     

    public void update() {
         int objIndex = gp.cChecker.checkObject(this, true);
        // Check if Enter key is pressed
        // Check if Enter key is pressed
        if (keyH.enterPressed) {
            // Check if standing in front of a stone
       
            if (objIndex != 999 && gp.obj[gp.currentMap][objIndex].name.equals("Stone")) {
                // Interact with the stone
                interactWithStone(objIndex);
//                interactStone(objIndex);

 

                
                dFormat = false;
            }
        }
         // Check if Q key is pressed and mana is sufficient
    

//         Check if Q key is pressed
         if (keyH.isQPressed() && mana >= 4) {
            if (objIndex != 999 && gp.obj[gp.currentMap][objIndex].name.equals("Stone")) {
                dFormat = true;
                performSpecialAnimation(objIndex);
                 startAnimationTimer();
//                  makePerformSpecialAnimation();
//                startAnimationTimer(); // Start the animation timer
            } else {
                dFormat = true;
                performSpecialAnimation(objIndex);
                checkQKeyPress(objIndex);
                mistakeStartAnimationTimer(); // Start the animation timer
//                  gp.ui.showMessage("Special Power: Hit the stone first");
            }
        } else {
            if (objIndex != 999 && gp.obj[gp.currentMap][objIndex].name.equals("enemy")) {
                interactWithEnemy(objIndex);
                dFormat = false;
            }
        }
          
        // Movement logic
        if (!isDisplayDialog && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)) {
            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }
            collisionOn = false;
            gp.cChecker.checkTile(this);
            objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            gp.eHandler.checkEvent();

            if (!collisionOn) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
    }
    public void interactStone (int i){
        if (i != 999){
            gp.gameState = gp.dialogueState;
        }
        
    }
public void performSpecialAnimation(int objIndex) {
    
    if (objIndex >= 0 && objIndex < gp.obj[gp.currentMap].length) {
        // Make the stone disappear
        
        gp.obj[gp.currentMap][objIndex] = null;
        // Reset mana to zero
           dFormat = true;
            gp.playSE(4);
           startAnimationTimer();
           System.out.println(dFormat);
        
        // Set flag to indicate special animation should be played
        // Declare dFormat as final
        
//         System.out.println(dFormat);
        
//         startAnimationTimer();
    } else {
        System.err.println("Error: objIndex is out of bounds");
//        dFormat = true;
        // Handle the case where objIndex is out of bounds
//        System.err.println("Error: objIndex is out of bounds");
//        gp.ui.showMessage("Special Power: Hit the stone first");
    }
}
public void performSpecialAnimation1(int objIndex) {
    
    if (objIndex >= 0 && objIndex < gp.obj[gp.currentMap].length ) {
        // Make the stone disappear
        
        gp.obj[gp.currentMap][objIndex] = null;
        // Reset mana to zero
           dFormat = true;
            gp.playSE(4);
           startAnimationTimer();
           System.out.println(dFormat);
        
        // Set flag to indicate special animation should be played
        // Declare dFormat as final
        
//         System.out.println(dFormat);
        
//         startAnimationTimer();
    } else {
        System.err.println("Error: objIndex is out of bounds");
            gp.ui.showMessage("Special Power: Hit the stone first");
//        dFormat = true;
        // Handle the case where objIndex is out of bounds
//        System.err.println("Error: objIndex is out of bounds");
//        gp.ui.showMessage("Special Power: Hit the stone first");
    }
}




private void startAnimationTimer() {
    Timer timer = new Timer(1000, new ActionListener() { // Adjust the delay (3000 milliseconds = 3 seconds)
        @Override
        public void actionPerformed(ActionEvent e) {
            // Reset to normal animation after the delay
            dFormat = false;
            mana = 0;
            // Optionally, you can reset the mana here if needed
        }
    });
    timer.setRepeats(false); // Ensure the timer only triggers once
    timer.start();
}
private void mistakeStartAnimationTimer() {
    Timer timer = new Timer(1000, new ActionListener() { // Adjust the delay (3000 milliseconds = 3 seconds)
        @Override
        public void actionPerformed(ActionEvent e) {
            // Reset to normal animation after the delay
            dFormat = false;
            // Optionally, you can reset the mana here if needed
        }
    });
    timer.setRepeats(false); // Ensure the timer only triggers once
    timer.start();
}



    // Other methods...

    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[gp.currentMap][i].name;
            switch (objectName) {
                case "Orb":
                    gp.playSE(1);
                    hasOrb++;
                    gp.obj[gp.currentMap][i] = null;
                    gp.ui.showMessage("You got an Orb ");
                    break;
                case "MagicalDoor":
                    if (hasOrb == 2) {
                        gp.ui.gameFinished = true;
                        gp.playSE(2);
                        gp.obj[gp.currentMap][i] = null;
                        gp.ui.showMessage("You opened the door");
                    } else {
                        gp.ui.showMessage("You need 2 purple Orbs ");
                    }
                    break;
                case "FinalPortal":
                    if (hasOrb >= 2) {
                          gp.ui.showMessage("You have reached the FinalPortal!");
                    } else {
                        gp.ui.showMessage("You need 2 purple Orbs");
                    }
                    break;
                case "Stone":
                   
                    // No action needed here since stone interaction is handled separately
                    
                    
                    
                   
                    break;
                    
                     case "disManaCrystal":
                    gp.playSE(5);
                    mana++;
                    gp.obj[gp.currentMap][i] = null;
                    gp.ui.showMessage("mana +1");
                   
                    break;
                    
                case "enemy":
                    break;
                    
                case "LastPortal":
                        gp.stopMusic(3);
                        gp.playSE(3);
                        gp.ui.gameFinished = true;
                        gp.stopMusic(3);
                        break;
            }
        }
    }
 public void manaTesting() {
    if (keyH.isQPressed() && mana >= 4) { // Check if Q key is currently pressed and if mana is sufficient
        int objIndex = gp.cChecker.checkObject(this, true);
        System.out.println("Object index: " + objIndex);
        if (objIndex != 999 && gp.obj[gp.currentMap][objIndex].name.equals("Stone")) {
            // Make the stone disappear
            gp.obj[gp.currentMap][objIndex] = null;
            // Reset mana to zero
            mana = 0;
        }
    }
}



    public void interactWithStone(int i) {
    try {
        
        gp.ui.showMessage("Press Enter if you are done");

        if (!isDisplayDialog) {
            isDisplayDialog = true;

            SwingUtilities.invokeLater(() -> {
                int currentProblemIndex = generateNumber();
                dFormat = true;

                keyH.downPressed = false;
                keyH.upPressed = false;
                keyH.leftPressed = false;
                keyH.rightPressed = false;

                JLabel questionLabel = new JLabel("What is " + MathProblems.problems[currentProblemIndex]);
                Font largerFont = questionLabel.getFont().deriveFont(Font.BOLD, 16f); // 16f is the desired font size
                questionLabel.setFont(largerFont);
                JTextField inputField = new JTextField(20);

                inputField.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                            String userAnswer = inputField.getText();
                            if (userAnswer != null) {
                                if (isANumber(userAnswer)) {
                                    if (userAnswer.equalsIgnoreCase(MathProblems.answers[currentProblemIndex])) {
                                        gp.obj[gp.currentMap][i] = null;
                                        mana++;
                                        gp.playSE(5);
                                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                                "You got the correct answer");
                                    } else {
                                        JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                                "Incorrect answer");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                            "You have to enter a number");
                                    keyH.enterPressed = false;
                                }
                            } else {
                                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                        "You have to enter something");
                            }
                            isDisplayDialog = false;
                            // Close the dialog
                            Window window = SwingUtilities.getWindowAncestor(inputField);
                            if (window instanceof JDialog) {
                                JDialog dialog = (JDialog) window;
                                dialog.dispose();
                            }

                            // Set focus back to the game panel
                            gp.requestFocusInWindow();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

                JPanel panel = new JPanel();
                panel.add(questionLabel);
                panel.add(inputField);

                JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(gp), "Math Problem",
                        Dialog.ModalityType.APPLICATION_MODAL);
                dialog.getContentPane().add(panel);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.pack();
                dialog.setLocationRelativeTo(gp);
                dialog.setVisible(true);

                // Set focus back to the game panel
                gp.requestFocusInWindow();
            });
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
}

    

   public void draw(Graphics g) {
    BufferedImage image = null;

    switch (direction) {
        case "up":
            if (mana >= 4 && dFormat) {
                image = up_special;
            } else {
                if (spriteNumber == 1) {
                    image = up1;
                } else if (spriteNumber == 2) {
                    image = up2;
                }
            }
            break;
        case "down":
            if (mana >= 4 && dFormat) {
                image = down_special;
            } else {
                if (spriteNumber == 1) {
                    image = down1;
                } else if (spriteNumber == 2) {
                    image = down2;
                }
            }
            break;
        case "right":
            if (mana >= 4 && dFormat) {
                image = right_special;
            } else {
                if (spriteNumber == 1) {
                    image = right1;
                } else if (spriteNumber == 2) {
                    image = right2;
                }
            }
            break;
        case "left":
            if (mana >= 4 && dFormat) {
                image = left_special;
            } else {
                if (spriteNumber == 1) {
                    image = left1;
                } else if (spriteNumber == 2) {
                    image = left2;
                }
            }
            break;
    }
    g.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
}


    public boolean isANumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int generateNumber() {
        Random random = new Random();
        return random.nextInt(MathProblems.problems.length - 1);
    }

    public void setDefaultValues2() {
        gp.currentMap = 1;
        worldX = gp.tileSize * 18;
        worldY = gp.tileSize * 38;
        direction = "down"; // Reset player direction
    spriteNumber = 1; // Reset sprite animation
    spriteCounter = 0; // Reset sprite counter
    }
    public void resetPosition() {
    setDefaultValues2();
}
   
// Custom input dialog to remove OK and Cancel buttons
public String showCustomInputDialog(String message) {
     JTextField textField = new JTextField(10);
    textField.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                textField.getParent().getParent().setVisible(false);
            }
        }
    });

    JPanel panel = new JPanel();
    JLabel label = new JLabel(message);
    panel.add(label);
    panel.add(textField);
    
    JOptionPane pane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
    JDialog dialog = pane.createDialog(null, "");
    dialog.setVisible(true);
    dialog.dispose();

    Object selectedValue = pane.getInputValue();
    if (selectedValue instanceof String) {
        return (String) selectedValue;
    }
    return null;
}
public void talkToEnemy(int i) {
    try {
        // Display dialogue for the enemy
        gp.ui.showMessage("Enemy: Hello there! Are you ready to battle?");
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
}
public void interactWithEnemy(int i) {
    try {
        // Display dialogue for the enemy
        gp.ui.showMessage("Enemy: Hello there! Are you ready to battle?");
        // Check if Enter key is pressed
        if (keyH.enterPressed) {
            // Display math question prompt
            displayMathQuestion(i);
            // Reset enterPressed flag
            keyH.enterPressed = false;
        }
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
}
private void displayMathQuestion(int i) {
    if (!isDisplayDialog) {
        isDisplayDialog = true;

        SwingUtilities.invokeLater(() -> {
            int currentProblemIndex = generateNumber();
            dFormat = true;

            keyH.downPressed = false;
            keyH.upPressed = false;
            keyH.leftPressed = false;
            keyH.rightPressed = false;

            JLabel questionLabel = new JLabel("What is " + MathProblems.problems[currentProblemIndex]);
            Font largerFont = questionLabel.getFont().deriveFont(Font.BOLD, 16f); // 16f is the desired font size
            questionLabel.setFont(largerFont);
            JTextField inputField = new JTextField(20);

            inputField.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String userAnswer = inputField.getText();
                        if (userAnswer != null) {
                            if (isANumber(userAnswer)) {
                                if (userAnswer.equalsIgnoreCase(MathProblems.answers[currentProblemIndex])) {
                                    gp.obj[gp.currentMap][i] = null;
                                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                            "You got the correct answer");
                                } else {
                                    JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                            "Incorrect answer");
                                }
                            } else {
                                JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                        "You have to enter a number");
                                keyH.enterPressed = false;
                            }
                        } else {
                            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(gp),
                                    "You have to enter something");
                        }
                        isDisplayDialog = false;
                        // Close the dialog
                        Window window = SwingUtilities.getWindowAncestor(inputField);
                        if (window instanceof JDialog) {
                            JDialog dialog = (JDialog) window;
                            dialog.dispose();
                        }

                        // Set focus back to the game panel
                        gp.requestFocusInWindow();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });

            JPanel panel = new JPanel();
            panel.add(questionLabel);
            panel.add(inputField);

            JDialog dialog = new JDialog(SwingUtilities.getWindowAncestor(gp), "Math Problem",
                    Dialog.ModalityType.APPLICATION_MODAL);
            dialog.getContentPane().add(panel);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.pack();
            dialog.setLocationRelativeTo(gp);
            dialog.setVisible(true);

            // Set focus back to the game panel
            gp.requestFocusInWindow();
        });
    }
}
public int getHasOrb() {
    return hasOrb;
}
public void setHasOrb(int value) {
    this.hasOrb = value;
}
public void setMana(int value) {
    this.mana = value;
}
public void checkQKeyPress(int objIndex) {
    if (keyH.isQPressed() && mana >= 4) {
        performSpecialAnimation1(objIndex);
        mistakeStartAnimationTimer(); 
    }else {
//    gp.ui.showMessage("Special Power: Hit the stone first");
        // If Q is pressed but mana is insufficient, handle it here
        // For example, display a message or perform another action
    }

}
public void message (){
    gp.ui.showMessage("Special Power: Hit the stone first");
}

 


}
