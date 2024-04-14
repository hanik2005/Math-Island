package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.text.DecimalFormat;

public class GameTimer implements Runnable {
    private volatile boolean running;
    private GamePanel gp;

    public GameTimer(GamePanel gp) {
        this.gp = gp;
        this.running = true;
    }

    public void stop() {
        running = false;
    }
     public boolean isAlive() {
        return running;
    }

    @Override
    public void run() {
        long desiredFrameTime = 1000 / 60; // 60 FPS

        while (running) {
            long startTime = System.currentTimeMillis();

            // Update game state

            // Update game timer in the game panel
            gp.updateGameTimer();
            // Trigger repainting of the game panel
            gp.repaint();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = desiredFrameTime - elapsedTime;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
