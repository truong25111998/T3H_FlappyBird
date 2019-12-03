package gameflappybird;

import java.awt.Rectangle;

public class KiemTra extends OngNuoc implements Constants {

    private ConChim conChimK = new ConChim();

    public boolean die() {

        Rectangle reChim = new Rectangle(conChimK.getX(), conChimK.getY(), 45, 32);
        Rectangle reOngt1 = new Rectangle(x1, 0, WIDTH_ONGNUOC, h1);
        Rectangle reOngd1 = new Rectangle(x1, h1 + 100, WIDTH_ONGNUOC, H_F);
        Rectangle reOngt2 = new Rectangle(x2, 0, WIDTH_ONGNUOC, h2);
        Rectangle reOngd2 = new Rectangle(x2, h2 + 100, WIDTH_ONGNUOC, H_F);
        Rectangle reOngt3 = new Rectangle(x3, 0, WIDTH_ONGNUOC, h3);
        Rectangle reOngd3 = new Rectangle(x3, h3 + 100, WIDTH_ONGNUOC, H_F);
        Rectangle reNen = new Rectangle(0, H_F - 100, W_F, H_F - 400);

        boolean vanen = reChim.intersects(reNen);
        boolean vaCham1 = reChim.intersects(reOngt1);
        boolean vacham1 = reChim.intersects(reOngd1);
        boolean vaCham2 = reChim.intersects(reOngt2);
        boolean vacham2 = reChim.intersects(reOngd2);
        boolean vaCham3 = reChim.intersects(reOngt3);
        boolean vacham3 = reChim.intersects(reOngd3);
        if (vaCham1 || vacham1 || vaCham2 || vacham2 || vaCham3 || vacham3 || vanen) {

            return true;
        }

        return false;
    }
}
