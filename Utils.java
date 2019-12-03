package gameflappybird;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Utils {

    public static Image getImage(String path, int w, int h) {
        try {

            return ImageIO.read(Utils.class.getResource(path)).getScaledInstance(w, h, Image.SCALE_SMOOTH);

        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
