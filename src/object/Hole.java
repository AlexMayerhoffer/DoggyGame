package object;

import com.Doggy.GamePanel;
import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Hole extends Entity {

    public Hole(GamePanel gp) {
        super(gp);
        getHoleImage();
    }

    public void getHoleImage(){
        try
        {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/enemies/hole.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(up1, x, y, gp.tileSize, gp.tileSize, null);
    }

}
