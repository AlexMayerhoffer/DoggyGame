package object;

import com.Doggy.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Enemy extends Entity {
    public Enemy(GamePanel gp){
        super(gp);
        direction = "up";
        speed = 1;
        getEnemyImage();
    }

    public void getEnemyImage()
    {
        try
        {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/10.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/11.png")));
            r1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/1.png")));
            r2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/2.png")));
            d1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/19.png")));
            d2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/21.png")));
            l1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/34.png")));
            l2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/36.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setAction(){
        actionLockCounter++;
        if(actionLockCounter == 60){
            Random random = new Random();
            int i = random.nextInt(80) +1;
            if(i <= 20)
                direction = "up";
            if(i>20 && i <= 40)
                direction = "down";
            if(i>40 && i<=60)
                direction = "left";
            if(i>60)
                direction = "right";
            actionLockCounter = 0;
        }
    }
    public void draw(Graphics2D g2, GamePanel gp)
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
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
