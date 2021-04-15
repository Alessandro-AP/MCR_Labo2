package observatorModel;

import java.util.LinkedList;

public abstract class Subject {

    private final LinkedList<MyObserver> observers = new LinkedList<>();

    /**
     * Attache un observateur
     * @param observer L'observateur
     */
    public void addObserver(MyObserver observer) {
        if (observer == null)
            throw new RuntimeException("MyObserver is null");
        observers.push(observer);
    }

    /**
     * Détache un observateur
     * @param observer L'observateur
     */
    public void deleteObserver(MyObserver observer) {
        observers.remove(observer);
    }


    /**
     * Notifie tous les observateurs
     */
    public void notifyObservators() {
        for (MyObserver observer : observers)
            observer.update();
    }
}
