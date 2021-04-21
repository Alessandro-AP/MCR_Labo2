package chrono;

import observatorModel.Subject;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe représentant un chronomètre
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public class Chrono extends Subject {

    private Timer timer;
    private int secondes;
    private final int id;

    /**
     * Constructeur
     * @param id ID du chronomètre
     */
    public Chrono(int id) {
        timer   = null;
        this.id = id;
    }

    /**
     * Démarre le chronomètre et notifie les observateurs
     */
    public void start() {
        if (timer == null) {
            timer = new Timer();

            timer.schedule(new TimerTask() {
                public void run() {
                    secondes++;
                    notifyObservators();
                }
            }, 0, 1000);
        }
    }

    /**
     * Reset le chronomètre en remettant le temps à 0 et notifie les observateurs
     */
    public void reset() {
        secondes = 0;
        notifyObservators();
    }

    /**
     * Stoppe le chronomètre, supprime la tâche et notifie les observateurs
     */
    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
            timer = null;
            notifyObservators();
        }
    }

    /**
     * Passe de l'état stop à start et vice-versa
     */
    public void changeState() {
        if (timer == null)
            start();
        else
            stop();
    }

    /**
     * @return l'id du chronomètre
     */
    public int getId() {
        return id;
    }

    /**
     * @return le temps en heure du chronomètre
     */
    public int getHours() { return (secondes / 3600) % 24; }

    /**
     * @return le temps en minute du chronomètre
     */
    public int getMinutes() { return (secondes / 60) % 60; }

    /**
     * @return le temps en seconde du chronomètre
     */
    public int getSecondes() {
        return secondes % 60;
    }

}