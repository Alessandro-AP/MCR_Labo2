package observatorModel;

import java.util.LinkedList;

/**
 * Classe abstraite représentant un sujet du model Observateur
 *
 * @author Alessandro Parrino
 * @author Daniel Sciarra
 * @version 1.0.0
 * Created on 22.04.21
 */
public abstract class Subject {

    private final LinkedList<MyObserver> observers = new LinkedList<>();

    /**
     * Ajoute un observateur au sujet
     * @param observer L'observateur à ajouter
     */
    public void addObserver(MyObserver observer) {
        observers.push(observer);
    }

    /**
     * Enlève un observateur du sujet
     * @param observer L'observateur à enlever
     */
    public void deleteObserver(MyObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifie tous les observateurs liés au sujet
     */
    public void notifyObservators() {
        for (MyObserver observer : observers)
            observer.update();
    }
}
