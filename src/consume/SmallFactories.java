package consume;

public class SmallFactories extends Consumers {
    
    /**
     * renvoie la puissance consommée par la petite usine/bureau
     */
    public float PowerConsumed(double sunshine, int time, double temp) {
        //Petite usine/bureau ouvert entre 6h et 20h
        if((time%1440 < 1200) && (time%1440 > 360)) {
            if(sunshine == 0) {
                return 50000; //il fait nuit ou sombre
            }
            if(temp < 16) {
                return 52000; //la température est inférieure à 16°C
            }
            if((temp < 16) && (sunshine == 0)){
                return 56000; //la température est inférieure à 16°C et il fait nuit ou sombre
            }
            return 46000; //c'est le jour ou il fait clair et il fait plus de 16°C
        }
        return 0; //la petite usine/bureau est fermé
    }
}
