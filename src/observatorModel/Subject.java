package observatorModel;

import java.util.LinkedList;

public abstract class Subject {
    private LinkedList<Observator> observators = new LinkedList<>();

    /**
     * Attache un observateur
     * @param o L'observateur
     */
    public void attach(Observator o) {
        if (o == null) throw new RuntimeException("observatorModel.Observator is null");
        observators.push(o);
    }

    /**
     * Détache un observateur
     * @param o L'observateur
     */
    public void detach(Observator o) {
        observators.remove(o);
    }


    /**
     * Notifie tous les observateurs
     */
    public void notifyObservators() {
        for (Observator o : observators)
            o.update();
    }
}
