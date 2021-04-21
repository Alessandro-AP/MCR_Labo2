import control.ControlPanel;

/**
 * Classe lançant le programme
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 * JDK version : 11
 */
public class ChronoApp {
    /**
     * Fonction principale du programme
     * @param args Nombre d'horloges souhaitées
     * @throws IllegalArgumentException si le nombre de chronomètre n'est pas entre 1 et 9
     */
    public static void main(String[] args) {

        if (args.length != 1)
            throw new IllegalArgumentException("Provide only the number of chrono");

        int nbChrono = Integer.parseInt(args[0]);
        if (nbChrono < 1 || nbChrono > 9)
            throw new IllegalArgumentException("Choose between 1 and 9 chronos");

        new ControlPanel(nbChrono);
    }
}