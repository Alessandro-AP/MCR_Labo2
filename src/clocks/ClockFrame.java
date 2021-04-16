package clocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockFrame {

    protected JFrame frame = new JFrame();

    public ClockFrame(ClockPanel[] clockPanels) {

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (ClockPanel clockPanel : clockPanels)
                    clockPanel.getChrono().deleteObserver(clockPanel);
            }
        });

        frame.setLayout(new FlowLayout());

        for (ClockPanel clockPanel : clockPanels)
            frame.add(clockPanel);

        if(clockPanels.length == 1)
            frame.setResizable(false);

        frame.setVisible(true);
        frame.pack();
    }

    public ClockFrame(ClockPanel clockPanel) {
        this(new ClockPanel[]{clockPanel});
    }
}