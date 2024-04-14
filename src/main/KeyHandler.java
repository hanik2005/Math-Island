package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import backend.UserData;
import entity.Player;
import backend.AdminForm;

public class KeyHandler implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean enterPressed;
    public boolean mPressed; // New variable for the M key
    public boolean qPressed = false;
    public boolean qWasPressed = false;
    GamePanel gp;
    private boolean collisionDetected;
    private Player player;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int keyCode = e.getKeyCode();

        if (gp.gameState == gp.titleState) {
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    gp.gameState = gp.playState;
                    gp.ui.showMessage("Find two Portals");
                    gp.playMusic(0);
                      
                }
                if (gp.ui.commandNum == 1) {
//                    gp.gameState = gp.playState;
                    gp.gameState = gp.pickState;
                }
                if (gp.ui.commandNum == 2) {
                    // Exit the game
                    gp.ui.leaderboard();
                }
                if (gp.ui.commandNum == 3) {
                    // Exit the game
                    System.exit(0);
                }
            }
        }else if (gp.gameState == gp.anotherTitleState){
            if (code == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if (code == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
//                    gp.gameState = gp.playState;
                    gp.gameState = gp.pickState;
                }
                if (gp.ui.commandNum == 1) {
                    // Exit the game
                    gp.ui.leaderboard();
                }
                if (gp.ui.commandNum == 2) {
                    // Exit the game
                    System.exit(0);
                }
            }
        }else if (gp.gameState == gp.leaderboardState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.titleState;
            }
        } else if (gp.ui.gameFinished) {
            if (code == KeyEvent.VK_ENTER) {
                gp.closeFrame();
                gp.ui.gameFinished = false;
                gp.player.setDefaultValues2();
                gp.playTime = 0;
                gp.startNew();
            }
        } else if (gp.gameState == gp.optionsState) {
            if (keyCode == KeyEvent.VK_W) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 2;
                }
            }
            if (keyCode == KeyEvent.VK_S) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 3) {
                    gp.ui.commandNum = 0;
                }
            }
            if (keyCode == KeyEvent.VK_ENTER) {
                if (gp.ui.commandNum == 0) {
                    Main.gpanel.music.stop();
                    gp.gameState = gp.titleState;
                } else if (gp.ui.commandNum == 1) {
                    gp.ui.paused = false;
                    gp.gameState = gp.playState;
                    Main.gpanel.music.resume();
                } else if (gp.ui.commandNum == 2) {
                    gp.gameState = gp.instructionState;
                } else if (gp.ui.commandNum == 3) {
                    System.exit(0);
                }
            }
        } else if (gp.gameState == gp.instructionState) {
            if (code == KeyEvent.VK_ENTER) {
                gp.gameState = gp.optionsState;
            }
        } else if (gp.gameState == gp.pickState){
             if (code == KeyEvent.VK_A) {
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0) {
                    gp.ui.commandNum = 1;
                }
            }
            if (code == KeyEvent.VK_D) {
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2) {
                    gp.ui.commandNum = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER ) {
        if (gp.ui.commandNum == 0) {
               gp.gender = 0; // Set gender to 0 for male
            gp.gameState = gp.playState;
            gp.ui.showMessage("Find two Portals");
            gp.playMusic(0);
//            resetPlayerPosition();
                gp.playTime = 0;
                    gp.resetObjects();
                    
//            gp.player.getPlayerImage(); // Set player image for male character
            // Transition to the next game state, e.g., optionsState
        } else if (gp.ui.commandNum == 1) {
             gp.gender = 1; // Set gender to 0 for male
            gp.gameState = gp.playState;
            gp.ui.showMessage("Find two Portals");
            gp.playMusic(0);
//            resetPlayerPosition();
                gp.playTime = 0;
                    gp.resetObjects();
            // Set player image for female character
          
        }else if (gp.ui.commandNum == 2){
            gp.gameState = gp.anotherTitleState;
            
        }
    }
        }

        // Responsible for player movements
        if (gp.gameState == gp.playState) {
            if (gp.gameState != gp.optionsState) {
                if (keyCode == KeyEvent.VK_W) {
                    upPressed = true;
                }
                if (keyCode == KeyEvent.VK_A) {
                    leftPressed = true;
                }
                if (keyCode == KeyEvent.VK_S) {
                    downPressed = true;
                }
                if (keyCode == KeyEvent.VK_D) {
                    rightPressed = true;
                }
                if (keyCode == KeyEvent.VK_ESCAPE) {
                    gp.gameState = gp.optionsState;
                    Main.gpanel.music.pause();
                }
                if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_KP_UP) {
                    upPressed = true;
                }
                if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_KP_LEFT) {
                    leftPressed = true;
                }
                if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_KP_RIGHT) {
                    rightPressed = true;
                }
                if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_KP_DOWN) {
                    downPressed = true;
                }

                if (keyCode == KeyEvent.VK_ENTER) {
                    enterPressed = true;
                }
                if (keyCode == KeyEvent.VK_Q) {
                    qPressed = true; // Set qPressed to true when Q key is pressed
                    
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (gp.gameState != gp.optionsState) {
            if (keyCode == KeyEvent.VK_W) {
                upPressed = false;
            }
            if (keyCode == KeyEvent.VK_A) {
                leftPressed = false;
            }
            if (keyCode == KeyEvent.VK_S) {
                downPressed = false;
            }
            if (keyCode == KeyEvent.VK_D) {
                rightPressed = false;
            }
            if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_KP_UP) {
                upPressed = false;
            }
            if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_KP_LEFT) {
                leftPressed = false;
            }
            if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_KP_RIGHT) {
                rightPressed = false;
            }
            if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_KP_DOWN) {
                downPressed = false;
            }
            if (keyCode == KeyEvent.VK_ENTER) {
                enterPressed = false;
            }
            if (keyCode == KeyEvent.VK_Q) {
                qPressed = false; // Set qPressed to false when Q key is released
                qWasPressed = true; // Set qWasPressed to false if qPressed is false
            }
        }
    }

    public void showAdminForm() {
        AdminForm adminForm = new AdminForm();
        adminForm.setVisible(true);
        adminForm.setLocationRelativeTo(null);
        adminForm.setResizable(false);
    }

    public void resetPlayerPosition() {
        // Reset player position to default values
        gp.player.setDefaultValues2();
        gp.player.setHasOrb(0);
        gp.player.setMana(0);
    }

    public boolean isEnterPressed() {
        return enterPressed;
    }
    public boolean isQPressed() {
    return qPressed;
}
    public boolean wasQPressed() {
        return qWasPressed;
    }

    // Method to reset qWasPressed
    public void resetQWasPressed() {
        qWasPressed = false;
    }

}
