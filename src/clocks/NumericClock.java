package clocks;

import observatorModel.Chrono;

import java.awt.*;

// TODO: mouselistener

public class NumericClock extends ClockPanel {

    private final Label label = new Label();

    public NumericClock(Chrono chrono) {
        super(chrono);
        setPreferredSize(new Dimension(200, 200));
        setLayout(new GridBagLayout());
        add(label);
        update();
    }

    @Override
    public void update() {
        label.setText("Chrono #" + getChrono().getId() + " " +
                String.format("%02d", getChrono().getHours()) + "h " +
                String.format("%02d", getChrono().getMinutes()) + "m " +
                String.format("%02d", getChrono().getSecondes()) + "s");
    }
}