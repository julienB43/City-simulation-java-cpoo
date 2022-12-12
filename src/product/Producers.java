package product;

public abstract class Producers {

    /**
     * Fonction qui renvoie la puissance consommée par les producteurs
     * 
     * @param sunshine pourcentage d'ensoleillement
     * @param windSpeed vitesse du vent (en m/s)
     * @return renvoie la puissance produite par les producteurs
     */
    public abstract double PowerProduced(double sunshine, double windSpeed);
}
