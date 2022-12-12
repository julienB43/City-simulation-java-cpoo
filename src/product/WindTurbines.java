package product;

public class WindTurbines extends Producers {
    
    /**
     * renvoie la puissance produite par une éolienne
     */
    public double PowerProduced(double sunshine, double windSpeed) {
        //si la vitesse du vent est supérieure à 33m/s alors les éolienne ne fonctionnent plus pour la sécurité
        if(windSpeed > 33.0) {
            return 0;
        }
        return windSpeed*60*2/3; //puissance d'une éolienne en ramenant sur le parc éolien total que l'on considère à 2/3 actif et dont les pales ont une surface de 60m²
    }
}
