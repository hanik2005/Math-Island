/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import main.UtilityTool;
import main.GamePanel;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TileManager {
    
   GamePanel gp;
   public Tile[] tile;
   public int mapTileNum[][][];
   ArrayList<String> fileNames = new ArrayList<>();
   ArrayList<String> collisionStatus = new ArrayList<>();
       public TileManager (GamePanel gp){

            this.gp=gp;

            // Read map data files
            InputStream is = getClass().getResourceAsStream("/maps/originalupdated.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;

            try {
                while((line = br.readLine()) != null){
                    fileNames.add(line);
                    collisionStatus.add(br.readLine());
                }
                br.close();

            } catch (IOException ex) {
                Logger.getLogger(TileManager.class.getName()).log(Level.SEVERE, null, ex);
            }

            tile= new Tile[fileNames.size()];
            getTileImage();

            is = getClass().getResourceAsStream("/maps/maze.txt");
            br = new BufferedReader(new InputStreamReader(is));

            try{
                String line2 = br.readLine();
                String maxTile[] = line2.split(" ");

                gp.maxWorldCol = maxTile.length;
                gp.maxWorldRow = maxTile.length;
                mapTileNum = new int [gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

                br.close();
            }
            catch (IOException e){
                System.out.print(e);
            }





            loadMap("/maps/maze.txt", 0);
            loadMap("/maps/lobby.txt", 1);
            loadMap("/maps/route.txt", 2);
            loadMap("/maps/lastMap.txt", 3);
    }
                
        
    
        
    public void getTileImage(){
        
        for( int i=0; i < fileNames.size(); i++){
            
            String fileName;
            boolean collision;
            
            fileName = fileNames.get(i);
            
            if (collisionStatus.get(i).equals("true")){
                collision=true;
            }
            else
                collision=false;
            
            setup(i, fileName, collision);
        }

    }
    
   public void setup( int index, String imageName, boolean collision){
        
        UtilityTool uTool = new UtilityTool();
        
        try{
            
            tile[index]= new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/"+ imageName));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadMap(String filePath, int map){
        
        try{
            InputStream is= getClass().getResourceAsStream(filePath);
            BufferedReader br= new BufferedReader(new InputStreamReader(is));   
            
            int col=0;
            int row=0;
            
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line=br.readLine();
                
                while(col<gp.maxWorldCol){
                    String numbers[]= line.split(" ");
                    int num= Integer.parseInt(numbers[col]);
                    
                    mapTileNum[map][col][row]=num;
                    col++;
                }
                if(col==gp.maxWorldCol){
                    col=0;
                    row++;
                }          
            }   
            br.close();
        }   
        catch(Exception e){
            
        }
    }
    
    public void draw(Graphics g) {
   
        int worldCol=0;
        int worldRow=0;
        
        
        while (worldCol < gp.maxWorldCol && worldRow <gp.maxWorldRow){
            
            int tileNum= mapTileNum[gp.currentMap][worldCol][worldRow];
                                    
            int worldX= worldCol * gp.tileSize;
            int worldY= worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX +gp.player.screenX;
            int screenY = worldY - gp.player.worldY +gp.player.screenY;
            int screenXX = worldX - gp.Gplayer.worldX +gp.Gplayer.screenX;
            int screenYY = worldY - gp.Gplayer.worldY +gp.Gplayer.screenY;
            
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY && gp.gender == 0){
                
                g.drawImage(tile[tileNum].image, screenX, screenY, null);
            }  else if (worldX + gp.tileSize > gp.Gplayer.worldX - gp.Gplayer.screenX &&
                worldX - gp.tileSize < gp.Gplayer.worldX + gp.Gplayer.screenX &&
                worldY + gp.tileSize > gp.Gplayer.worldY - gp.Gplayer.screenY &&
                worldY - gp.tileSize < gp.Gplayer.worldY + gp.Gplayer.screenY && gp.gender == 1){
                g.drawImage(tile[tileNum].image, screenXX, screenYY, null);
            }
            worldCol++;           
            
                if(worldCol == gp.maxWorldCol){
                    worldCol=0;
                    worldRow++;
                }
        }
    }
}

