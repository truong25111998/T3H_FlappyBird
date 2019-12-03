package gameflappybird;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ConChim {

    protected SoundManager soundShoot;
    private static int y = 200;
    private static int x = 100;
    private Image chim, image;

    public ConChim() {
        
    }

    public static int getY() {
        return y;
    }

    public static int getX() {
        return x;
    }

    public void paint(Graphics g) {
        String path = "/imgs/bird.png";
        chim = new ImageIcon(getClass().getResource(path)).getImage();
        g.drawImage(chim, x, y, null);

    }
    public void changeImage(){
        
    }

    public void tangY() {
        y++;
    }

    public void giamY() {
        y = y - 30;
    }
}
