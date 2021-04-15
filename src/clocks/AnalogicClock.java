package clocks;

import observatorModel.Chrono;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class AnalogicClock extends ClockPanel {

    private final Image img;

    public AnalogicClock(Chrono chrono, String pathFile) {
        super(chrono);
        setLayout(new FlowLayout());

       // URL imgUrl = getClass().getResource(pathFile); // resource name here
//        Image tmp = Toolkit.getDefaultToolkit().getImage(pathFile);

        Image tmp = Toolkit.getDefaultToolkit().getImage(pathFile);
        img = tmp.getScaledInstance(200, 200, Image.SCALE_FAST);

//        try {
//            img = ImageIO.read(new File(pathFile)).getScaledInstance(clockSize, clockSize, Image.SCALE_FAST);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Permet de dessiner une aiguille d'une horloge depuis le point [0,0]
     *
     * @param g2d      Sur quel graphics dessiner
     * @param time   Le temps
     * @param cycleDuration Sur combien de temps doit être compté le temps
     * @param thickness  La largeur de l'aiguille
     * @param length La longueur de l'aiguille
     * @param color  La couleur de l'aiguille
     */
    private void drawNeedle(Graphics2D g2d, Color color, int length, int thickness, int time, int cycleDuration) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        // position de la pointe de l'aiguille
        double degree = 2.0 * Math.PI * time / cycleDuration;
        int x2 = (int) (Math.sin(degree) * length);
        int y2 = (int) (-1 * Math.cos(degree) * length);
        g2d.drawLine(0, 0, x2, y2);
    }

    @Override
    public void update() { repaint(); }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, 0, 0, null);
        g2d.drawString("Chrono #" + getChrono().getId(), 80, 120);

        // centralise l'origine
        g2d.translate(clockSize / 2, clockSize / 2);

        drawNeedle(g2d, Color.RED, (int) (clockSize * 0.4), 2, getChrono().getSecondes(), 60);
        drawNeedle(g2d, Color.BLUE, (int) (clockSize * 0.3), 3, getChrono().getMinutes(), 60);
        drawNeedle(g2d, Color.BLACK, (int) (clockSize * 0.2), 4, getChrono().getHours(), 12);
    }
}

