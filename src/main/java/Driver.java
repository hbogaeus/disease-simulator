import simulator.*;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Population population = null;
        String inputAnswer = "";
        String outputAnswer = "";


        while (!inputAnswer.equals("n") && !inputAnswer.equals("y")) {
            System.out.println("Use default input values? [y / n]");
            inputAnswer = scanner.nextLine();

            // Query user for input values
            if (inputAnswer.equals("n")){
                System.out.print("Size of population: ");
                int populationSize = scanner.nextInt();
                population = new Population(populationSize, 0);

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
            } else if (inputAnswer.equals("y")) {
                // Default values used while evaluating the model
                population = new Population(50, 0);
                population.setInfectionProbabilityPerDay(0.05);
                population.setMortalityProbabilityPerDay(0.0);
                population.setMinDays(3);
                population.setMaxDays(9);
                population.placeSickPerson(24, 24);
            }
        }

        boolean showDailyInfected = false;
        boolean showDailyDead = false;
        boolean showDailyRecovered = false;
        boolean showDailySick = false;
        boolean showTotalInfected = false;
        boolean showTotalDead = false;
        boolean showFinalMap = false;


        while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
            System.out.println("Use default output values? [y / n]");
            outputAnswer = scanner.nextLine();

            // Query user for input values
            if (outputAnswer.equals("n")){
                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show daily infected? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showDailyInfected = false;
                    else if (outputAnswer.equals("y"))
                        showDailyInfected = true;
                }

                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show daily deceased? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showDailyDead = false;
                    else if (outputAnswer.equals("y"))
                        showDailyDead = true;
                }

                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show daily recovered? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showDailyRecovered = false;
                    else if (outputAnswer.equals("y"))
                        showDailyRecovered = true;
                }

                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show daily sick? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showDailySick = false;
                    else if (outputAnswer.equals("y"))
                        showDailySick = true;
                }

                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show total sick? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showTotalInfected = false;
                    else if (outputAnswer.equals("y"))
                        showTotalInfected = true;
                }

                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show total deceased? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showTotalDead = false;
                    else if (outputAnswer.equals("y"))
                        showTotalDead = true;
                }

                outputAnswer = "";
                while (!outputAnswer.equals("n") && !outputAnswer.equals("y")) {
                    System.out.println("Show ASCII map of final day? [y / n]");
                    outputAnswer = scanner.nextLine();
                    if (outputAnswer.equals("n"))
                        showFinalMap = false;
                    else if (outputAnswer.equals("y"))
                        showFinalMap = true;
                }

            } else if (outputAnswer.equals("y")) {
                // Default values used for output
                showDailyInfected = true;
                showDailyDead = true;
                showDailyRecovered = true;
                showDailySick = true;
                showTotalInfected = true;
                showTotalDead = true;
                showFinalMap = true;
            }
        }

        scanner.close();

        // Print input values for current simulation
        System.out.println("\nSettings for this simulation");
        System.out.println(String.format("%-22s %.2f", "Infection probability:", population.getInfectionProbabilityPerDay()));
        System.out.println(String.format("%-22s %.2f", "Mortality probability:", population.getMortalityProbabilityPerDay()));
        System.out.println(String.format("%-22s %d" ,"Minimum days:", population.getMinDays()));
        System.out.println(String.format("%-22s %d" ,"Maximum days:", population.getMaxDays()));
        System.out.println(String.format("%-22s %d\n" ,"Number of sick people:", population.getSickPeople().size()));


        Simulation simulation = new Simulation(population);

        // Print SimulationData for each day
        if (showDailyInfected || showDailyDead || showDailyRecovered || showDailySick || showTotalInfected || showTotalDead) {
            for (int i = 0; i < simulation.totalSimulationData.size(); i++) {
                SimulationData simulationData = simulation.totalSimulationData.get(i);
                StringBuilder output = new StringBuilder(String.format("[Day %3d]", i));

                if (showDailyInfected){
                    output.append(String.format(" Infected today: %-3d", simulationData.getHowManyGotSick()));
                }
                if (showDailyDead) {
                    output.append(String.format(" Deceased today: %-3d", simulationData.getHowManyDied()));
                }
                if (showDailyRecovered) {
                    output.append(String.format(" Recovered today: %-3d", simulationData.getHowManyGotWell()));
                }
                if (showDailySick) {
                    output.append(String.format(" Sick today: %-3d", simulationData.getHowManyWasSickToday()));
                }
                if (showTotalInfected) {
                    output.append(String.format(" Total sick: %-4d", simulationData.getTotalPeopleSick()));
                }
                if (showTotalDead) {
                    output.append(String.format(" Total deceased: %-4d", simulationData.getTotalPeopleDead()));
                }

                System.out.println(output.toString());
            }
        }

        if (showFinalMap) {
            // Print ASCII map of the last day of the simulation
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < population.getPopulation().length; i++) {
                for (int j = 0; j < population.getPopulation().length; j++) {
                    Person person = population.getPersonInPopulation(j, i);
                    if (person.getStatus() == Status.IMMUNE) {
                        stringBuilder.append("I");
                    } else if (person.getStatus() == Status.DEAD) {
                        stringBuilder.append("D");
                    } else if (person.getStatus() == Status.SICK) {
                        stringBuilder.append("S");
                    } else {
                        stringBuilder.append("H");
                    }
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString());
        }
    }

    public static double drive(double infectionRate, int seed) {
        Population population = new Population(50, seed);
        population.setInfectionProbabilityPerDay(infectionRate);
        population.setMortalityProbabilityPerDay(0.0);
        population.setMinDays(3);
        population.setMaxDays(9);
        population.placeSickPerson(24, 24);

        Simulation simulation = new Simulation(population);
        SimulationData simulationData = simulation.totalSimulationData.get(simulation.totalSimulationData.size() - 1);
        return simulationData.getTotalPeopleSick();

    }
}
