package gameflappybird;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class OngNuoc extends JPanel implements Constants {

    protected static int x1 = W_F;
    protected static int x2 = x1 + 2 * DISTANCE;
    protected static int x3 = x2 + 2 * DISTANCE;
    protected static int h1, h2, h3;
    protected static boolean bl1 = false;
    protected static boolean bl2 = false;
    protected static boolean bl3 = false;
    protected Image ong1, ong2;

    public OngNuoc() {

    }

    public static int getX1() {
        return x1;
    }

    public static int getX2() {
        return x2;
    }

    public static int getX3() {
        return x3;
    }

    public static int getH1() {
        return h1;
    }

    public static int getH2() {
        return h2;
    }

    public static int getH3() {
        return h3;
    }

    public void ngaunhienheight() {
        Random rd = new Random();
        if (bl1 == false) {
            h1 = rd.nextInt(200);
            bl1 = true;
        }
        if (bl2 == false) {
            h2 = rd.nextInt(200);
            bl2 = true;
        }
        if (bl3 == false) {
            h3 = rd.nextInt(200);
            bl3 = true;
        }
    }

    @Override
    public void paint(Graphics g) {

        ngaunhienheight();
        String path = "/imgs/down.png";
        String path1 = "/imgs/up.png";
        //ongtren = ImageIO.read(new File("C:\\Users\\Admin\\Pictures\\img\\down.png"));
        ong1 = new ImageIcon(getClass().getResource(path)).getImage();
        ong2 = new ImageIcon(getClass().getResource(path1)).getImage();

        g.drawImage(ong1, x1, 0, WIDTH_ONGNUOC, h1, null);
        g.drawImage(ong2, x1, h1 + DISTANCE, WIDTH_ONGNUOC, H_F, null);
        g.drawImage(ong1, x2, 0, WIDTH_ONGNUOC, h2, null);
        g.drawImage(ong2, x2, h2 + DISTANCE, WIDTH_ONGNUOC, H_F, null);
        g.drawImage(ong1, x3, 0, WIDTH_ONGNUOC, h3, null);
        g.drawImage(ong2, x3, h3 + DISTANCE, WIDTH_ONGNUOC, H_F, null);

    }

    public void giamX() {
        x1--;
        x2--;
        x3--;
    }

    public void lapLaiX() {
        if (x1 == -WIDTH_ONGNUOC) {
            x1 = W_F;
            bl1 = false;
        }
        if (x2 == -WIDTH_ONGNUOC) {
            x2 = W_F;
            bl2 = false;
        }
        if (x3 == -WIDTH_ONGNUOC) {
            x3 = W_F;
            bl3 = false;
        }

    }
}
