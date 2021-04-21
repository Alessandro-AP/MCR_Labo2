package clocks;

import chrono.Chrono;

/**
 * Classe représentant une horloge avec un cadran romain
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public class RomanClock extends AnalogicClock {

    private static final String IMAGE_PATH = "img/cadran_chiffres_romains.jpg";

    /**
     * Constructeur
     * @param chrono Chronomètre associé à l'horloge
     */
    public RomanClock(Chrono chrono) {
        super(chrono, IMAGE_PATH);
    }
}
