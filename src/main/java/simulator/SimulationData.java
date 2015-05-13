package simulator;

public class SimulationData {
    private int howManyGotSick;
    private int howManyDied;
    private int howManyGotWell;
    private int howManyWasSickToday;
    private int totalPeopleSick;
    private int totalPeopleDead;

    // Constructor for a SimulationData object
    public SimulationData(int howManyGotSick, int howManyDied, int howManyGotWell, int howManyWasSickToday, int totalPeopleSick, int totalPeopleDead) {
        this.howManyGotSick = howManyGotSick;
        this.howManyDied = howManyDied;
        this.howManyGotWell = howManyGotWell;
        this.howManyWasSickToday = howManyWasSickToday;
        this.totalPeopleSick = totalPeopleSick;
        this.totalPeopleDead = totalPeopleDead;
    }

    /* GENERIC GETTERS AND SETTERS */

    public int getHowManyGotSick() {
        return this.howManyGotSick;
    }

    public int getHowManyDied() {
        return this.howManyDied;
    }

    public int getHowManyGotWell() {
        return this.howManyGotWell;
    }

    public int getHowManyWasSickToday() {
        return this.howManyWasSickToday;
    }

    public int getTotalPeopleSick() {
        return this.totalPeopleSick;
    }

    public int getTotalPeopleDead() {
        return this.totalPeopleDead;
    }

    /* GENERIC GETTERS AND SETTERS */

    // Method invoked to get a string representation of SimulationData
    public String toString() {
        return "simulator.SimulationData(howManyGotSick=" + this.getHowManyGotSick() + ", howManyDied=" + this.getHowManyDied() + ", howManyGotWell=" + this.getHowManyGotWell() + ", howManyWasSickToday=" + this.getHowManyWasSickToday() + ", totalPeopleSick=" + this.getTotalPeopleSick() + ", totalPeopleDead=" + this.getTotalPeopleDead() + ")";
    }


}
