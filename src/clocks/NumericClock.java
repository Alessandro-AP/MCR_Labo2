package clocks;

import chrono.Chrono;

import javax.swing.JLabel;
import java.awt.GridBagLayout;

/**
 * Classe représentant une horloge numérique
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public class NumericClock extends ClockPanel {

    private final JLabel label = new JLabel();

    /**
     * Constructeur
     * @param chrono Chronomètre associé à l'horloge
     */
    public NumericClock(Chrono chrono) {
        super(chrono);
        setLayout(new GridBagLayout());
        add(label);
        update();
    }

    @Override
    public void update() {
        label.setText("Chrono #" + getChrono().getId() + ": " +
                String.format("%02d", getChrono().getHours()) + "h " +
                String.format("%02d", getChrono().getMinutes()) + "m " +
                String.format("%02d", getChrono().getSecondes()) + "s");
    }
}