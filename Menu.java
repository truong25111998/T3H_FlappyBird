package gameflappybird;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu extends JPanel implements Constants, ActionListener{
    private Image imgBg;
    private IMenu myAction;
    public Menu(){
        setSize(W_F, H_F);
        
        setLayout(null);
        init();
    }
    public void init(){
        imgBg = Utils.getImage("/imgs/f.jpg", W_F, H_F);
        JButton btnPlay = new JButton();
        btnPlay.setSize(100, 50);
        btnPlay.setLocation(180, 370);
        btnPlay.setVerticalTextPosition(SwingConstants.CENTER);
        btnPlay.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPlay.setText("Play");
        btnPlay.setIcon(new ImageIcon(
               Utils.getImage("/imgs/up.png",
                       200, 50)
        ));
        btnPlay.addActionListener(this);
        add(btnPlay);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(imgBg, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myAction.showPlay();
    }

    void setAction(IMenu action) {
        myAction = action;
    }
    

    
    
    
}
