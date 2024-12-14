package exemplosparalela;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class TestaRobot {

    public static void main(String[] args) {
        try {
            Robot r = new Robot();

            long tIni = System.currentTimeMillis();

            BufferedImage image = r.createScreenCapture(new Rectangle(1920, 1080));

            System.out.println(System.currentTimeMillis() - tIni);
            
            /*
            Color matColor[][] = new Color[120][120];

            for (int y = 0; y < 120; y++) {
                for (int x = 0; x < 120; x++) {
                    matColor[x][y] = r.getPixelColor(x, y);
                }
                System.out.println(y);
            }
             */
            MostraTestaRobot mostra = new MostraTestaRobot();
            //mostra.setaImagem(matColor);
            mostra.setaCaptura(image);
            mostra.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
