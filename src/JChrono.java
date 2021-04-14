import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class JChrono extends JPanel implements Observator {

    protected Chrono chrono;

    public JChrono(Chrono chrono) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                chrono.switchState();
            }
        });
        this.chrono = chrono;
        chrono.attach(this);
    }

    /**
     * @return le chrono
     */
    public Chrono getChrono() { return chrono; }
}