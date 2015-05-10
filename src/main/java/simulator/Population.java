package simulator;

import lombok.Getter;

@Getter
public class Population {
    private Person[][] population;
    private float infectionProbabilityPerDay;
    private int minDays;
    private int maxDays;
    private float mortalityProbabilityPerDay;
    private int sickPeople;

    public Population (int populationSize) {
        population = new Person[populationSize/2][populationSize/2];
        for (int i = 0; i < populationSize / 2; i++){
            for (int j = 0; j < populationSize / 2; j++){
                this.population[i][j] = Person.builder().y(i).x(j).status(Status.HEALTHY).build();
            }
        }
    }

    public Person[][] getPopulation() {
        return population;
    }

    public Person getPersonInPopulation(int x, int y) {
        return population[x][y];
    }

}
