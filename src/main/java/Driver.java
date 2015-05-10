import simulator.Population;
import simulator.Simulation;
import simulator.SimulationData;

import java.util.Scanner;

public class Driver {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Use default values? [y / n]");
        String answer = scanner.nextLine();

        if (answer.equals("n")){
            System.out.print("Size of population: ");
            int populationSize = scanner.nextInt();
            Population population = new Population(populationSize);

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
        }

        Population population = new Population(3);
        population.setInfectionProbabilityPerDay(1.0);
        population.setMortalityProbabilityPerDay(0.0);
        population.setMinDays(3);
        population.setMaxDays(9);
        population.placeSickPerson(0, 0);
        population.placeSickPerson(2, 2);

        scanner.close();

        Simulation simulation = new Simulation(population);
        for (int i = 0; i < simulation.totalSimulationData.size(); i++) {
            String today = "Day " + i + ": ";
            System.out.println(today + simulation.totalSimulationData.get(i).toString());
        }
    }
}
