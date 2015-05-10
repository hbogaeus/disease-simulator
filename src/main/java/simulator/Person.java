package simulator;

public class Person {
    private int x;
    private int y;
    private int daysSpentSick;
    private int maxDaySick;
    private Status status;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = Status.HEALTHY;
    }

    public void getSick(int maxDaySick) {
        this.status = Status.SICK;
        this.daysSpentSick = 0;
        this.maxDaySick = maxDaySick;
    }

    public void getWell() {
        this.status = Status.IMMUNE;
    }

    public int getMaxDaySick() {
        return maxDaySick;
    }

    public void setMaxDaySick(int maxDaySick) {
        this.maxDaySick = maxDaySick;
    }

    public int getDaysSpentSick() {
        return daysSpentSick;
    }

    public void setDaysSpentSick(int daysSpentSick) {
        this.daysSpentSick = daysSpentSick;
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
