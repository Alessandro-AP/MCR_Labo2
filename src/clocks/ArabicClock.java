package clocks;

import chrono.Chrono;

/**
 * Classe représentant une horloge avec un cadran arabe
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public class ArabicClock extends AnalogicClock {

    private static final String IMAGE_PATH = "img/cadran_chiffres_arabes.jpg";

    /**
     * Constructeur
     * @param chrono Chronomètre associé à l'horloge
     */
    public ArabicClock(Chrono chrono) {
        super(chrono, IMAGE_PATH);
    }
}
