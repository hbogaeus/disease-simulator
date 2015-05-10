package simulator;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class SimulationData {
    private int howManyGotSick;
    private int howManyDied;
    private int howManyGotWell;
    private int howManyWasSickToday;
    //@TODO Change these variable names
    private int totalPeopleSick;
    private int totalPeopleDead;
}
