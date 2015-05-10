package simulator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private int x;
    private int y;
    public int daysSpentSick;
    public int daysToSpendSick;
    private Status status;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = Status.HEALTHY;
    }

    public void becomeSick(int maxDaySick) {
        this.status = Status.SICK;
        this.daysSpentSick = 0;
        this.daysToSpendSick = maxDaySick;
    }

    public void becomeDead(){
        this.status = Status.DEAD;
    }

    public void becomeWell() {
        this.status = Status.IMMUNE;
    }
}
