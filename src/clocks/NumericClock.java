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
        String secondes = String.format("%02d", (int) getChrono().getSec());
        String minutes = String.format("%02d", (int) getChrono().getMin());
        String hours = String.format("%02d", (int) getChrono().getHour());
        label.setText(hours + "h " + minutes + "m " + secondes + "s");
    }
}