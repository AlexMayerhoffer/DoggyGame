package entity;

import com.Doggy.GamePanel;
import com.Doggy.Keys;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends  Entity
{
    GamePanel gp;
    Keys key;
    public int os = 0, os1 = 0;

    public Player(GamePanel gp, Keys key)
    {
        super(gp);
        this.gp = gp;
        this.key = key;

        solidArea = new Rectangle(8,16,32,32);
        solidAreaX = 8;
        solidAreaY = 16;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        x = gp.tileSize + gp.tileSize/2;
        y = 7 * gp.tileSize + gp.tileSize/2;
        speed = 4;
        direction = "right";
        life = 3;
    }

    public void restoreLife(){
        invincible = false;
        os = 0;
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/4.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/5.png")));
            r1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/1.png")));
            r2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/3.png")));
            d1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/7.png")));
            d2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/9.png")));
            l1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/10.png")));
            l2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/12.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update()
    {
        if (key.WPressed){
            direction = "up";
            // y = y - speed;
        }
        else if (key.SPressed){
            direction = "down";
           // y = y + speed;
        }
        else if (key.APressed){
            direction = "left";
            //x = x - speed;
        }
        else if (key.DPressed){
            direction = "right";
           // x = x + speed;
        }

        collisionOn = false;
        gp.cChecker.checkTile(this);
        int objectIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objectIndex);

        int enemyIndex = gp.cChecker.checkEnemy(this, gp.enemy);
        contactEnemy(enemyIndex);

        int holeIndex = gp.cChecker.checkHole(this, gp.hole);
        contactHole(holeIndex);

        if(collisionOn)
            System.out.println("Collision detected!");
        if(!collisionOn)
        {
            switch (direction)
            {
                case "up":
                    if (key.WPressed)
                        y = y - speed;
                    break;
                case "down":
                    if (key.SPressed)
                        y = y + speed;
                    break;
                case "left":
                    if (key.APressed)
                        x = x - speed;
                    break;
                case "right":
                    if (key.DPressed)
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

        if(invincible){
            invincibleCounter++;
            if(invincibleCounter > 120){
                invincible = false;
                invincibleCounter = 0;
            }
        }

        if(life <= 0){
            gp.gameState = gp.gameOverState;
        }

        if(os == 1 && gp.currentLevel == 1){ //128
            System.out.println("Schimb gamestate in level2State");
            gp.currentLevel = 2;
            gp.gameState = gp.level2State;
        }

        if(os == 2){//254
            System.out.println("Schimb gamestate in level3State");
            gp.currentLevel = 3;
            gp.gameState = gp.level3State;
        }

        //TODO
    }
    public void pickUpObject(int i){
        if(i != 999){
            os++;
            os1++;
          //  System.out.println(os1);
            gp.object[i] = null;
        }
    }

    public void contactEnemy(int i){
        if(i != 999){
            if(!invincible) {
                life = life - 1;
                invincible = true;
            }
        }
    }

    public void contactHole(int i){
        if(i != 999){
            if(!invincible) {
                life = life - 1;
                invincible = true;
            }
        }
    }
    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;
        switch (direction)
        {
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1)
                {
                    image = d1;
                }
                if(spriteNum == 2)
                {
                    image = d2;
                }
                break;
            case "left":
                if(spriteNum == 1)
                {
                    image = l1;
                }
                if(spriteNum == 2)
                {
                    image = l2;
                }
                break;
            case "right":
                if(spriteNum == 1)
                {
                    image = r1;
                }
                if(spriteNum == 2)
                {
                    image = r2;
                }
                break;

        }
        if(invincible){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize);
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }

}
