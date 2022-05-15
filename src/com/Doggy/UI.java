package com.Doggy;

import object.Life;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class UI {
    GamePanel gp;
    Font font;
    BufferedImage life_full, life_blank;
    public int command = 0;
    BufferedImage image;

    public UI(GamePanel gp){
        this.gp = gp;

        font = new Font("Arial", Font.BOLD, 20);

        Life life = new Life(gp);
        life_full = life.image1;
        life_blank = life.image2;
    }

    public void draw(Graphics2D g2){
        if(gp.gameState == gp.titleState){
            drawTitleScreen(g2);
        }
        else {
            g2.setFont(font);
            g2.setColor(Color.white);
            g2.drawString("Score : " + gp.player.os, 8*gp.tileSize, 30);

            drawPlayerLife(g2);
        }
        if(gp.gameState == gp.gameOverState){
            drawGameOverScreen(g2);
        }

        if(gp.gameState == gp.level2State){
            drawLevel2State(g2);
        }

        if(gp.gameState == gp.level3State){
            drawLevel3State(g2);
        }
    }

    public void drawTitleScreen(Graphics2D g2){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/paw.jpg")));
        } catch (IOException e){
            e.printStackTrace();
        }
        g2.drawImage(image, 0,0, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60f));
        String text = "DOGGY needs to eat";
        int x = getXforCenteredText(text, g2);
        int y = 4 * gp.tileSize;

        g2.setColor(Color.black);
        g2.drawString(text,x,y);

        //menu
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40f));
        text = "New Game";
        x = getXforCenteredText(text, g2);
        y += 3 * gp.tileSize;
        g2.drawString(text,x,y);
        if(command == 0){
            g2.drawString(">", x-gp.tileSize,y);
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 40f));
        text = "Exit Game";
        x = getXforCenteredText(text, g2);
        y += 1.3 * gp.tileSize;
        g2.drawString(text,x,y);
        if(command == 1){
            g2.drawString(">", x-gp.tileSize,y);
        }

    }

    public void drawGameOverScreen(Graphics2D g2){
        g2.setColor(new Color(0,0,0,150));
        g2.fillRect(0,0,gp.screenWidh,gp.screenHeight);

        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 80f));

        text = "Game Over";
        x = getXforCenteredText(text, g2);
        y = gp.tileSize * 6;

        g2.setColor(Color.white);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30f));
        text = "Retry";
        x = getXforCenteredText(text, g2);
        y += 1.8 * gp.tileSize;
        g2.drawString(text,x,y);
        if(command == 0){
            g2.drawString(">", x-gp.tileSize,y);
        }


        text = "Quit";
        x = getXforCenteredText(text, g2);
        y += 0.8 * gp.tileSize;
        g2.drawString(text,x,y);
        if(command == 1){
            g2.drawString(">", x-gp.tileSize,y);
        }

    }

    public void drawLevel2State(Graphics2D g2){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/paw.jpg")));
        } catch (IOException e){
            e.printStackTrace();
        }
        g2.drawImage(image, 0,0, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
        String text = "Go to next level";
        int x = getXforCenteredText(text, g2);
        int y = (int)5.5 * gp.tileSize;

        g2.setColor(Color.black);
        g2.drawString(text,x,y);
        if(command == 0){
            g2.drawString(">", x-gp.tileSize,y);
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
        text = "Exit to menu";
        x = getXforCenteredText(text, g2);
        y += 1.3 * gp.tileSize;
        g2.drawString(text,x,y);
        if(command == 1){
            g2.drawString(">", x-gp.tileSize,y);
        }

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/1.png")));
        } catch (IOException e){
            e.printStackTrace();
        }

        g2.drawImage(image, 330,330, 2 *gp.tileSize, 2*gp.tileSize ,null);

    }
    public void drawLevel3State(Graphics2D g2){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/paw.jpg")));
        } catch (IOException e){
            e.printStackTrace();
        }
        g2.drawImage(image, 0,0, null);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
        String text = "Go to next level";
        int x = getXforCenteredText(text, g2);
        int y = (int)5.5 * gp.tileSize;

        g2.setColor(Color.black);
        g2.drawString(text,x,y);
        if(command == 0){
            g2.drawString(">", x-gp.tileSize,y);
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
        text = "Exit to menu";
        x = getXforCenteredText(text, g2);
        y += 1.3 * gp.tileSize;
        g2.drawString(text,x,y);
        if(command == 1){
            g2.drawString(">", x-gp.tileSize,y);
        }

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/1.png")));
        } catch (IOException e){
            e.printStackTrace();
        }

        g2.drawImage(image, 330,330, 2 *gp.tileSize, 2*gp.tileSize ,null);

    }
    public int getXforCenteredText(String text, Graphics2D g2){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidh/2 - length/2;
        return x;
    }
    public void drawPlayerLife(Graphics2D g2){

        int x = 7 * gp.tileSize + (gp.tileSize)/2;
        int y = 18 * gp.tileSize + 8;
        int i = 0;
        while (i<gp.player.life){
            g2.drawImage(life_blank,x,y,gp.tileSize,gp.tileSize-8, null);
            i++;
            x += gp.tileSize;
        }

        x = 7 * gp.tileSize + (gp.tileSize)/2;
        y = 18 * gp.tileSize + 8;
        i = 0;

        while(i < gp.player.life){
            g2.drawImage(life_full,x,y,gp.tileSize,gp.tileSize-8, null);
            i++;
            x += gp.tileSize;
        }
    }
}
