/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import object.*;


public class AssetSetter {
    
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject (){
        int mapNum = 0;
          
        gp.obj[mapNum][0] = new OBJ_Stone(gp);
        gp.obj[mapNum][0].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 33 * gp.tileSize;

        gp.obj[mapNum][1] = new OBJ_Stone(gp);
        gp.obj[mapNum][1].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 33 * gp.tileSize;

        gp.obj[mapNum][2] = new OBJ_Stone(gp);
        gp.obj[mapNum][2].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 31 * gp.tileSize;

        gp.obj[mapNum][3] = new OBJ_Stone(gp);
        gp.obj[mapNum][3].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 31 * gp.tileSize;

        gp.obj[mapNum][4] = new OBJ_Stone(gp);
        gp.obj[mapNum][4].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][4].worldY = 29 * gp.tileSize;

        gp.obj[mapNum][5] = new OBJ_Stone(gp);
        gp.obj[mapNum][5].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 29 * gp.tileSize;

        gp.obj[mapNum][6] = new OBJ_Stone(gp);
        gp.obj[mapNum][6].worldX = 39 * gp.tileSize;
        gp.obj[mapNum][6].worldY = 29 * gp.tileSize;

        gp.obj[mapNum][7] = new OBJ_Stone(gp);
        gp.obj[mapNum][7].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][7].worldY = 29 * gp.tileSize;

        gp.obj[mapNum][8] = new OBJ_Stone(gp);
        gp.obj[mapNum][8].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][8].worldY = 26 * gp.tileSize;

        gp.obj[mapNum][9] = new OBJ_Stone(gp);
        gp.obj[mapNum][9].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][9].worldY = 29 * gp.tileSize;

        gp.obj[mapNum][10] = new OBJ_Stone(gp);
        gp.obj[mapNum][10].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][10].worldY = 27 * gp.tileSize;

        gp.obj[mapNum][11] = new OBJ_Stone(gp);
        gp.obj[mapNum][11].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][11].worldY = 26 * gp.tileSize;

        gp.obj[mapNum][12] = new OBJ_Stone(gp);
        gp.obj[mapNum][12].worldX = 27 * gp.tileSize;
        gp.obj[mapNum][12].worldY = 24 * gp.tileSize;

        gp.obj[mapNum][13] = new OBJ_Stone(gp);
        gp.obj[mapNum][13].worldX = 12 * gp.tileSize;
        gp.obj[mapNum][13].worldY = 23 * gp.tileSize;

        gp.obj[mapNum][14] = new OBJ_Stone(gp);
        gp.obj[mapNum][14].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][14].worldY = 26 * gp.tileSize;

        gp.obj[mapNum][15] = new OBJ_Stone(gp);
        gp.obj[mapNum][15].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][15].worldY = 23 * gp.tileSize;

        gp.obj[mapNum][16] = new OBJ_Stone(gp);
        gp.obj[mapNum][16].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][16].worldY = 17 * gp.tileSize;

        gp.obj[mapNum][17] = new OBJ_Stone(gp);
        gp.obj[mapNum][17].worldX = 12 * gp.tileSize;
        gp.obj[mapNum][17].worldY = 13 * gp.tileSize;

        gp.obj[mapNum][18] = new OBJ_Stone(gp);
        gp.obj[mapNum][18].worldX = 25 * gp.tileSize;
        gp.obj[mapNum][18].worldY = 10 * gp.tileSize;

        gp.obj[mapNum][19] = new OBJ_Stone(gp);
        gp.obj[mapNum][19].worldX = 39 * gp.tileSize;
        gp.obj[mapNum][19].worldY = 11 * gp.tileSize;

        gp.obj[mapNum][20] = new OBJ_Stone(gp);
        gp.obj[mapNum][20].worldX = 39 * gp.tileSize;
        gp.obj[mapNum][20].worldY = 13 * gp.tileSize;

        gp.obj[mapNum][21] = new OBJ_Stone(gp);
        gp.obj[mapNum][21].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][21].worldY = 15 * gp.tileSize;

        gp.obj[mapNum][22] = new OBJ_Stone(gp);
        gp.obj[mapNum][22].worldX = 34 * gp.tileSize;
        gp.obj[mapNum][22].worldY = 16 * gp.tileSize;

        gp.obj[mapNum][23] = new OBJ_Stone(gp);
        gp.obj[mapNum][23].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][23].worldY = 12 * gp.tileSize;

        gp.obj[mapNum][24] = new OBJ_Stone(gp);
        gp.obj[mapNum][24].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][24].worldY = 13 * gp.tileSize;

        gp.obj[mapNum][25] = new OBJ_Stone(gp);
        gp.obj[mapNum][25].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][25].worldY = 15 * gp.tileSize;

        gp.obj[mapNum][26] = new OBJ_Stone(gp);
        gp.obj[mapNum][26].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][26].worldY = 18 * gp.tileSize;

        gp.obj[mapNum][27] = new OBJ_Stone(gp);
        gp.obj[mapNum][27].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][27].worldY = 20 * gp.tileSize;

        gp.obj[mapNum][28] = new OBJ_Stone(gp);
        gp.obj[mapNum][28].worldX = 34 * gp.tileSize;
        gp.obj[mapNum][28].worldY = 23 * gp.tileSize;

        gp.obj[mapNum][29] = new OBJ_Stone(gp);
        gp.obj[mapNum][29].worldX = 14 * gp.tileSize;
        gp.obj[mapNum][29].worldY = 33 * gp.tileSize;

        gp.obj[mapNum][30] = new OBJ_Stone(gp);
        gp.obj[mapNum][30].worldX = 22 * gp.tileSize;
        gp.obj[mapNum][30].worldY = 30 * gp.tileSize;

        gp.obj[mapNum][31] = new OBJ_Stone(gp);
        gp.obj[mapNum][31].worldX = 22 * gp.tileSize;
        gp.obj[mapNum][31].worldY = 18 * gp.tileSize;

        gp.obj[mapNum][32] = new OBJ_Stone(gp);
        gp.obj[mapNum][32].worldX = 39 * gp.tileSize;
        gp.obj[mapNum][32].worldY = 26 * gp.tileSize;

        gp.obj[mapNum][33] = new OBJ_Stone(gp);
        gp.obj[mapNum][33].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][33].worldY = 22 * gp.tileSize;

        gp.obj[mapNum][34] = new OBJ_Stone(gp);
        gp.obj[mapNum][34].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][34].worldY =  9 * gp.tileSize;

        gp.obj[mapNum][35] = new OBJ_Stone(gp);
        gp.obj[mapNum][35].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][35].worldY = 13 * gp.tileSize;

        gp.obj[mapNum][36] = new OBJ_Stone(gp);
        gp.obj[mapNum][36].worldX = 12 * gp.tileSize;
        gp.obj[mapNum][36].worldY =  9 * gp.tileSize;

        gp.obj[mapNum][37] = new OBJ_Stone(gp);
        gp.obj[mapNum][37].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][37].worldY =  26 * gp.tileSize;

        gp.obj[mapNum][38] = new OBJ_Stone(gp);
        gp.obj[mapNum][38].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][38].worldY = 28 * gp.tileSize;

        gp.obj[mapNum][39] = new OBJ_Stone(gp);
        gp.obj[mapNum][39].worldX = 21 * gp.tileSize;
        gp.obj[mapNum][39].worldY =  25 * gp.tileSize;

        gp.obj[mapNum][40] = new OBJ_Stone(gp);
        gp.obj[mapNum][40].worldX = 14 * gp.tileSize;
        gp.obj[mapNum][40].worldY =  24 * gp.tileSize;

        gp.obj[mapNum][41] = new OBJ_Orb(gp);
        gp.obj[mapNum][41].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][41].worldY = 4 * gp.tileSize;
        
        gp.obj[mapNum][42] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][42].worldX = 28 * gp.tileSize;
        gp.obj[mapNum][42].worldY = 3 * gp.tileSize;
        
        gp.obj[mapNum][43] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][43].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][43].worldY = 12 * gp.tileSize;
        
        gp.obj[mapNum][44] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][44].worldX = 18 * gp.tileSize;
        gp.obj[mapNum][44].worldY = 16 * gp.tileSize;
        
        gp.obj[mapNum][45] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][45].worldX = 16 * gp.tileSize;
        gp.obj[mapNum][45].worldY = 17 * gp.tileSize;
        
        gp.obj[mapNum][46] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][46].worldX = 33 * gp.tileSize;
        gp.obj[mapNum][46].worldY = 11 * gp.tileSize;
        
        gp.obj[mapNum][47] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][47].worldX = 33 * gp.tileSize;
        gp.obj[mapNum][47].worldY = 11 * gp.tileSize;
        
        gp.obj[mapNum][48] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][48].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][48].worldY = 24 * gp.tileSize;
        
        gp.obj[mapNum][49] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][49].worldX = 40 * gp.tileSize;
        gp.obj[mapNum][49 ].worldY = 29 * gp.tileSize;
        
        gp.obj[mapNum][50] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][50].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][50].worldY = 32 * gp.tileSize;
        
        gp.obj[mapNum][51] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][51].worldX = 38 * gp.tileSize;
        gp.obj[mapNum][51].worldY = 31 * gp.tileSize;
        
        gp.obj[mapNum][52] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][52].worldX = 21 * gp.tileSize;
        gp.obj[mapNum][52].worldY = 20 * gp.tileSize;
        
        gp.obj[mapNum][53] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][53].worldX = 13 * gp.tileSize;
        gp.obj[mapNum][53].worldY = 15 * gp.tileSize;
        
        gp.obj[mapNum][54] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][54].worldX = 11 * gp.tileSize;
        gp.obj[mapNum][54].worldY = 13 * gp.tileSize;
        
        gp.obj[mapNum][55] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][55].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][55].worldY = 26 * gp.tileSize;
        
        gp.obj[mapNum][56] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][56].worldX = 31 * gp.tileSize;
        gp.obj[mapNum][56].worldY = 22 * gp.tileSize;
      
        
        mapNum = 1;
        
        gp.obj[mapNum][0] = new OBJ_FinalPortal(gp);
        gp.obj[mapNum][0].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 38 * gp.tileSize;
        
        gp.obj[mapNum][1] = new OBJ_Stone(gp);
        gp.obj[mapNum][1].worldX = 31 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 39 * gp.tileSize;
        
        gp.obj[mapNum][2] = new OBJ_Stone(gp);
        gp.obj[mapNum][2].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 35 * gp.tileSize;
        
        gp.obj[mapNum][3] = new OBJ_Stone(gp);
        gp.obj[mapNum][3].worldX = 24 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 13 * gp.tileSize;
        
        gp.obj[mapNum][4] = new OBJ_Stone(gp);
        gp.obj[mapNum][4].worldX = 14 * gp.tileSize;
        gp.obj[mapNum][4].worldY = 11 * gp.tileSize;
        
        gp.obj[mapNum][5] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][5].worldX = 23 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 11 * gp.tileSize;
        
        gp.obj[mapNum][6] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][6].worldX = 35 * gp.tileSize;
        gp.obj[mapNum][6].worldY = 38 * gp.tileSize;
        
        mapNum = 2;
        
        gp.obj[mapNum][0] = new OBJ_Orb(gp);
        gp.obj[mapNum][0].worldX = 42 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 8 * gp.tileSize;
        
        gp.obj[mapNum][1] = new OBJ_Stone(gp);
        gp.obj[mapNum][1].worldX = 31 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 34 * gp.tileSize;

        gp.obj[mapNum][2] = new OBJ_Stone(gp);
        gp.obj[mapNum][2].worldX = 17 * gp.tileSize;
        gp.obj[mapNum][2].worldY = 31 * gp.tileSize;

        gp.obj[mapNum][3] = new OBJ_Stone(gp);
        gp.obj[mapNum][3].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][3].worldY = 33 * gp.tileSize;

        gp.obj[mapNum][4] = new OBJ_Stone(gp);
        gp.obj[mapNum][4].worldX = 15 * gp.tileSize;
        gp.obj[mapNum][4].worldY = 29 * gp.tileSize;

        gp.obj[mapNum][5] = new OBJ_Stone(gp);
        gp.obj[mapNum][5].worldX = 20 * gp.tileSize;
        gp.obj[mapNum][5].worldY = 24 * gp.tileSize;

        gp.obj[mapNum][6] = new OBJ_Stone(gp);
        gp.obj[mapNum][6].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][6].worldY = 20 * gp.tileSize;

        gp.obj[mapNum][7] = new OBJ_Stone(gp);
        gp.obj[mapNum][7].worldX = 35 * gp.tileSize;
        gp.obj[mapNum][7].worldY = 22 * gp.tileSize;

        gp.obj[mapNum][8] = new OBJ_Stone(gp);
        gp.obj[mapNum][8].worldX = 34 * gp.tileSize;
        gp.obj[mapNum][8].worldY = 16 * gp.tileSize;

        gp.obj[mapNum][9] = new OBJ_Stone(gp);
        gp.obj[mapNum][9].worldX = 26 * gp.tileSize;
        gp.obj[mapNum][9].worldY = 16 * gp.tileSize;

        gp.obj[mapNum][8] = new OBJ_Stone(gp);
        gp.obj[mapNum][8].worldX = 21 * gp.tileSize;
        gp.obj[mapNum][8].worldY = 13 * gp.tileSize;

        gp.obj[mapNum][8] = new OBJ_Stone(gp);
        gp.obj[mapNum][8].worldX = 26 * gp.tileSize;
        gp.obj[mapNum][8].worldY = 7 * gp.tileSize;

        gp.obj[mapNum][9] = new OBJ_Stone(gp);
        gp.obj[mapNum][9].worldX = 35 * gp.tileSize;
        gp.obj[mapNum][9].worldY = 7 * gp.tileSize;
        
        gp.obj[mapNum][10] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][10].worldX = 31 * gp.tileSize;
        gp.obj[mapNum][10].worldY = 38 * gp.tileSize;
        
        gp.obj[mapNum][11] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][11].worldX = 14 * gp.tileSize;
        gp.obj[mapNum][11].worldY = 25 * gp.tileSize;
        
        gp.obj[mapNum][12] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][12].worldX = 30 * gp.tileSize;
        gp.obj[mapNum][12].worldY = 24 * gp.tileSize;
        
        gp.obj[mapNum][13] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][13].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][13].worldY = 16 * gp.tileSize;
        
        gp.obj[mapNum][14] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][14].worldX = 21 * gp.tileSize;
        gp.obj[mapNum][14].worldY = 16 * gp.tileSize;
        
        gp.obj[mapNum][15] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][15].worldX = 21 * gp.tileSize;
        gp.obj[mapNum][15].worldY = 8 * gp.tileSize;
        
        gp.obj[mapNum][16] = new OBJ_DisplayManaCrystal(gp);
        gp.obj[mapNum][16].worldX = 41 * gp.tileSize;
        gp.obj[mapNum][16].worldY = 8 * gp.tileSize;
        
        
        
         mapNum = 3;
         
        gp.obj[mapNum][0] = new OBJ_enemy(gp);
        gp.obj[mapNum][0].worldX = 26 * gp.tileSize;
        gp.obj[mapNum][0].worldY = 15 * gp.tileSize;
        
        gp.obj[mapNum][1] = new OBJ_LastPortal(gp);
        gp.obj[mapNum][1].worldX = 26 * gp.tileSize;
        gp.obj[mapNum][1].worldY = 6 * gp.tileSize;
    }  
}
