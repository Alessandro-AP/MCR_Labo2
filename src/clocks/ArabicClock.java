package clocks;

import observatorModel.Chrono;

/**
 * Représente un chrono avec des chiffres arabes
 */
public class ArabicClock extends AnalogicClock {
    public ArabicClock(Chrono chrono) {
        super(chrono, "img/cadran_chiffres_arabes.jpg");
    }
}
