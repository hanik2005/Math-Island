package main;

import entity.Player;
import entity.girlPlayer;
import tile.*;
import javax.swing.JPanel;
import java.lang.Thread;
import java.text.DecimalFormat;
import object.SuperObject;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import object.OBJ_ManaCrystal;

public class GamePanel extends JPanel implements Runnable {
    // SETTINGS
    public final int origTileSize = 16; // 16 x 16 px
    public final int scale = 3;
    public final int tileSize = origTileSize * scale; // 48 px
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 12;
    public final int screenW = tileSize * maxScreenCol; // 768 px
    public final int screenH = tileSize * maxScreenRow; // 576 px
    public final int FPS = 60;
    public double playTime;
    // WORLD SETTINGS
    public int maxWorldCol = 50;
    public int maxWorldRow = 50;
    // FOR FULL SCREEN
    int screenWidth2 = screenW;
    int screenHeight2 = screenH;
    BufferedImage tempScreen;
    Graphics2D g2;

    public final int worldWidth = tileSize * maxWorldCol;
    public final int wordHeight = tileSize * maxWorldRow;
    public final int maxMap = 10;
    public int currentMap = 1;
    Font arial_40, arial_80B;
    // Class instantiations
    public DecimalFormat dFormat = new DecimalFormat("#0.00");
    public KeyHandler keyH = new KeyHandler(this);
    public Thread gameThread;
    public Player player = new Player(this, keyH);
    public girlPlayer Gplayer = new girlPlayer(this, keyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public anotherCollsionChecker ccchecker = new anotherCollsionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public EventHandler eHandler = new EventHandler(this);
    public SuperObject obj[][] = new SuperObject[maxMap][100];
    public TileManager tileM = new TileManager(this);
    public GameTimer gameTimer;
    public int anotherGameState;
    public int gameState;
    public CollisionChecker collisionChecker;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int leaderboardState = 4;
    public final int optionsState = 5;
    public final int instructionState = 6;
    public final int questionsState = 7;
    public final int pickState = 8;
    public final int anotherTitleState = 9;
    public Sound music = new Sound();
    Sound se = new Sound();
    public UI ui = new UI(this);
    public BufferedImage buffer;
    public boolean running = false;
    public double finalTime;
    public boolean gameFinished;
    public int gender;
    
    // Set player's position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;
    // Constructor
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenW, screenH)); // Sets the panel size
        this.setBackground(Color.black); // Sets the background color
        this.setDoubleBuffered(true); // For better rendering
        this.addKeyListener(keyH);
        this.setFocusable(true);
        buffer = new BufferedImage(screenW, screenH, BufferedImage.TYPE_INT_RGB);
        
    }

    public void setupGame() {
        aSetter.setObject();
        // playMusic(0);
        gameState = anotherTitleState;

        tempScreen = new BufferedImage(screenW, screenH, BufferedImage.TYPE_INT_RGB);
        g2 = (Graphics2D)tempScreen.getGraphics();

        // Remove the full-screen setting
        // setFullScreen();
        
    }
     

    public void startGameThread() {
        gameThread = new Thread(this); // Instantiates the thread to the GPanel class
        gameThread.start(); // Calls the run method automatically
    }

    @Override // Runnable interface implemented method
    public void run() {
        // Game loop format delta/accumulator method
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                // UPDATE: Updates the info such as the character position
                if(gender == 0){
                update();
                }else if (gender == 1){
                    update2();
//                    update();
                }

                // DRAW: Draws the updated info
                // repaint(); // Calls the paintComponent() method;
                drawToTempScreen();
                drawToScreen();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                drawCount = 0;
                timer = 0;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2dBuffer = (Graphics2D) buffer.getGraphics();
    

    if (gameState == titleState) {
        ui.draw(g2dBuffer);
    }else if (gameState == pickState){
        ui.draw(g2dBuffer);
    }else {
        tileM.draw(g2dBuffer);
        for (int i = 0; i < obj[1].length; i++) {
            if (obj[currentMap][i] != null) {
                obj[currentMap][i].draw(g2dBuffer, this);
            }
        }
        if (gender == 0){
        player.draw(g2dBuffer);
        } else if (gender == 1){
            Gplayer.draw(g2dBuffer);
        }
        ui.draw(g2dBuffer);
        if (gameState == playState && !ui.gameFinished) { // Check if game is in playState and gameFinished flag is true
            g2dBuffer.setFont(arial_40);
            g2dBuffer.setColor(Color.black);
            g2dBuffer.drawString("Time: " + dFormat.format(playTime), tileSize * 15, 65);
        }
    }

    g2dBuffer.dispose();
    g.drawImage(buffer, 0, 0, getWidth(), getHeight(), null);
}

    public void update() {
        // This updates the position of the character/player
        
        player.update();
        
        
        updateGameTimer();
        repaint();
    }
    public void update2(){
         Gplayer.update();
        
        updateGameTimer();
        repaint();
    }

    public void drawToTempScreen() {
        if (gameState == titleState) {
            ui.draw(g2);
        } else if (gameState == pickState){
        ui.draw(g2);
    } else {
            tileM.draw(g2);
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null) {
                    obj[currentMap][i].draw(g2, this);
                }
            }
           if (gender == 0){
        player.draw(g2);
        } else if (gender == 1){
            Gplayer.draw(g2);
        }
            ui.draw(g2); // Calls the draw in UI class
            if (gameState == playState && !ui.gameFinished) {
                g2.setFont(arial_40);
                g2.setColor(Color.black);
                g2.drawString("Time: " + dFormat.format(playTime), tileSize * 15, 65);
            }
        }
    }

    public void drawToScreen() {
        Graphics g = getGraphics();
        g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
        g.dispose();
    }

    public void playMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic(int par) {
        music.stop();
    }

    public void playSE(int i) {
        se.setFile(i);
        se.play();
    }

    public void updateGameTimer() {
        if (gameState == playState) {
            playTime += (double) 1 / FPS; // Increment playTime at half the speed
        }
    }


    public void startGameTimer() {
        // Create a new instance of GameTimer
        gameTimer = new GameTimer(this);

        // Create a new thread and start the GameTimer
        Thread gameTimerThread = new Thread(gameTimer);
        gameTimerThread.start();
    }
    public void startGameTimer1() {
    if (!gameTimerIsRunning()) {
        Thread gameTimerThread = new Thread(new GameTimer(this));
        gameTimerThread.start();
    }
}

