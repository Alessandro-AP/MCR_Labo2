import clocks.ArabicClock;
import clocks.ClockPanel;
import clocks.NumericClock;
import clocks.RomanClock;
import observatorModel.Chrono;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
public class ControlPanel {


    public ControlPanel(int nbClock) {

        JFrame frame = new JFrame();
        LinkedList<Chrono> chronosList = new LinkedList<>();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(nbClock + 1, 1));
        frame.add(mainPanel);

        for (int i = 1; i <= nbClock; ++i) {
            Chrono chrono = new Chrono(i);
            chronosList.add(chrono);
            JPanel clockCreator = new JPanel();
            mainPanel.add(clockCreator);

            final JLabel label = new JLabel("Chrono #" + i);
            clockCreator.add(label);

            final JButton start = new JButton("Démarrer");
            clockCreator.add(start);
            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chrono.start();
                }
            });

            final JButton stop = new JButton("Arreter");
            clockCreator.add(stop);
            stop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chrono.stop();
                }
            });

            final JButton reset = new JButton("Réinitialiser");
            clockCreator.add(reset);
            reset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chrono.reset();
                }
            });

            final JButton cadranRomain = new JButton("Cadran romain");
            clockCreator.add(cadranRomain);
            cadranRomain.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RomanClockFrame(chrono);
                }
            });

            final JButton cadranArabe = new JButton("Cadran arabe");
            clockCreator.add(cadranArabe);
            cadranArabe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ArabicClockFrame(chrono);
                }
            });

            final JButton numerique = new JButton("Numérique");
            clockCreator.add(numerique);
            numerique.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DigitalClockFrame(chrono);
                }
            });

        }

        JPanel lastPanel = new JPanel();

        ClockPanel[] romanClocks = new ClockPanel[chronosList.size()];
        ClockPanel[] arabicClocks = new ClockPanel[chronosList.size()];
        ClockPanel[] numericClocks = new ClockPanel[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i) {
            romanClocks[i] = new RomanClock(chronosList.get(i));
            arabicClocks[i] = new ArabicClock(chronosList.get(i));
            numericClocks[i] = new NumericClock(chronosList.get(i));
        }

        final JButton cadransRomains = new JButton("Cadrans romains");
        lastPanel.add(cadransRomains);
        cadransRomains.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MultipleClockFrame(romanClocks);
            }
        });

        final JButton cadransArabes = new JButton("Cadrans arabes");
        lastPanel.add(cadransArabes);
        cadransArabes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MultipleClockFrame(arabicClocks);
            }
        });

        final JButton cadransNumeriques = new JButton("Numériques");
        lastPanel.add(cadransNumeriques);
        cadransNumeriques.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MultipleClockFrame(numericClocks);
            }
        });

        mainPanel.add(lastPanel);
        frame.pack();
        frame.setVisible(true);
    }

}
