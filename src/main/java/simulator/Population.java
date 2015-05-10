package simulator;

import lombok.Getter;

import java.util.Random;

@Getter
public class Population {
    private Person[][] population;
    private float infectionProbabilityPerDay;
    private float mortalityProbabilityPerDay;
    private int minDays;
    private int maxDays;
    private int sickPeople;

    public Population (int populationSize) {
        sickPeople = 0;
        population = new Person[populationSize/2][populationSize/2];
        for (int y = 0; y < populationSize / 2; y++){
            for (int x = 0; x < populationSize / 2; x++){
                this.population[x][y] = new Person(x, y);
            }
        }
    }

    public void setInfectionProbabilityPerDay(float infectionProbabilityPerDay) {
        this.infectionProbabilityPerDay = infectionProbabilityPerDay;
    }

    public void setMortalityProbabilityPerDay(float mortalityProbabilityPerDay) {
        this.mortalityProbabilityPerDay = mortalityProbabilityPerDay;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }

    public Person[][] getPopulation() {
        return population;
    }

    public Person getPersonInPopulation(int x, int y) {
        return population[x][y];
    }

    public void placeSickPerson(int x, int y) {
        Random random = new Random();
        int daysToBeSick = random.nextInt((maxDays - minDays) + 1) + minDays;

        population[x][y].getSick(daysToBeSick);
        sickPeople++;
    }

    public String toString(){

        return "infectionProbabilityPerDay: " + infectionProbabilityPerDay + "\nmortalityProbabilityPerDay: " + mortalityProbabilityPerDay + "\nminDays: " + minDays + "\nmaxDays: " + maxDays + "\nsickPeople: " + sickPeople;
    }
}

// Person.builder().y(i).x(j).status(Status.HEALTHY).build()