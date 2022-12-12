package app;

import java.io.FileWriter;
import java.io.IOException;

import parameters.Parameters;

public class Simulation {
    public static void main(String[] args) {
        
        int scenario = 1; //nombre choisi entre 1 (scénario en minutes sur 1 jour) et 2 (scénario en jours sur l'année)
        int Day = 0; //jour de l'année (O correspondant au 1er Janvier de l'année)
        int averageSpeed = 10; //vitesse moyenne du vent tout au long de l'année
        double Tmin = -2; //température minimale moyenne
        double Tmax = 32.5; //température maximale moyenne
        double RainyDays = 130; //nombre de jours pluvieux dans l'année

        City city = new City(); //ville simulée
        Parameters parameters = new Parameters(); //paramètres météo de la ville

        double PowerProducedSinceBeginning = 0;
        double PowerConsumedSinceBeginning = 0;
        
        /************************************************************************************************
         * Le premier scénario renvoie le rapport .csv dans le dossier report                           *
         * Ce fichier contient le rapport de simulation en minute sur une journée pour le jour donné    *
        *************************************************************************************************/

        if(scenario == 1) {
            try {
                FileWriter Sim = new FileWriter("src/report/SimuationOfDay.csv"); //création du nouveau fichier
                System.out.println("Begining of the simulation of a day"); //message de début de simulation dans le terminal

                for (int min = 0; min < 1440; min++) {
                    //paramètres de base initialisés sur l'instant
                    double temp = parameters.InstantTemperature(min + Day*1440, Tmin, Tmax);
                    double windSpeed = parameters.WindSpeed(averageSpeed);
                    double sunshine = parameters.Sunshine(min + Day*1440, RainyDays);

                    //puissance produites et consommées determinées
                    double PowerProduced = city.PowerProducers(sunshine, windSpeed);
                    double PowerConsumed = city.PowerConsumers(sunshine, min + Day*1440, temp);

                    //energie emmagasinée depuis le début de la simulation
                    PowerProducedSinceBeginning += PowerProduced/60;
                    PowerConsumedSinceBeginning += PowerConsumed/60;

                    //écriture dans le fichier 
                    Sim.write(min + ";" + PowerConsumed + ";" + PowerProduced + ";" + PowerConsumedSinceBeginning + ";" + PowerProducedSinceBeginning + "\n");
                }

                Sim.close(); //fermeture du fichier .csv
            }

            catch (IOException e) {
                System.out.println("The file do not open"); //message d'erreur de simulation dans le terminal
            }
            
            System.out.println("End of the simulation"); //message de fin de simulation dans le terminal
        }

        /************************************************************************************************
         * Le second scénario renvoie le rapport .csv dans le dossier report                            *
         * Ce fichier contient le rapport de simulation en jour sur une année à partir du jour donné    *
        *************************************************************************************************/

        if(scenario == 2) {
            try {
                FileWriter Sim = new FileWriter("src/report/SimuationOfYear.csv"); //création du nouveau fichier
                System.out.println("Begining of the simulation of the year"); //message de début de simulation dans le terminal

                for (int day = 0; day < 365; day++) {
                    //paramètres de base initialisés sur l'instant
                    double temp = parameters.InstantTemperature((day + Day)*1440, Tmin, Tmax);
                    double windSpeed = parameters.WindSpeed(averageSpeed);
                    double sunshine = parameters.Sunshine((day + Day)*1440, RainyDays);

                    //puissance produites et consommées determinées
                    double PowerProduced = city.PowerProducers(sunshine, windSpeed);
                    double PowerConsumed = city.PowerConsumers(sunshine, (day + Day)*1440, temp);

                    //energie emmagasinée depuis le début de la simulation
                    PowerProducedSinceBeginning += PowerProduced*24;
                    PowerConsumedSinceBeginning += PowerConsumed*24;

                    //écriture dans le fichier 
                    Sim.write(day + ";" + PowerConsumed + ";" + PowerProduced + ";" + PowerConsumedSinceBeginning + ";" + PowerProducedSinceBeginning + "\n");
                }

                Sim.close(); //fermeture du fichier .csv
            }

            catch (IOException e) {
                System.out.println("The file do not open"); //message d'erreur de simulation dans le terminal
            }
            
            System.out.println("End of the simulation"); //message de fin de simulation dans le terminal
        }
    }
}
