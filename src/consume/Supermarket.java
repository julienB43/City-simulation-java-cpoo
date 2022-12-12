package consume;

public class Supermarket extends Consumers {

    /**
     * renvoie la puissance consommée par un supermarché
     */
    public float PowerConsumed(double sunshine, int time, double temp) {
        //Supermarché ouvert entre 8h et 20h30
        if((time%1440 < 1230) && (time%1440 > 480)) {
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
        return 30000; //le supermarché est fermé
    }
}
