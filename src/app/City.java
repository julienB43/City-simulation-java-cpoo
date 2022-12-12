package app;

import java.util.ArrayList;

import consume.BigFactories;
import consume.Consumers;
import consume.ModerateHousing;
import consume.PoorHousing;
import consume.RichHousing;
import consume.SmallFactories;
import consume.SmallShops;
import consume.Supermarket;
import product.CoalPowerplants;
import product.HydroelectricPowerplants;
import product.NuclearPowerplants;
import product.Producers;
import product.SolarPanels;
import product.WindTurbines;

public class City {

    private ArrayList<Consumers> consumers;
    private ArrayList<Producers> producers;

    /**
     * constructeur ville avec les différents producterus et consommateurs et leur nombre
     */
    public City() {
        consumers = new ArrayList<Consumers>();
        producers = new ArrayList<Producers>();

        for(int i = 0; i < 2; i++) {
            consumers.add(new BigFactories());
        }
        for(int i = 0; i < 5000; i++) {
            consumers.add(new ModerateHousing());
        }
        for(int i = 0; i < 1000; i++) {
            consumers.add(new PoorHousing());
        }
        for(int i = 0; i < 200; i++) {
            consumers.add(new RichHousing());
        }
        for(int i = 0; i < 30; i++) {
            consumers.add(new SmallFactories());
        }
        for(int i = 0; i < 50; i++) {
            consumers.add(new SmallShops());
        }
        for(int i = 0; i < 3; i++) {
            consumers.add(new Supermarket());
        }

        for(int i = 0; i < 1; i++) {
            producers.add(new NuclearPowerplants());
        }
        for(int i = 0; i < 2; i++) {
            producers.add(new CoalPowerplants());
        }
        for(int i = 0; i < 200; i++) {
            producers.add(new SolarPanels());
        }
        for(int i = 0; i < 10; i++) {
            producers.add(new WindTurbines());
        }
        for(int i = 0; i < 5; i++) {
            producers.add(new HydroelectricPowerplants());
        }
    }
    
    /**
     * Fonction qui somme les puissance consommée de tout les consommateurs
     * 
     * @param sunshine pourcentage d'ensoleillement
     * @param time temps de la simulation en minutes
     * @param temp température extérieure
     * @return renvoie la puissance totale consommée de la ville
     */
    public double PowerConsumers(double sunshine, int time, double temp) {
        double sumCons = 0;
        for(int i = 0; i < consumers.size(); i++) {
            
            sumCons = sumCons + consumers.get(i).PowerConsumed(sunshine, time, temp);
        }
        return sumCons;
    }

    /**
     * Fonction qui somme les puissance produite de tout les producteurs
     * 
     * @param sunshine pourcentage d'ensoleillement
     * @param windSpeed vitesse du vent (en m/s)
     * @return renvoie la puissance totale produite de la ville
     */
    public double PowerProducers(double sunshine, double windSpeed) {
        double sumProd = 0;
        for(int i = 0; i < producers.size(); i++) {
            sumProd = sumProd + producers.get(i).PowerProduced(sunshine, windSpeed);
        }
        return sumProd;
    }
}
