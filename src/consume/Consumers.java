package consume;

public abstract class Consumers {

    /**
     * Fonction qui renvoie la puissance consommée par chaque consommateurs
     * 
     * @param sunshine le rayonnement du soleil (couverture nuageuse, nuit)
     * @param time temps incrémenté sur le rapport (en minutes)
     * @param temp température exterieure
     * @return renvoie la puissance consommée par les consommateurs
     */
    public abstract float PowerConsumed(double sunshine, int time, double temp);
}
