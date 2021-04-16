package clocks;

import chrono.Chrono;

import javax.swing.JLabel;
import java.awt.GridBagLayout;

public class NumericClock extends ClockPanel {

    private final JLabel label = new JLabel();
    private final int id = getChrono().getId();

    public NumericClock(Chrono chrono) {
        super(chrono);
        setLayout(new GridBagLayout());
        add(label);
        update();
    }

    @Override
    public void update() {
        label.setText("Chrono #" + id + ": " +
                String.format("%02d", getChrono().getHours()) + "h " +
                String.format("%02d", getChrono().getMinutes()) + "m " +
                String.format("%02d", getChrono().getSecondes()) + "s");
    }
}