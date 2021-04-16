package control;

import chrono.Chrono;
import clocks.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ControlPanel {

    private static ControlPanel instance;

    public static ControlPanel getInstance(int nbClock) {
        if (instance == null)
            instance = new ControlPanel(nbClock);
        return instance;
    }

    private ControlPanel(int nbClock) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(nbClock + 1, 1));
        frame.add(mainPanel);

        LinkedList<Chrono> chronosList = new LinkedList<>();

        for (int i = 1; i <= nbClock; ++i) {
            Chrono chrono = new Chrono(i);
            chronosList.add(chrono);
            JPanel clockCreator = new JPanel();
            mainPanel.add(clockCreator);

            clockCreator.add(new JLabel("Chrono #" + i));

            addButton("Démarrer", clockCreator, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chrono.start();
                }
            });

            addButton("Arreter", clockCreator, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chrono.stop();
                }
            });

            addButton("Réinitialiser", clockCreator, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chrono.reset();
                }
            });

            addButton("Cadran romain", clockCreator, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ClockFrame(new RomanClock(chrono));
                }
            });

            addButton("Cadran arabe", clockCreator, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ClockFrame(new ArabicClock(chrono));
                }
            });

            addButton("Numérique", clockCreator, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new ClockFrame(new NumericClock(chrono));
                }
            });
        }

        JPanel lastPanel = new JPanel();
        lastPanel.add(new JLabel("Tous les chronos"));

        ClockPanel[] romanClocks = new ClockPanel[chronosList.size()];
        ClockPanel[] arabicClocks = new ClockPanel[chronosList.size()];
        ClockPanel[] numericClocks = new ClockPanel[chronosList.size()];

        for(int i = 0; i < chronosList.size(); ++i) {
            romanClocks[i] = new RomanClock(chronosList.get(i));
            arabicClocks[i] = new ArabicClock(chronosList.get(i));
            numericClocks[i] = new NumericClock(chronosList.get(i));
        }

        addButton("Cadrans romains", lastPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClockFrame(romanClocks);
                for(int i = 0; i < chronosList.size(); ++i)
                    romanClocks[i] = new RomanClock(chronosList.get(i));

            }
        });

        addButton("Cadrans arabes", lastPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClockFrame(arabicClocks);
                for(int i = 0; i < chronosList.size(); ++i)
                    arabicClocks[i] = new ArabicClock(chronosList.get(i));

            }
        });

        addButton("Numériques", lastPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClockFrame(numericClocks);
                for(int i = 0; i < chronosList.size(); ++i)
                    numericClocks[i] = new NumericClock(chronosList.get(i));

            }
        });


        mainPanel.add(lastPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void addButton(String name, JPanel toPanel, ActionListener actionListener) {
        final JButton button = new JButton(name);
        toPanel.add(button);
        button.addActionListener(actionListener);
    }

}
