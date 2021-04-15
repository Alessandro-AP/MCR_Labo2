package observatorModel;

import java.util.LinkedList;

public abstract class Subject {

    private final LinkedList<Observator> observators = new LinkedList<>();

    /**
     * Attache un observateur
     * @param observator L'observateur
     */
    public void attach(Observator observator) {
        if (observator == null)
            throw new RuntimeException("Observator is null");
        observators.push(observator);
    }

    /**
     * Détache un observateur
     * @param observator L'observateur
     */
    public void detach(Observator observator) {
        observators.remove(observator);
    }


    /**
     * Notifie tous les observateurs
     */
    public void notifyObservators() {
        for (Observator observator : observators)
            observator.update();
    }
}
