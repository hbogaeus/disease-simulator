package simulator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Random;

@Getter
@Setter
@ToString
public class Population {
    private Person[][] population;
    private double infectionProbabilityPerDay;
    private double mortalityProbabilityPerDay;
    private int minDays;
    private int maxDays;
    public LinkedList<Person> sickPeople;

    public Population (int populationSize) {
        sickPeople = new LinkedList<>();
        population = new Person[populationSize][populationSize];
        for (int y = 0; y < populationSize; y++){
            for (int x = 0; x < populationSize; x++){
                this.population[x][y] = new Person(x, y);
            }
        }
    }

    public boolean shouldIBecomeDead() {
        return Math.random() <= mortalityProbabilityPerDay;
    }

    public boolean shouldIBecomeSick() {
        return Math.random() <= infectionProbabilityPerDay;
    }

    public Person getPersonInPopulation(int x, int y) {
        return population[x][y];
    }

    public void placeSickPerson(int x, int y) {


        getPersonInPopulation(x, y).becomeSick(daysToBeSick());
        sickPeople.addFirst(getPersonInPopulation(x, y));
    }

    public int daysToBeSick() {
        Random random = new Random();
        return random.nextInt((maxDays - minDays) + 1) + minDays;
    }

    public LinkedList<Person> getNeighbours(Person person){
        int x = person.getX();
        int y = person.getY();

        int leftBound = (x >= 1) ? x - 1 : x;
        int rightBound = (x < population.length - 1) ? x + 1 : x;
        int upperBound = (y >= 1) ? y - 1 : y;
        int lowerBound = (y < population.length - 1) ? y + 1 : y;

        LinkedList<Person> neighbours = new LinkedList<>();

        for (int rowNum = leftBound; rowNum <= rightBound; rowNum++) {
            for (int colNum = upperBound; colNum <= lowerBound; colNum++){
                neighbours.addFirst(getPersonInPopulation(colNum, rowNum));
            }
        }
        return neighbours;
    }

}