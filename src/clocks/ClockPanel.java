package clocks;

import observatorModel.Chrono;
import observatorModel.Observator;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ClockPanel extends JPanel implements Observator {

    private final Chrono chrono;

    public ClockPanel(Chrono chrono) {
        this.chrono = chrono;
        chrono.attach(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                chrono.changeState();
            }
        });
    }

    public Chrono getChrono() {
        return chrono;
    }
}