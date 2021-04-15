package clocks;

import chrono.Chrono;

import java.awt.*;

public class NumericClock extends ClockPanel {

    private final Label label = new Label();
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