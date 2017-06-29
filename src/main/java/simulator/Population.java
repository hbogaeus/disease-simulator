package simulator;

import java.util.LinkedList;
import java.util.Random;

public class Population {
    private Person[][] population;
    private double infectionProbabilityPerDay;
    private double mortalityProbabilityPerDay;
    private int minDays;
    private int maxDays;
    public LinkedList<Person> sickPeople;
    Random rand;

    // Creates a new population based on input and initializes sickPeople list
    public Population (int populationSize, int seed) {
        sickPeople = new LinkedList<>();
        population = new Person[populationSize][populationSize];
        if (seed == 0) rand = new Random();
        else if (seed > 0) rand = new Random(seed);
        for (int y = 0; y < populationSize; y++){
            for (int x = 0; x < populationSize; x++){
                this.population[x][y] = new Person(x, y);
            }
        }
    }

    // Returns whether Person under inspection should die or not
    public boolean shouldIBecomeDead() {
        return rand.nextDouble() <= mortalityProbabilityPerDay;
    }

    // Returns whether Person under inspection should get sick or not
    public boolean shouldIBecomeSick() {
        return rand.nextDouble() <= infectionProbabilityPerDay;
    }

    public Person getPersonInPopulation(int x, int y) {
        return population[x][y];
    }

    // Only used when initializing simulation
    public void placeSickPerson(int x, int y) {
        getPersonInPopulation(x, y).becomeSick(daysToBeSick());
        sickPeople.addFirst(getPersonInPopulation(x, y));
    }

    public int daysToBeSick() {
        return rand.nextInt((maxDays - minDays) + 1) + minDays;
    }

    // Inspect bounds of Person in grid, return bounds for all four directions
    // Bounds must be found to ensure no OOB exceptions
    // Based on the bounds, iterate and find neighbours for given Person
    public LinkedList<Person> getNeighbours(Person person){
        int x = person.getX();
        int y = person.getY();


        // Minimized if-else statements
        int leftBound = (x >= 1) ? x - 1 : x;
        int rightBound = (x < population.length - 1) ? x + 1 : x;
        int upperBound = (y >= 1) ? y - 1 : y;
        int lowerBound = (y < population.length - 1) ? y + 1 : y;

        // List containing neighbours
        LinkedList<Person> neighbours = new LinkedList<>();

        // Add neighbours to list
        for (int rowNum = leftBound; rowNum <= rightBound; rowNum++) {
            for (int colNum = upperBound; colNum <= lowerBound; colNum++){
                neighbours.addFirst(getPersonInPopulation(colNum, rowNum));
            }
        }
        return neighbours;
    }

    // Returns two-dimensional array (entire population)
    public Person[][] getPopulation() {
        return this.population;
    }

    /* GENERIC GETTERS AND SETTERS */

    public double getInfectionProbabilityPerDay() {
        return this.infectionProbabilityPerDay;
    }

    public double getMortalityProbabilityPerDay() {
        return this.mortalityProbabilityPerDay;
    }

    public int getMinDays() {
        return this.minDays;
    }

    public int getMaxDays() {
        return this.maxDays;
    }

    public LinkedList<Person> getSickPeople() {
        return this.sickPeople;
    }

    public void setInfectionProbabilityPerDay(double infectionProbabilityPerDay) {
        this.infectionProbabilityPerDay = infectionProbabilityPerDay;
    }

    public void setMortalityProbabilityPerDay(double mortalityProbabilityPerDay) {
        this.mortalityProbabilityPerDay = mortalityProbabilityPerDay;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    /* GENERIC GETTERS AND SETTERS */

    // Method invoked to get a string representation of Population
    public String toString() {
        return "simulator.Population(population=" + java.util.Arrays.deepToString(this.getPopulation()) + ", infectionProbabilityPerDay=" + this.getInfectionProbabilityPerDay() + ", mortalityProbabilityPerDay=" + this.getMortalityProbabilityPerDay() + ", minDays=" + this.getMinDays() + ", maxDays=" + this.getMaxDays() + ", sickPeople=" + this.getSickPeople() + ")";
    }
}