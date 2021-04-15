package clocks;

import observatorModel.Chrono;

import java.awt.*;

public class NumericClock extends ClockPanel {

    private Label label = new Label();

    public NumericClock(Chrono chrono) {
        super(chrono);

        add(label, BorderLayout.CENTER);
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