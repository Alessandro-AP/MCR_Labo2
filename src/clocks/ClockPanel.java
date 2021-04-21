package clocks;

import chrono.Chrono;
import observatorModel.MyObserver;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe abstraite représentant une horloge
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public abstract class ClockPanel extends JPanel implements MyObserver {

    protected static final int CLOCK_SIZE = 200;
    private final Chrono chrono;

    /**
     * Constructeur
     * @param chrono Chronomètre associé à l'horloge
     */
    protected ClockPanel(Chrono chrono) {
        this.chrono = chrono;
        this.chrono.addObserver(this);

        setPreferredSize(new Dimension(CLOCK_SIZE, CLOCK_SIZE));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chrono.changeState();
            }
        });
    }

    /**
     * @return le chronomètre associé à l'horloge
     */
    public Chrono getChrono() {
        return chrono;
    }
}