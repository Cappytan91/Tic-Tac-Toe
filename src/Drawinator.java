import java.awt.*;
import java.awt.image.ImageObserver;

public class Drawinator {

    public static Graphics graphics;

    public static void DrawQuadIMG(int x, int y, Image img){
        graphics.drawImage(img, x, y, 64, 64, null);
    }

}
