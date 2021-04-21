import control.ControlPanel;

/**
 * Classe lançant le programme
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * Created on 15.04.21
 * JDK version : 11
 */
public class Main {

    public static void main(String[] args) {

        if (args.length != 1)
            throw new IllegalArgumentException("Provide the number of chrono only");

        int nbChrono = Integer.parseInt(args[0]);
        if (nbChrono < 1 || nbChrono > 9)
            throw new IllegalArgumentException("Choose between 1 and 9 chronos");

        new ControlPanel(nbChrono);
    }
}