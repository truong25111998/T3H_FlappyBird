package gameflappybird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, Constants {

    private ConChim conChim = new ConChim();
    private OngNuoc ongNuoc = new OngNuoc();
    private DiemSo diemSo = new DiemSo();
    private KiemTra kt = new KiemTra();
    private boolean isDie;
    private SoundManager soundY;
    private SoundManager soundW;
    private Image imgnd, imgbg;
    Thread th;

    public Panel() {
        setSize(W_F, H_F);
        setBackground(Color.black);
        th = new Thread(this);
        th.start();
        soundY = new SoundManager("/Sound/sfx_wing.wav");
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (!isDie) {
                    conChim.giamY();
                    soundY.play(false);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        String path = "/imgs/b.png";
        String path1 = "/imgs/ground.png";
        imgnd = new ImageIcon(getClass().getResource(path1)).getImage();
        imgbg = new ImageIcon(getClass().getResource(path)).getImage();

        g.drawImage(imgbg, 0, 0, null);
        ongNuoc.paint(g);
        g.drawImage(imgnd, 0, H_F - 100, null);
        conChim.paint(g);

        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score" + diemSo.getDiem(), 10, 20);

    }

    @Override
    public void run() {
        while (true) {
            repaint();
            ongNuoc.giamX();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }

            ongNuoc.lapLaiX();
            conChim.tangY();

            if (kt.die() == true) {

                break;
            }
            diemSo.congDiem();

        }
    }

}
