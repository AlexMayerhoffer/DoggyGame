package com.Doggy;

import entity.Player;
import object.Enemy;
import object.Hole;
import object.Object;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable
{
    final int originalTitleSize = 16;
    final int scale = 3;
    public final int tileSize = originalTitleSize * scale;

    public final int maxScreenCol = 18;
    public final int maxScreenRow = 16;
    public final int screenWidh = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;
    Thread gameThread;

    public TileManager tileM = new TileManager(this);
    Keys key = new Keys(this);

    public Collision cChecker = new Collision(this);
    public Player player = new Player(this, key);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public Object[] object = new Object[150];
    public Enemy[] enemy = new Enemy[20];
    public Hole[] hole = new Hole[10];

    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int gameOverState = 2;
    public final int level2State = 3;

    public final int level3State = 4;

    public int currentLevel;


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidh, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    public void setupGame(){
        aSetter.setObject();
        aSetter.setEnemy();

        gameState = titleState;
        currentLevel = 1;
    }

    public void retry(){
        player.setDefaultValues();
        player.restoreLife();
        aSetter.setObject();
        aSetter.setEnemy();
    }

    public void retry1(){
        player.setDefaultValues();
        player.restoreLife();
        aSetter.setObject();
        aSetter.setHole();
        aSetter.setEnemy1();
    }

    public void retry2(){
        player.setDefaultValues();
        player.restoreLife();
        aSetter.setObject();
        aSetter.setEnemy2();
        aSetter.setHole1();
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            delta = delta + (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update()
    {
        if(gameState == playState){
            player.update();
            for(int i = 0; i < enemy.length; i++) {
            if (enemy[i] != null)
                enemy[i].update();
            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(gameState == titleState){
            ui.draw(g2);
        }
        else{
            tileM.draw(g2);

            for(int i = 0; i < object.length; i++){
                if(object[i] !=null)
                    object[i].draw(g2, this);
            }
            for(int i = 0; i < hole.length; i++){
                if(hole[i] !=null)
                    hole[i].draw(g2, this);
            }
            for(int i = 0; i < enemy.length; i++){
                if(enemy[i] !=null)
                    enemy[i].draw(g2, this);
            }
            player.draw(g2);
            ui.draw(g2);
        }
        g2.dispose();
    }
}
