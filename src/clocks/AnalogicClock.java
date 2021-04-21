package clocks;

import chrono.Chrono;

import java.awt.Image;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Toolkit;

/**
 * Classe abstraite représentant une horloge analogique
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public abstract class AnalogicClock extends ClockPanel {

    private final Image img;

    // Caractéristiques de l'horloge
    private static final int Y_POS_TITLE = 120;
    private static final int X_POS_TITLE = 75;
    private static final int MAX_MINUTES_SECONDES = 60;
    private static final int MAX_HOURS = 24;
    private static final int HOURS_NEEDLE_THICKNESS = 4;
    private static final int MINUTES_NEEDLE_THICKNESS = 3;
    private static final int SECONDES_NEEDLE_THICKNESS = 2;

    /**
     * Constructeur
     * @param chrono Chronomètre associé à l'horloge
     * @param imagePath Chemin de l'image du cadran de l'horloge
     */
    protected AnalogicClock(Chrono chrono, String imagePath) {
        super(chrono);
        setLayout(new FlowLayout());
        img = Toolkit.getDefaultToolkit().getImage(imagePath).getScaledInstance(CLOCK_SIZE,
                CLOCK_SIZE, Image.SCALE_FAST);
    }

    /**
     * Dessine une aiguille sur l'horloge
     * @param g2d Graphics sur lequel dessiner
     * @param color Couleur de l'aiguille
     * @param length Longueur de l'aiguille
     * @param thickness Épaisseur de l'aiguille
     * @param time Heure de l'horloge
     * @param cycleDuration Cycle entier des heures (24) ou minutes/secondes (60)
     */
    private void drawNeedle(Graphics2D g2d, Color color, int length, int thickness,
                            int time, int cycleDuration) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        // position de la pointe de l'aiguille
        double degree = 2.0 * Math.PI * time / cycleDuration;
        int x2 = (int) (Math.sin(degree) * length);
        int y2 = (int) (-1 * Math.cos(degree) * length);
        g2d.drawLine(0, 0, x2, y2);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, 0, 0, this);
        g2d.drawString("Chrono #" + getChrono().getId(), X_POS_TITLE, Y_POS_TITLE);

        // centralise l'origine
        g2d.translate(CLOCK_SIZE / 2, CLOCK_SIZE / 2);

        drawNeedle(g2d, Color.RED, (int) (CLOCK_SIZE * 0.4), SECONDES_NEEDLE_THICKNESS,
                    getChrono().getSecondes(), MAX_MINUTES_SECONDES);
        drawNeedle(g2d, Color.BLUE, (int) (CLOCK_SIZE * 0.3), MINUTES_NEEDLE_THICKNESS,
                    getChrono().getMinutes(), MAX_MINUTES_SECONDES);
        drawNeedle(g2d, Color.BLACK, (int) (CLOCK_SIZE * 0.2), HOURS_NEEDLE_THICKNESS,
                    getChrono().getHours(), MAX_HOURS);
    }
}

