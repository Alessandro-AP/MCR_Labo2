package observatorModel;

import java.util.Timer;
import java.util.TimerTask;

public class Chrono extends Subject {

    private Timer timer;
    private int time;
    private final int id;

    public Chrono(int id) {
        timer   = null;
        this.id = id;
    }

    /**
     * Pour démarrer le chrono
     */
    public void start() {
        if (timer == null) {
            timer = new Timer();

            timer.schedule(new TimerTask() {
                // Créer une tâche qui incrémente toute les secondes le temps de 1
                public void run() {
                    time++;
                    notifyObservators();
                }
            }, 0, 1000);
        }
    }

    /**
     * Permet de reset le chrono et de remettre le temps à 0
     */
    public void reset() {
        time = 0;
        notifyObservators();
    }

    /**
     * Permet de stopper le chrono et de supprimer la tâche
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
     * Permute entre l'état stop et start
     */
    public void changeState() {
        if (timer == null)
            start();
        else
            stop();
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return le temps en heure
     */
    public int getHours() { return (time / 3600) % 24; }

    /**
     * @return le temps en minute
     */
    public int getMinutes() { return (time / 60) % 60; }

    /**
     * @return le temps en seconde
     */
    public int getSecondes() {
        return time % 60;
    }

}