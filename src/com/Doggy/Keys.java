package com.Doggy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener
{
    GamePanel gp;
    Keys(GamePanel gp){
        this.gp = gp;
    }
    public boolean WPressed, SPressed, APressed, DPressed;

    @Override
    public void keyTyped(KeyEvent e){
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        //title state
        if (gp.gameState == gp.titleState) {
            if (k == KeyEvent.VK_W) {
                gp.ui.command--;
                if (gp.ui.command < 0)
                    gp.ui.command = 1;
            }
            if (k == KeyEvent.VK_S) {
                gp.ui.command++;
                if (gp.ui.command > 1)
                    gp.ui.command = 0;
            }

            if (k == KeyEvent.VK_ENTER) {
                if (gp.ui.command == 0) {
                    gp.gameState = gp.playState;
                }
                if (gp.ui.command == 1) {
                    System.exit(0);
                }
            }

        }
        if (gp.gameState == gp.playState) {
            if (k == KeyEvent.VK_W)
                WPressed = true;
            if (k == KeyEvent.VK_S)
                SPressed = true;
            if (k == KeyEvent.VK_A)
                APressed = true;
            if (k == KeyEvent.VK_D)
                DPressed = true;
            if(k == KeyEvent.VK_ESCAPE)
                gp.gameState = gp.titleState;
        }

        if (gp.gameState == gp.gameOverState) {
            if (k == KeyEvent.VK_W) {
                gp.ui.command--;
                if (gp.ui.command < 0)
                    gp.ui.command = 1;
            }
            if (k == KeyEvent.VK_S) {
                gp.ui.command++;
                if (gp.ui.command > 1)
                    gp.ui.command = 0;
            }
            if (k == KeyEvent.VK_ENTER) {
                if (gp.ui.command == 0) {
                    gp.gameState = gp.playState;
                    gp.retry();
                }
                if (gp.ui.command == 1) {
                    gp.gameState = gp.titleState;
                }
            }
        }

        if (gp.gameState == gp.level2State) {
            if (k == KeyEvent.VK_W) {
                gp.ui.command--;
                if (gp.ui.command < 0)
                    gp.ui.command = 1;
            }
            if (k == KeyEvent.VK_S) {
                gp.ui.command++;
                if (gp.ui.command > 1)
                    gp.ui.command = 0;
            }
            if (k == KeyEvent.VK_ENTER) {
                if (gp.ui.command == 0) {
                    gp.gameState = gp.playState;
                    gp.retry1();
                }
                if (gp.ui.command == 1) {
                    gp.gameState = gp.titleState;
                }
            }
        }
        //System.out.println(gp.gameState);
        if(gp.gameState == gp.level3State){
            if (k == KeyEvent.VK_W) {
                gp.ui.command--;
                if (gp.ui.command < 0)
                    gp.ui.command = 1;
            }
            if (k == KeyEvent.VK_S) {
                gp.ui.command++;
                if (gp.ui.command > 1)
                    gp.ui.command = 0;
            }
            //System.out.println(gp.ui.command);
            if (k == KeyEvent.VK_ENTER) {
                if (gp.ui.command == 0) {
                    System.out.println("Schimbam in nivelul 3");
                    gp.gameState = gp.playState;
                    gp.retry2();
                }
                if (gp.ui.command == 1) {
                    gp.gameState = gp.titleState;
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int k = e.getKeyCode();
        if(k == KeyEvent.VK_W)
            WPressed = false;
        if(k == KeyEvent.VK_S)
            SPressed = false;
        if(k == KeyEvent.VK_A)
            APressed = false;
        if(k == KeyEvent.VK_D)
            DPressed = false;
    }
}
