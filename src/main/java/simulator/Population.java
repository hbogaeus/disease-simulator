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
        for (int i = 0; i < populationSize / 2; i++){
            for (int j = 0; j < populationSize / 2; j++){
                population[i][j] = Person.builder().x(j).y(i).status(Status.HEALTHY).build();
            }
        }
    }

    public Person[][] getPopulation() {
        return population;
    }

}
