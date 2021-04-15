import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AnalogicChrono extends ClockPanel {

    private int clockSize = 200;
    private Image img;
    private Image originalImg; // Pour le rescale

    public AnalogicChrono(Chrono chrono, String pathFile) {
        super(chrono);
        setLayout(new FlowLayout());

        // Lis l'image et la resize
        try {
            originalImg = ImageIO.read(new File(pathFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setSize(new Dimension(clockSize, clockSize));
    }

    @Override
    public void update() { repaint(); }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(img, 0, 0, null);
        g.drawString("Chrono #" + chrono.getId(), 80, 120);

        // On met le point [0,0] au centre de la montre
        g.translate(clockSize / 2, clockSize / 2);

        Graphics2D gr = (Graphics2D) g;

        // On dessine les aiguilles
        int size = Math.min(clockSize, clockSize);
        drawClockHand(gr, getChrono().getHour(), 12, 7, size / 7, Color.BLACK);
        drawClockHand(gr, getChrono().getMin(), 60, 5, size / 5, Color.BLUE);
        drawClockHand(gr, getChrono().getSec(), 60, 3, size / 3, Color.RED);
    }

    /**
     * Permet de dessiner une aiguille d'une horloge depuis le point [0,0]
     *
     * @param g      Sur quel graphics dessiner
     * @param time   Le temps
     * @param max    Sur combien de temps doit être compté le temps
     * @param width  La largeur de l'aiguille
     * @param length La longueur de l'aiguille
     * @param color  La couleur de l'aiguille
     */
    private void drawClockHand(Graphics2D g, double time, int max, int width, int length, Color color) {
        double angle = (time / max) * 2 * Math.PI;
        g.setStroke(new BasicStroke(width));
        g.setColor(color);
        g.drawLine(0, 0, (int) (Math.sin(angle) * length), (int) (-Math.cos(angle) * length));
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(d);
        setPreferredSize(d);
        clockSize = (int) Math.min(d.getHeight(), d.getWidth());
        img = originalImg.getScaledInstance(clockSize, clockSize, Image.SCALE_FAST);
    }

}

/**
 * Représente un chrono avec des chiffres arabes
 */
class ArabicChrono extends AnalogicChrono {
    public ArabicChrono(Chrono chrono) {
        super(chrono, "img/cadran_chiffres_arabes.jpg");
    }
}

/**
 * Représente un chrono avec des chiffres romains
 */
class RomanChrono extends AnalogicChrono {
    public RomanChrono(Chrono chrono) {
        super(chrono, "img/cadran_chiffres_romains.jpg");
    }
}
