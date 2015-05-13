package simulator;

public class Person {
    private int x;
    private int y;
    public int sickDaysLeft;
    private Status status;

    // Creates a new person
    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = Status.HEALTHY;
    }

    // Set status to sick, sets amount of days to be sick
    public void becomeSick(int sickDaysLeft) {
        this.status = Status.SICK;
        this.sickDaysLeft = sickDaysLeft;
    }

    /* GENERIC GETTERS AND SETTERS */

    public void becomeDead(){
        this.status = Status.DEAD;
    }

    public void becomeWell() {
        this.status = Status.IMMUNE;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSickDaysLeft() {
        return this.sickDaysLeft;
    }

    public Status getStatus() {
        return this.status;
    }

    /* GENERIC GETTERS AND SETTERS */

    // Method invoked to get a string representation of Person
    public String toString() {
        return "simulator.Person(x=" + this.getX() + ", y=" + this.getY() + ", sickDaysLeft=" + this.getSickDaysLeft() + ", status=" + this.getStatus() + ")";
    }
}
