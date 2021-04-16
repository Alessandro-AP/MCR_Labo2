package clocks;

import chrono.Chrono;
import observatorModel.MyObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ClockPanel extends JPanel implements MyObserver {

    protected final int clockSize = 200;
    private final Chrono chrono;

    protected ClockPanel(Chrono chrono) {
        this.chrono = chrono;
        chrono.addObserver(this);

        setPreferredSize(new Dimension(clockSize, clockSize));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chrono.changeState();
            }
        });
    }

    public Chrono getChrono() {
        return chrono;
    }
}