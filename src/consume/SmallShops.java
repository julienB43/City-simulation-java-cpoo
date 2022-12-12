package consume;

public class SmallShops extends Consumers {
    
    /**
     * renvoie la puissance consommée par le petit commerce
     */
    public float PowerConsumed(double sunshine, int time, double temp) {
        //Petit commerce ouvert entre 8h et 19h
        if((time%1440 < 1140) && (time%1440 > 480)) {
            if(sunshine == 0) {
                return 20000; //il fait nuit ou sombre
            }
            if(temp < 16) {
                return 20000; //la température est inférieure à 16°C
            }
            if((temp < 16) && (sunshine == 0)){
                return 22000; //la température est inférieure à 16°C et il fait nuit ou sombre
            }
            return 19000; //c'est le jour ou il fait clair et il fait plus de 16°C
        }
        return 0; //la grande usine est fermé
    }
}
