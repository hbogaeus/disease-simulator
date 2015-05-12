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
    public int sickDaysLeft;
    private Status status;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = Status.HEALTHY;
    }

    public void becomeSick(int sickDaysLeft) {
        this.status = Status.SICK;
        this.sickDaysLeft = sickDaysLeft;
    }

    public void becomeDead(){
        this.status = Status.DEAD;
    }

    public void becomeWell() {
        this.status = Status.IMMUNE;
    }
}
