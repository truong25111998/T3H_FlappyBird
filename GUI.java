package gameflappybird;

import javax.swing.JFrame;

public class GUI extends JFrame implements Constants {

    private Panel pp;
    private Menu menu;

    public GUI() {
        setSize(W_F, H_F);
        setTitle("Game Flappy Bird");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        menu = new Menu();
        
        IMenu iMenu = new IMenu() {
            @Override
            public void showPlay() {
                addPlayRemoveMenu();
            }
        };
        menu.setAction(iMenu);
        add(menu);
    }

    public void addPlayRemoveMenu() {
        remove(menu);
        pp = new Panel();
        add(pp);
        repaint();

        pp.requestFocus();
        pp.setFocusable(true);
    }
}
