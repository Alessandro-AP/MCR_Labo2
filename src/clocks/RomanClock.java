package clocks;

import observatorModel.Chrono;

/**
 * Représente un chrono avec des chiffres romains
 */
public class RomanClock extends AnalogicClock {
    public RomanClock(Chrono chrono) {
        super(chrono, "img/cadran_chiffres_romains.jpg");
    }
}
