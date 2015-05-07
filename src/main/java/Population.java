import lombok.*;

@Getter
public class Population {
    private Person[][] population;
    private float infectionProbabilityPerDay;
    private int minDays;
    private int maxDays;
    private float mortalityProbabilityPerDay;
    private int sickPeople;
}
