package consume;

public class BigFactories extends Consumers{

    /**
     * renvoie la puissance consommée par une grande usine
     */
    public float PowerConsumed(double sunshine, int time, double temp) {
        //Grande usine ouverte entre 6h et 18h
        if((time%1440 < 1080) && (time%1440 > 360)) {
            if(sunshine == 0) {
                return 180000; //il fait nuit ou sombre
            }
            if(temp < 16) {
                return 200000; //la température est inférieure à 16°C
            }
            if((temp < 16) && (sunshine == 0)){
                return 210000; //la température est inférieure à 16°C et il fait nuit ou sombre
            }
            return 170000; //c'est le jour ou il fait clair et il fait plus de 16°C
        }
        return 10000; //la grande usine est fermé
    }
}
