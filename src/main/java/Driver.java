import simulator.Population;
import simulator.Simulation;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Population population;

        System.out.println("Use default values? [y / n]");
        String answer = scanner.nextLine();

        // Query user for input values
        if (answer.equals("n")){
            System.out.print("Size of population: ");
            int populationSize = scanner.nextInt();
            population = new Population(populationSize);

            System.out.println("Probability of infection? (0 - 1)");
            population.setInfectionProbabilityPerDay(scanner.nextDouble());
            System.out.println("Probability of mortality? (0 - 1)");
            population.setMortalityProbabilityPerDay(scanner.nextDouble());

            System.out.println("Minimum days sick?");
            population.setMinDays(scanner.nextInt());
            System.out.println("Maximum days sick?");
            population.setMaxDays(scanner.nextInt());

            System.out.print("Amount of sick people: ");
            int sickPeople = scanner.nextInt();
            for (int i = 0; i < sickPeople; i++) {
                System.out.print("X value for sick person " + (i + 1) + ": ");
                int x = scanner.nextInt();
                System.out.print("Y value for sick person " + (i + 1) + ": ");
                int y = scanner.nextInt();
                population.placeSickPerson(x, y);
            }
        } else {
            // Default values used while evaluating the model
            population = new Population(50);
            population.setInfectionProbabilityPerDay(0.5);
            population.setMortalityProbabilityPerDay(0.0);
            population.setMinDays(3);
            population.setMaxDays(9);
            population.placeSickPerson(24, 24);
        }

        scanner.close();

        // Print input values for current simulation
        System.out.println("Infection probability: " + population.getInfectionProbabilityPerDay());
        System.out.println("Mortality probability: " + population.getMortalityProbabilityPerDay());
        System.out.println("Minimum days: " + population.getMinDays());
        System.out.println("Maximum days: " + population.getMaxDays());
        System.out.println("Sick people: " + population.getSickPeople().size());

        Simulation simulation = new Simulation(population);

        // Print SimulationData for each day
        for (int i = 0; i < simulation.totalSimulationData.size(); i++)
            System.out.println("Day "  + i + ": " + simulation.totalSimulationData.get(i).toString());

        // Print percentage of people infected by the disease
        System.out.print("Percent of population sick: " + simulation.totalSimulationData.getLast().getTotalPeopleSick() / population.getPopulation().length * 2);
    }
}
