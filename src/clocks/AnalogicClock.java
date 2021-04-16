package clocks;

import chrono.Chrono;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.io.File;
import java.io.IOException;

/**
 * Classe abstraite représentant une horloge analogique
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * Created on 15.04.21
 */
public abstract class AnalogicClock extends ClockPanel {

    private Image img;

    /**
     * Constructeur
     * @param chrono Chrono associé à la clock
     * @param pathFile Chemin de l'image du cadran de la clock
     */
    protected AnalogicClock(Chrono chrono, String pathFile) {
        super(chrono);
        setLayout(new FlowLayout());

//        img = Toolkit.getDefaultToolkit().getImage(pathFile).getScaledInstance(clockSize, clockSize, Image.SCALE_FAST);
//        repaint();

        try {
            img = ImageIO.read(new File(pathFile)).getScaledInstance(clockSize, clockSize, Image.SCALE_FAST);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Dessine une aiguille sur la clock
     * @param g2d Graphics sur lequel dessiner
     * @param time Heure de la clock
     * @param cycleDuration Cycle entier des heures (24) ou minutes/secondes (60)
     * @param thickness Épaisseur de l'aiguille
     * @param length Longueur de l'aiguille
     * @param color Couleur de l'aiguille
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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

