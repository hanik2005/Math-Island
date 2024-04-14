/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import backend.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
     public static JFrame window;
     public static GamePanel gpanel = new GamePanel(); // Instantiates the GPanel class


	public static void main(String[] args) {
//		 TODO Auto-generated method stub
                UserData.setUserDatas();
                ArrayList<String> userNames = UserData.getUsernames();
                ArrayList<Float> userTimes = UserData.getPlayTimes();
//                ArrayList<String> userCategory = UserData.getUserCategoryArray();
           
               Form loginForm = new Form();
               loginForm.setVisible(true);
               loginForm.setLocationRelativeTo(null);
                
//               runTheProgram();
                
                System.out.println(userNames);
                System.out.println(userTimes);
//                System.out.println(userCategory);
                System.out.println("Hello the thread ran this");

        }
        
        public static void runTheProgram() {
                    window = new JFrame(); // Instantiates a frame
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets the close operation
                    window.setResizable(false); // Sets resizable to false
                    window.setTitle("Math Island"); // Sets the frame title
                   


                    // Load logo image
                     

                    
                    window.add(gpanel); // Adds the GPanel to the frame

                    window.pack(); // Packs all the component to fit in the frame
                    window.setLocationRelativeTo(null); // Centers the frame 
                    window.setVisible(true); // Sets visible to true
                    System.out.println("Hello World");
                     UserData userData = new UserData(); // Create an instance of UserData
                    System.out.println(userData.getUserName());
                    // Game Thread Section

                    gpanel.setupGame();
                    gpanel.startGameThread();

//                    thread2.start();
        }

		
}