/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    boolean isPaused = false; // New variable to track if the music is paused

    public Sound() {
        soundURL[0] = getClass().getResource("/sounds/adventures-in-adventureland-by-kevin-macleod-from-filmmusic-io.wav");
        soundURL[1] = getClass().getResource("/sounds/coin.wav");
        soundURL[2] = getClass().getResource("/sounds/unlock.wav");
        soundURL[3] = getClass().getResource("/sounds/fanfare.wav");
        soundURL[4] = getClass().getResource("/sounds/attack.wav");
        soundURL[5] = getClass().getResource("/sounds/powerup.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
        isPaused = false; // Reset isPaused flag when resuming playback
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        isPaused = false; // Reset isPaused flag when resuming playback
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPaused = true;
        }
    }

    public void resume() {
        if (isPaused && clip != null) {
            clip.start();
            isPaused = false;
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
