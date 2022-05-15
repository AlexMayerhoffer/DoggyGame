package com.Doggy;
import object.Enemy;
import object.Hole;
import object.Object;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }

    public void setObject() {
        for (int i = 0; i < 4; i++) {
            gp.object[i] = new Object();
            gp.object[i].worldX = gp.tileSize;
            gp.object[i].worldY = (i + 2) * gp.tileSize;
        }
    }
    /*
    public void setObject(){

        for(int i = 0; i < 4; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX =  gp.tileSize;
            gp.object[i].worldY = (i+2) * gp.tileSize;
        }

        for(int i = 4; i < 7; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = gp.tileSize;
            gp.object[i].worldY = (i+7) * gp.tileSize;
        }

        for(int i = 7; i < 11; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 2 * gp.tileSize;
            gp.object[i].worldY = (i-5) * gp.tileSize;
        }

        for(int i = 11; i < 14; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 2 * gp.tileSize;
            gp.object[i].worldY = i * gp.tileSize;
        }

        for(int i = 14; i< 24; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 3 * gp.tileSize;
            gp.object[i].worldY = (i-11) * gp.tileSize;
        }

        for(int i = 24; i< 36; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 4 * gp.tileSize;
            gp.object[i].worldY = (i-22) * gp.tileSize;
        }

        for(int i = 36; i< 48; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 5 * gp.tileSize;
            gp.object[i].worldY = (i-34) * gp.tileSize;
        }

        for(int i = 48; i < 53; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 6 * gp.tileSize;
            gp.object[i].worldY = (i-46) * gp.tileSize;
        }

        for(int i = 53; i < 58; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 6 * gp.tileSize;
            gp.object[i].worldY = (i-44) * gp.tileSize;
        }

        for(int i = 58; i < 61; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 7 * gp.tileSize;
            gp.object[i].worldY = (i-54) * gp.tileSize;
        }

        for(int i = 61; i < 64; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 7 * gp.tileSize;
            gp.object[i].worldY = (i-52) * gp.tileSize;
        }

        for(int i = 64; i < 67; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 8 * gp.tileSize;
            gp.object[i].worldY = (i-60) * gp.tileSize;
        }

        for(int i = 67; i < 70; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 8 * gp.tileSize;
            gp.object[i].worldY = (i-58) * gp.tileSize;
        }

        for(int i = 70; i < 75; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 9 * gp.tileSize;
            gp.object[i].worldY = (i-68) * gp.tileSize;
        }

        for(int i = 75; i < 80; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 9 * gp.tileSize;
            gp.object[i].worldY = (i-66) * gp.tileSize;
        }

        for(int i = 80; i < 92; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 10 * gp.tileSize;
            gp.object[i].worldY = (i-78) * gp.tileSize;
        }

        for(int i = 92; i < 104; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 11 * gp.tileSize;
            gp.object[i].worldY = (i-90) * gp.tileSize;
        }

        for(int i = 104; i < 114; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 12 * gp.tileSize;
            gp.object[i].worldY = (i-101) * gp.tileSize;
        }

        for(int i = 114; i < 118; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 13 * gp.tileSize;
            gp.object[i].worldY = (i-112) * gp.tileSize;
        }

        for(int i = 118; i < 121; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 13 * gp.tileSize;
            gp.object[i].worldY = (i-107) * gp.tileSize;
        }

        for(int i = 121; i < 125; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 14 * gp.tileSize;
            gp.object[i].worldY = (i-119) * gp.tileSize;
        }

        for(int i = 125; i < 128; i++){
            gp.object[i] = new Object();
            gp.object[i].worldX = 14 * gp.tileSize;
            gp.object[i].worldY = (i-114) * gp.tileSize;
        }
    }
*/ //TODO
    public void setEnemy(){
        gp.enemy[0] = new Enemy(gp);
        gp.enemy[0].x = 4 * gp.tileSize;
        gp.enemy[0].y = 4 * gp.tileSize;

        gp.enemy[1] = new Enemy(gp);
        gp.enemy[1].x = 11 * gp.tileSize;
        gp.enemy[1].y = 11 * gp.tileSize;
    }

    public void setEnemy1() {
        gp.enemy[0] = new Enemy(gp);
        gp.enemy[0].x = gp.tileSize;
        gp.enemy[0].y = 4 * gp.tileSize;

        gp.enemy[1] = new Enemy(gp);
        gp.enemy[1].x = 4 * gp.tileSize;
        gp.enemy[1].y = 11 * gp.tileSize;

        gp.enemy[2] = new Enemy(gp);
        gp.enemy[2].x = 11 * gp.tileSize;
        gp.enemy[2].y = 8 * gp.tileSize;

        gp.enemy[3] = new Enemy(gp);
        gp.enemy[3].x = 14 * gp.tileSize;
        gp.enemy[3].y = 4 * gp.tileSize;
    }

    public void setEnemy2() {
        gp.enemy[0] = new Enemy(gp);
        gp.enemy[0].x = gp.tileSize;
        gp.enemy[0].y = 4 * gp.tileSize;

        gp.enemy[1] = new Enemy(gp);
        gp.enemy[1].x = 4 * gp.tileSize;
        gp.enemy[1].y = 11 * gp.tileSize;

        gp.enemy[2] = new Enemy(gp);
        gp.enemy[2].x = 11 * gp.tileSize;
        gp.enemy[2].y = 8 * gp.tileSize;

        gp.enemy[3] = new Enemy(gp);
        gp.enemy[3].x = 14 * gp.tileSize;
        gp.enemy[3].y = 4 * gp.tileSize;

        gp.enemy[4] = new Enemy(gp);
        gp.enemy[4].x = 11 * gp.tileSize;
        gp.enemy[4].y = 9 * gp.tileSize;

        gp.enemy[5] = new Enemy(gp);
        gp.enemy[5].x = 14 * gp.tileSize;
        gp.enemy[5].y = 6 * gp.tileSize;
    }

    public void setHole(){
        gp.hole[0] = new Hole(gp);
        gp.hole[0].x = 4 * gp.tileSize;
        gp.hole[0].y = 4 * gp.tileSize;

        gp.hole[1] = new Hole(gp);
        gp.hole[1].x = 11 * gp.tileSize;
        gp.hole[1].y = 11 * gp.tileSize;
    }

    public void setHole1(){
        gp.hole[0] = new Hole(gp);
        gp.hole[0].x = 4 * gp.tileSize;
        gp.hole[0].y = 4 * gp.tileSize;

        gp.hole[1] = new Hole(gp);
        gp.hole[1].x = 11 * gp.tileSize;
        gp.hole[1].y = 11 * gp.tileSize;

        gp.hole[2] = new Hole(gp);
        gp.hole[2].x = 11 * gp.tileSize;
        gp.hole[2].y = 4 * gp.tileSize;

        gp.hole[3] = new Hole(gp);
        gp.hole[3].x = 4 * gp.tileSize;
        gp.hole[3].y = 11 * gp.tileSize;
    }
}
