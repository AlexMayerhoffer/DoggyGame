package object;

import com.Doggy.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Object {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(8,16,32,32);
    public int solidAreaX = 0;
    public int solidAreaY = 0;

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, worldX, worldY, gp.tileSize, gp.tileSize, null);
    }
    public Object(){
        name = "Key";
        try{
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/map/os.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
