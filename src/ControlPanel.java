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
            rom.addActionListener(e -> new RomanClockView(chrono));

            final JButton arab = new JButton("Cadran arabe");
            clockCreator.add(arab);
            arab.addActionListener(e -> new ArabicClockView(chrono));

            final JButton num = new JButton("Numérique");
            clockCreator.add(num);
            num.addActionListener(e -> new DigitalClockView(chrono));

//            final JButton mixte = new JButton("Horloge mixte");
//            clockCreator.add(mixte);
//            mixte.addActionListener(e -> new MixteClockView(chrono));


        }
        JPanel lastPanel = new JPanel();

        JChrono[] romain = new JChrono[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i)
            romain[i] = new RomanChrono(chronosList.get(i));

        final JButton rom = new JButton("Cadrans romains");
        lastPanel.add(rom);
        rom.addActionListener(e -> new MultipleClockView(romain));

        JChrono[] arabe = new JChrono[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i)
            arabe[i] = new ArabicChrono(chronosList.get(i));

        final JButton mixte = new JButton("Cadrans arabes");
        lastPanel.add(mixte);
        mixte.addActionListener(e -> new MultipleClockView(arabe));

        JChrono[] numerique = new JChrono[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i)
            numerique[i] = new DigitalChrono(chronosList.get(i));

        final JButton dig = new JButton("Numériques");
        lastPanel.add(dig);
        dig.addActionListener(e -> new MultipleClockView(numerique));

/*
        final JButton rom = new JButton("Cadran romain");
        lastPanel.add(rom);
        rom.addActionListener(e -> {
            new RomanClockView(chrono);
        });

        final JButton arab = new JButton("Cadran arabe");
        lastPanel.add(arab);
        arab.addActionListener(e -> new ArabicClockView(chrono));

        final JButton num = new JButton("Numérique");
        lastPanel.add(num);
        num.addActionListener(e -> new DigitalClockView(chrono));*/
        mainPanel.add(lastPanel);


        frame.pack();
        frame.setVisible(true);
    }

}
