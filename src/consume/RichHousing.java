package consume;

public class RichHousing extends Consumers {
    
    /**
     * renvoie la puissance consommée par un foyer riche
     */
    public float PowerConsumed(double sunshine, int time, double temp) {
        if(sunshine == 0) {
            return 40000; //il fait nuit ou sombre
        }
        if(temp < 16) {
            return 42000; //la température est inférieure à 16°C
        }
        if((temp < 16) && (sunshine == 0)){
            return 50000; //la température est inférieure à 16°C et il fait nuit ou sombre
        }
        return 36000; //c'est le jour ou il fait clair et il fait plus de 16°C
    }
}
