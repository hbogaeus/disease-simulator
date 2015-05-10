import simulator.Population;

import java.util.Scanner;

public class Driver {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many people?");
        int populationSize = scanner.nextInt();
        Population population = new Population(populationSize);
        System.out.println("How many sick people?");
        int sickPeople = scanner.nextInt();
        for (int i = 0; i < sickPeople; i++) {
            System.out.print("X value for sick person " + (i + 1) + ": ");
            int x = scanner.nextInt();
            System.out.print("Y value for sick person " + (i + 1) + ": ");
            int y = scanner.nextInt();
            population.placeSickPerson(x, y);
        }
        System.out.println("Probability of infection? (0 - 1)");
        population.setInfectionProbabilityPerDay(scanner.nextFloat());
        System.out.println("Probability of mortality? (0 - 1)");
        population.setMortalityProbabilityPerDay(scanner.nextFloat());

        System.out.println("Minimum days sick?");
        population.setMinDays(scanner.nextInt());
        System.out.println("Maximum days sick?");
        population.setMaxDays(scanner.nextInt());
        System.out.println(population.toString());
    }
}
