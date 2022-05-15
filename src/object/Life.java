package object;

import com.Doggy.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Life {
    GamePanel gp;
    public BufferedImage image1, image2;
    public String name;

    public Life(GamePanel gp){
        this.gp = gp;
        name = "Life";
        try{
            image1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/map/13.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/sprites/b.png")));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
