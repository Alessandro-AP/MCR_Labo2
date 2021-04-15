import clocks.ArabicClock;
import clocks.ClockPanel;
import clocks.NumericClock;
import clocks.RomanClock;
import observatorModel.Chrono;

import javax.swing.*;
import java.awt.*;
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
            start.addActionListener(e -> chrono.start());

            final JButton stop = new JButton("Arreter");
            clockCreator.add(stop);
            stop.addActionListener(e -> chrono.stop());

            final JButton reset = new JButton("Réinitialiser");
            clockCreator.add(reset);
            reset.addActionListener(e -> chrono.reset());

            final JButton rom = new JButton("Cadran romain");
            clockCreator.add(rom);
            rom.addActionListener(e -> new RomanClockFrame(chrono));

            final JButton arab = new JButton("Cadran arabe");
            clockCreator.add(arab);
            arab.addActionListener(e -> new ArabicClockFrame(chrono));

            final JButton num = new JButton("Numérique");
            clockCreator.add(num);
            num.addActionListener(e -> new DigitalClockFrame(chrono));

//            final JButton mixte = new JButton("Horloge mixte");
//            clockCreator.add(mixte);
//            mixte.addActionListener(e -> new MixteClockView(chrono));


        }
        JPanel lastPanel = new JPanel();

        ClockPanel[] romain = new ClockPanel[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i)
            romain[i] = new RomanClock(chronosList.get(i));

        final JButton rom = new JButton("Cadrans romains");
        lastPanel.add(rom);
        rom.addActionListener(e -> new MultipleClockFrame(romain));

        ClockPanel[] arabe = new ClockPanel[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i)
            arabe[i] = new ArabicClock(chronosList.get(i));

        final JButton mixte = new JButton("Cadrans arabes");
        lastPanel.add(mixte);
        mixte.addActionListener(e -> new MultipleClockFrame(arabe));

        ClockPanel[] numerique = new ClockPanel[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i)
            numerique[i] = new NumericClock(chronosList.get(i));

        final JButton dig = new JButton("Numériques");
        lastPanel.add(dig);
        dig.addActionListener(e -> new MultipleClockFrame(numerique));

/*
        final JButton rom = new JButton("Cadran romain");
        lastPanel.add(rom);
        rom.addActionListener(e -> {
            new RomanClockFrame(chrono);
        });

        final JButton arab = new JButton("Cadran arabe");
        lastPanel.add(arab);
        arab.addActionListener(e -> new ArabicClockFrame(chrono));

        final JButton num = new JButton("Numérique");
        lastPanel.add(num);
        num.addActionListener(e -> new DigitalClockFrame(chrono));*/
        mainPanel.add(lastPanel);


        frame.pack();
        frame.setVisible(true);
    }

}