public boolean gameTimerIsRunning() {
    return gameTimer != null && gameTimer.isAlive();
}
    

    public void stopGameTimer() {
          // Call the stop method on the GameTimer instance
    if (gameTimer != null) {
        gameTimer.stop();
    }
    // Set gameFinished to true
    ui.gameFinished = true;
    // Set the final time
    // ui.finalTime = playTime; // Remove this line
    ui.finalTime = playTime; // Update finalTime with gp.playTime

 
    }
    public void finishGame() {
    // Stop the game timer
    stopGameTimer();
    // Set the game finished flag in UI
    ui.setGameFinished(true);
    // Repaint to update UI
    repaint();
}
    public void startGame(){
         // Stop the previous game timer if it exists
    stopGame();

    // Create a new instance of GameTimer
    gameTimer = new GameTimer(this);

    // Create a new thread and start the GameTimer
    Thread gameTimerThread = new Thread(gameTimer);
    gameTimerThread.start();
    }
    public void stopGame(){
        // Call the stop method on the GameTimer instance
    
//     Set gameFinished to true
    ui.gameFinished = true;
    // Set the final time
    ui.finalTime = playTime;
    }

    public void closeFrame() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        frame.dispose();
    }
   
    

    public void startNew() {
        Main.runTheProgram();
    }
    

 
public void resetObjects() {
    AssetSetter assetSetter = new AssetSetter(this);
    assetSetter.setObject(); // This will reset the objects to their initial positions
}
    
}
