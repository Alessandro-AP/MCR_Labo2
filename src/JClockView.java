import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class JClockView extends JFrame {

    public JClockView(JChrono[] jChronos) {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Détache chaques chronomètres de leur chrono
                for (JChrono jChrono : jChronos)
                    jChrono.getChrono().detach(jChrono);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        getContentPane().add(panel);

        for (JChrono jChrono : jChronos)
            panel.add(jChrono);

//        setSize(200, 200);

        if(jChronos.length == 1)
            setResizable(false);

        setVisible(true);
        pack();
    }

    public JClockView(JChrono jChrono) {
        this(new JChrono[]{jChrono});
    }
}

/**
 * Représente une vue avec les chronomètres Roman, Arabic et Digital
 */
class MultipleClockView extends JClockView {
    public MultipleClockView(JChrono[] chronoList) {
        super(chronoList);
    }
//	  super(new JChrono[]{},
//	  super(new JChrono[]{new RomanChrono(chrono), new ArabicChrono(chrono), new DigitalChrono(chrono)},
/*
    JChrono[] init(LinkedList<Chrono> list){
        RomanChrono[] romans = new RomanChrono[list.size()];
        for (int i = 0; i < list.size(); ++i)
            romans[i] = new RomanChrono(list.get(i));
         JChrono[] jchrono = romans;
        return jchrono;
    }*/
}

/**
 * Représente une vue avec un chronomètre analogique
 */

abstract class AnalogicClockView extends JClockView {

    public AnalogicClockView(JChrono jChrono) {
        super(jChrono);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                jChrono.setSize(getContentPane().getSize());
            }
        });
    }
}
/**
 * Représente une vue avec le chronomètre Roman
 */
class RomanClockView extends AnalogicClockView {
    public RomanClockView(Chrono chrono) {super(new RomanChrono(chrono)); }
}

/**
 * Représente une vue avec le chronomètre Arabic
 */
class ArabicClockView extends AnalogicClockView {
    public ArabicClockView(Chrono chrono) {
        super(new ArabicChrono(chrono));
    }
}

/**
 * Représente une vue avec le chronomètre Digital
 */
class DigitalClockView extends JClockView {
    public DigitalClockView(Chrono chrono) {
        super(new DigitalChrono(chrono));
    }
}