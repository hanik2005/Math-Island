package main;

import java.awt.Rectangle;

public class EventHandler {
    GamePanel gp;
    EventRect eventRect[][][];
    
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    public EventHandler (GamePanel gp){
        this.gp = gp;
        eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
        
        int map = 0;
        int col = 0;
        int row = 0;
        while(map < gp.maxMap && col<gp.maxWorldCol && row < gp.maxWorldRow){
            eventRect[map][col][row] = new EventRect();
            eventRect[map][col][row].x = 23;
            eventRect[map][col][row].y = 23;
            eventRect[map][col][row].width = 2;
            eventRect[map][col][row].height = 2;
            eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
            eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;

            col++;
            if(col == gp.maxWorldCol){
                col = 0;
                row++;

                if(row == gp.maxWorldRow){
                    row = 0;
                    map++;
                }
            }
        }
        
        
    }
    public void checkEvent(){
        
        int xDistance = Math.abs(gp.player.worldX - previousEventX);
        int yDistance = Math.abs(gp.player.worldY - previousEventY);
        int xxDistance = Math.abs(gp.Gplayer.worldX - previousEventX);
        int yyDistance = Math.abs(gp.Gplayer.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        int aDistance = Math.max(xxDistance, yyDistance);
        if(distance > gp.tileSize && gp.gender == 0){
            canTouchEvent = true;
        } else if (aDistance > gp.tileSize && gp.gender == 1){
             canTouchEvent = true;
        }
        
        if(canTouchEvent == true){
            if(hit(0,27, 39, "any")== true){
                teleport(1, 34, 39);
             } 
             else  if(hit(1,35, 39, "any")== true){
                teleport(0, 26, 38);
             }
            else  if(hit(0,26, 3, "any")== true){
                teleport(1, 34, 39);
             }
             else  if(hit(1,21, 10, "any")== true){
                teleport(2, 17, 38);
             }
              else  if(hit(2, 17, 39, "any")== true){
                teleport(1, 21, 11);
             }
            else  if(hit(2, 42, 7, "any")== true){
                teleport(1, 21, 11);
             }
            else if(hit(1, 20, 38, "any") && gp.player.hasOrb >= 2 || gp.Gplayer.hasOrb >=2){
                teleport(3, 26, 24);
            }
        }
    }
    public boolean hit(int map,int col, int row, String reqDirection){
    
        boolean hit = false;
        
        if(map == gp.currentMap){
            if(gp.gender == 0){
             gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
        eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
        
        if(gp.player.solidArea.intersects(eventRect [map][col][row]) && eventRect[map][col][row].eventDone == false){
            if(gp.player.direction.equals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
                
                previousEventX = gp.player.worldX;
                previousEventY = gp.player.worldY;
            }
        }
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
        eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
            } else if(gp.gender == 1){
                
                 gp.Gplayer.solidArea.x = gp.Gplayer.worldX + gp.Gplayer.solidArea.x;
        gp.Gplayer.solidArea.y = gp.Gplayer.worldY + gp.Gplayer.solidArea.y;
        eventRect[map][col][row].x = col*gp.tileSize + eventRect[map][col][row].x;
        eventRect[map][col][row].y = row*gp.tileSize + eventRect[map][col][row].y;
        
        if(gp.Gplayer.solidArea.intersects(eventRect [map][col][row]) && eventRect[map][col][row].eventDone == false){
            if(gp.Gplayer.direction.equals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
                
                previousEventX = gp.Gplayer.worldX;
                previousEventY = gp.Gplayer.worldY;
            }
        }
        gp.Gplayer.solidArea.x = gp.Gplayer.solidAreaDefaultX;
        gp.Gplayer.solidArea.y = gp.Gplayer.solidAreaDefaultY;
        eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
        eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
        
            }
        }
        
        return hit;
    }
    public void teleport(int map, int col, int row){
       // gp.gameState = gameState;
       //  gp.ui.currentDialogue = "teleport!";
      //  gp.player.worldX = gp.tileSize*37;
      //  gp.player.worldY = gp.tileSize*10;
      if(gp.gender == 0){
      gp.currentMap = map;
      gp.player.worldX = gp.tileSize * col;
      gp.player.worldY = gp.tileSize * row;
      previousEventX = gp.player.worldX;
      previousEventY = gp.player.worldY;
      canTouchEvent = false;
      }else if (gp.gender == 1){
         gp.currentMap = map;
      gp.Gplayer.worldX = gp.tileSize * col;
      gp.Gplayer.worldY = gp.tileSize * row;
      previousEventX = gp.Gplayer.worldX;
      previousEventY = gp.Gplayer.worldY;
      canTouchEvent = false; 
      }
    }
}

