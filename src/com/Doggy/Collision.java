package com.Doggy;

import entity.Entity;
import entity.Player;
import object.Enemy;
import object.Hole;

public class Collision {
    GamePanel gp;

    public Collision(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.x;
        int entityRightWorldX = entity.x + gp.tileSize;
        int entityTopWorldY = entity.y;
        int entityBottomWoldY = entity.y + gp.tileSize;

//        System.out.println("EntityLeftWorldX: " + entityLeftWorldX);
//        System.out.println("EntityRightWorldX: " + entityRightWorldX);
//        System.out.println("EntityTopWorldY: " + entityTopWorldY);
//        System.out.println("EntityBottomWoldY: " + entityBottomWoldY);

        if(entity.getClass().toString().equals("class entity.Player")) {
            System.out.println("X: " + entity.x);
//            System.out.println("Y: " + entity.y);
//            System.out.println(entity.speed);
        }

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWoldY / gp.tileSize;

        int tileNum1, tileNum2;



        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.map[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.map[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWoldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.map[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.map[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.map[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.map[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.map[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.map[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;

        }

    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.object.length; i++)
            if (gp.object[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                gp.object[i].solidArea.x = gp.object[i].worldX + gp.object[i].solidArea.x;
                gp.object[i].solidArea.y = gp.object[i].worldY + gp.object[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                }
                if (entity.solidArea.intersects(gp.object[i].solidArea)) {
                    if (gp.object[i].collision)
                        entity.collisionOn = true;
                    if (player) {
                        index = i;
                    }
                }
                entity.solidArea.x = entity.solidAreaX;
                entity.solidArea.y = entity.solidAreaY;
                gp.object[i].solidArea.x = gp.object[i].solidAreaX;
                gp.object[i].solidArea.y = gp.object[i].solidAreaY;
            }

        return index;
    }

    public int checkHole(Entity entity, Hole[] hole) {
        int index = 999;
        for (int i = 0; i < hole.length; i++)
            if (hole[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                hole[i].solidArea.x = hole[i].x + hole[i].solidArea.x;
                hole[i].solidArea.y = hole[i].y + hole[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                }
                if (entity.solidArea.intersects(hole[i].solidArea)) {
                    entity.collisionOn = true;
                    index = i;
                }
                entity.solidArea.x = entity.solidAreaX;
                entity.solidArea.y = entity.solidAreaY;
                hole[i].solidArea.x = hole[i].solidAreaX;
                hole[i].solidArea.y = hole[i].solidAreaY;
            }

        return index;
    }

    public int checkEnemy(Entity entity, Enemy[] enemy) {
        int index = 999;
        for (int i = 0; i < enemy.length; i++)
            if (enemy[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                enemy[i].solidArea.x = enemy[i].x + enemy[i].solidArea.x;
                enemy[i].solidArea.y = enemy[i].y + enemy[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                }
                if (entity.solidArea.intersects(enemy[i].solidArea)) {
                    entity.collisionOn = true;
                    index = i;
                }
                entity.solidArea.x = entity.solidAreaX;
                entity.solidArea.y = entity.solidAreaY;
                enemy[i].solidArea.x = enemy[i].solidAreaX;
                enemy[i].solidArea.y = enemy[i].solidAreaY;
            }

        return index;
    }

    public boolean checkPlayer(Entity entity) {

        boolean contactPlayer = false;
        entity.solidArea.x = entity.x + entity.solidArea.x;
        entity.solidArea.y = entity.y + entity.solidArea.y;

        gp.player.solidArea.x = gp.player.x + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.y + gp.player.solidArea.y;

        switch (entity.direction) {
            case "up":
                entity.solidArea.y -= entity.speed;
                break;
            case "down":
                entity.solidArea.y += entity.speed;
                break;
            case "left":
                entity.solidArea.x -= entity.speed;
                break;
            case "right":
                entity.solidArea.x += entity.speed;
                break;
        }
        if (entity.solidArea.intersects(gp.player.solidArea)) {
            entity.collisionOn = true;
            contactPlayer = true;
        }
        entity.solidArea.x = entity.solidAreaX;
        entity.solidArea.y = entity.solidAreaY;
        gp.player.solidArea.x = gp.player.solidAreaX;
        gp.player.solidArea.y = gp.player.solidAreaY;

        return contactPlayer;
    }
}

