package consume;

public class PoorHousing extends Consumers {
    
    /**
     * renvoie la puissance consommée par un foyer pauvre
     */
    public float PowerConsumed(double sunshine, int time, double temp) {
        if(sunshine == 0) {
            return 22000; //il fait nuit ou sombre
        }
        if(temp < 16) {
            return 24000; //la température est inférieure à 16°C
        }
        if((temp < 16) && (sunshine == 0)){
            return 26000; //la température est inférieure à 16°C et il fait nuit ou sombre
        }
        return 20000; //c'est le jour ou il fait clair et il fait plus de 16°C
    }
}
