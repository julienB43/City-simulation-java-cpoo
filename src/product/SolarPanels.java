package product;

public class SolarPanels extends Producers {
    
    /**
     * renvoie la puissance produite par 1m² de panneau solaire
     */
    public double PowerProduced(double sunshine, double windSpeed) {
        return 0.2*800*sunshine; //puissance produite par 1m² de panneau photovoltaïque et dont on cosidère la rayonnement de 800W/m² et le rendement de 20%
    }
}
