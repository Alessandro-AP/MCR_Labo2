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
                // Détache chaques chronomètres de leur chrono
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
//	  super(new ClockPanel[]{},
//	  super(new ClockPanel[]{new RomanChrono(chrono), new ArabicChrono(chrono), new NumericClock(chrono)},
/*
    ClockPanel[] init(LinkedList<Chrono> list){
        RomanChrono[] romans = new RomanChrono[list.size()];
        for (int i = 0; i < list.size(); ++i)
            romans[i] = new RomanChrono(list.get(i));
         ClockPanel[] jchrono = romans;
        return jchrono;
    }*/
}

/**
 * Représente une vue avec un chronomètre analogique
 */

abstract class AnalogicClockFrame extends ClockFrame {

    public AnalogicClockFrame(ClockPanel clockPanel) {
        super(clockPanel);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                clockPanel.setSize(frame.getContentPane().getSize());
            }
        });
    }
}
/**
 * Représente une vue avec le chronomètre Roman
 */
class RomanClockFrame extends AnalogicClockFrame {
    public RomanClockFrame(Chrono chrono) {super(new RomanChrono(chrono)); }
}

/**
 * Représente une vue avec le chronomètre Arabic
 */
class ArabicClockFrame extends AnalogicClockFrame {
    public ArabicClockFrame(Chrono chrono) {
        super(new ArabicChrono(chrono));
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