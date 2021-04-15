import clocks.ArabicClock;
import clocks.ClockPanel;
import clocks.NumericClock;
import clocks.RomanClock;
import observatorModel.Chrono;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class ClockFrame {

    protected JFrame frame = new JFrame();

    public ClockFrame(ClockPanel[] clockPanels) {

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Détache chaque chronomètre de leur chrono
                for (ClockPanel clockPanel : clockPanels)
                    clockPanel.getChrono().detach(clockPanel);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel);

        for (ClockPanel clockPanel : clockPanels)
            panel.add(clockPanel);

        if(clockPanels.length == 1)
            frame.setResizable(false);

        frame.setVisible(true);
        frame.pack();
    }

    public ClockFrame(ClockPanel clockPanel) {
        this(new ClockPanel[]{clockPanel});
    }
}

/**
 * Représente une vue avec les chronomètres Roman, Arabic et Digital
 */
class MultipleClockFrame extends ClockFrame {
    public MultipleClockFrame(ClockPanel[] chronoList) {
        super(chronoList);
    }
}

/**
 * Représente une vue avec un chronomètre analogique
 */

abstract class AnalogicClockFrame extends ClockFrame {

    public AnalogicClockFrame(ClockPanel clockPanel) {
        super(clockPanel);
    }
}
/**
 * Représente une vue avec le chronomètre Roman
 */
class RomanClockFrame extends AnalogicClockFrame {
    public RomanClockFrame(Chrono chrono) {super(new RomanClock(chrono)); }
}

/**
 * Représente une vue avec le chronomètre Arabic
 */
class ArabicClockFrame extends AnalogicClockFrame {
    public ArabicClockFrame(Chrono chrono) {
        super(new ArabicClock(chrono));
    }
}

/**
 * Représente une vue avec le chronomètre Digital
 */
class DigitalClockFrame extends ClockFrame {
    public DigitalClockFrame(Chrono chrono) {
        super(new NumericClock(chrono));
    }
}