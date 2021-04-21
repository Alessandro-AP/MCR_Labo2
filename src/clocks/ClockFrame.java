package clocks;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClockFrame {

    public ClockFrame(ClockPanel[] clockPanels) {

        JFrame frame = new JFrame();

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