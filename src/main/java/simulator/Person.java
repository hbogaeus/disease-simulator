package simulator;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class Person {
    private int x;
    private int y;
    private Status status;

    public Person(int x, int y, Status status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Status getStatus() {
        return status;
    }
}
