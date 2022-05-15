package entity;

import com.Doggy.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity
{
    GamePanel gp;
    public int x, y;
    public int speed;

    public BufferedImage up1, up2, d1, d2, l1, l2, r1, r2;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(8,16,32,32);
    public int solidAreaX, solidAreaY;
    public boolean collisionOn = false;
    public int life;
    public int actionLockCounter = 0;
    public boolean invincible = false;
    public int invincibleCounter = 0;

    public Entity(GamePanel gp){
        this.gp = gp;
    }

    public void setAction(){
    }

    public void update(){
        setAction();
        collisionOn = false;
        gp.cChecker.checkTile(this);
        boolean contactPlayer = gp.cChecker.checkPlayer(this);

        if(contactPlayer){
            if(!gp.player.invincible) {
                gp.player.life -= 1;
                gp.player.invincible = true;
            }
        }

        if(!collisionOn)
        {
            switch (direction) {
                case "up":
                    y = y - speed;
                    break;
                case "down":
                    y = y + speed;
                    break;
                case "left":
                    x = x - speed;
                    break;
                case "right":
                    x = x + speed;
                    break;
            }
        }

        spriteCounter++;
        if(spriteCounter > 15)
        {
            if(spriteNum == 1)
            {
                spriteNum = 2;
            }
            else if(spriteNum == 2)
            {
                spriteNum= 1;
            }
            spriteCounter = 0;
        }
    }
}
