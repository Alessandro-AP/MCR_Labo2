package control;

import chrono.Chrono;
import clocks.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Classe représentant le panneau de contrôle gérant les horloges
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public class ControlPanel {
    /**
     * Constructeur
     * @param nbClock Nombre d'horloge contenues dans le panneau de contrôle
     */
    public ControlPanel(int nbClock) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(nbClock + 1, 1));

        LinkedList<Chrono> chronosList = new LinkedList<>();

        for (int i = 1; i <= nbClock; ++i) {

            Chrono chrono = new Chrono(i);
            chronosList.add(chrono);

            JPanel clockCreator = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            frame.add(clockCreator);

            clockCreator.add(new JLabel("Chrono #" + i));

            addButtons(clockCreator, chrono);

        }

        addBottomPanel(frame, chronosList, nbClock);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Ajout d'un bouton sur le panneau de contrôle
     * @param name Nom du bouton
     * @param toPanel Panneau sur lequel ajouter le bouton
     * @param actionListener ActionListener associé au bouton
     */
    private void addButton(String name, JPanel toPanel, ActionListener actionListener) {
        final JButton button = new JButton(name);
        toPanel.add(button);
        button.addActionListener(actionListener);
    }

    /**
     * Ajout de la ligne de boutons pour un chronomètre, au control panel
     * @param clockCreator Panneau sur lequel ajouter le bouton
     * @param chrono chronomètre associé aux boutons
     */
    private void addButtons(JPanel clockCreator, Chrono chrono){

        addButton("Démarrer", clockCreator, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chrono.start();
            }
        });

        addButton("Arreter", clockCreator, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chrono.pause();
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

    /**
     * Ajout de la dernier ligne de boutons au control panel
     * @param mainFrame Fenêtre du control panel
     * @param chronosList liste de chronomètres
     * @param nbClock nombre de chronomètres
     */
    private void addBottomPanel(JFrame mainFrame, LinkedList<Chrono> chronosList, int nbClock){

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(new JLabel("Tous les chronos"));

        ClockPanel[] romanClocks = new ClockPanel[nbClock];
        ClockPanel[] arabicClocks = new ClockPanel[nbClock];
        ClockPanel[] numericClocks = new ClockPanel[nbClock];

        addButton("Cadrans romains", bottomPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < nbClock; ++i)
                    romanClocks[i] = new RomanClock(chronosList.get(i));

                new ClockFrame(romanClocks);
            }
        });

        addButton("Cadrans arabes", bottomPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < nbClock; ++i)
                    arabicClocks[i] = new ArabicClock(chronosList.get(i));

                new ClockFrame(arabicClocks);
            }
        });

        addButton("Numériques", bottomPanel, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i < nbClock; ++i)
                    numericClocks[i] = new NumericClock(chronosList.get(i));

                new ClockFrame(numericClocks);
            }
        });

        mainFrame.add(bottomPanel);
    }

}
