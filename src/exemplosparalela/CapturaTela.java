package exemplosparalela;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class CapturaTela {

    public static void main(String[] args) {

        try {
            Robot r = new Robot();

            Rectangle rect = new Rectangle(0, 0, 1920, 1080);
            BufferedImage image = r.createScreenCapture(rect);

            CapturaTelaMostra cap = new CapturaTelaMostra();
            cap.setVisible(true);
            cap.setImage(image);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
