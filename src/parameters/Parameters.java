package parameters;

public class Parameters {
    
    /**
     * Constructeur vide des paramètres
     */
    public Parameters() {
    }

    /**
     * Fonction qui renvoie la température instantanée en fonction de la période de l'année et de l'environnement
     * 
     * @param time temps de la simulation en minutes
     * @param Tmin température minimale perçue au cours de l'année
     * @param Tmax température maximale perçue au cours de l'année
     * @return renvoie la température instantanée à un temps donné
     */
    public double InstantTemperature(int time, double Tmin, double Tmax) {
        //on ajoute à une sinusoïde une incertitude aléatoire
        return (Tmin - Tmax)/2*Math.cos(time/(365*1440)*2*Math.PI) + (Tmax + Tmin)/2 + (Math.random()-1)*(Tmax - Tmin);
    }

    /**
     * Fonction qui renvoie l'ensoleillement en fonction du temps et de la météo de la ville
     * 
     * @param time tempsde la simulation en minutes
     * @param RainyDays nombres de jours pluvieux dans l'année
     * @return renvoie l'ensoillement à un temps donné
     */
    public double Sunshine(int time,double RainyDays) {
        //initialisation des levés et couchés de soleil en fonction de la période de l'année
        double Sunrise = 462 - 102*Math.cos((time/(365*1440) + 1/12)*2*Math.PI);
        double Sunset = 1191 + 105*Math.cos((time/(365*1440) + 1/12)*2*Math.PI);

        if((time%1440 > Sunset) && (time%1440 < Sunrise) && (RainyDays/365*Math.random() > 0.5)) {
            return 0; //cas dans lequel le ciel est covert ou il fait nuit
        }
        
        return 0.5 - 0.5*Math.cos((time%1440-Sunrise)/(Sunset-Sunrise)*2*Math.PI); //cas de la journée et le ciel est clair avec un maximum à 12h
    }

    /**
     * Fonction qui renvoie la vitesse du vent pour une vitesse moyenne tout en prenant compte les effets plus rare
     * 
     * @param averageSpeed vitesse moyenne du vent sur l'année
     * @return
     */
    public double WindSpeed(int averageSpeed) {
        //les rafales forte ont une probabilité plus faible d'arriver
        if (Math.random() > 0.9) {
            return averageSpeed*10; //on considère que les rafales fortes sont 10 fois plus fortes que les rafales moyennes
        }
        return averageSpeed+(Math.random()-1)*averageSpeed; //la vitesse du vent est plus ou moins amplifiée
    }
}
