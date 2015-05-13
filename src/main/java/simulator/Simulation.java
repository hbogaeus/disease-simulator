package simulator;

import java.util.LinkedList;

public class Simulation {

    // LinkedList containing all SimulationData-objects for all days
    public LinkedList<SimulationData> totalSimulationData;

    // Initalizes simulation
    public Simulation(Population population) {
        totalSimulationData = new LinkedList<>();
        LinkedList<Person> auxSickPeople = new LinkedList<>();
        LinkedList<Person> upForRemoval = new LinkedList<>();
        int totalPeopleDead = 0;
        int totalPeopleSick = population.sickPeople.size();
        int howManyDied = 0;
        int howManyGotWell = 0;
        int howManyGotSick = 0;
        int howManyWasSickToday = population.sickPeople.size();

        // Simulation data for day 0 (init day)
        totalSimulationData.addLast(new SimulationData(
                howManyGotSick,
                howManyDied,
                howManyGotWell,
                howManyWasSickToday,
                totalPeopleSick,
                totalPeopleDead
        ));

        // Continue while there are sick people
        while (population.sickPeople.size() > 0){

            // Start of day

            for (Person sickPerson : population.sickPeople){
                // Every sick person has a risk of dying every day
                if (population.shouldIBecomeDead()) {
                    sickPerson.becomeDead();
                    upForRemoval.addLast(sickPerson);
                    howManyDied++;
                    continue;
                }

                // If they didn't die, they will have spent another day sick
                sickPerson.sickDaysLeft--;

                // Time to get well!
                if (sickPerson.sickDaysLeft <= 0){
                    sickPerson.becomeWell();
                    upForRemoval.addLast(sickPerson);
                    howManyGotWell++;
                    continue;
                }

                // Fetches neighbours for Person under inspection
                LinkedList<Person> neighbours = population.getNeighbours(sickPerson);

                // All neighbours have the same risk of becoming infected
                for (Person neighbour : neighbours) {
                    if (neighbour.getStatus() == Status.HEALTHY && population.shouldIBecomeSick()){
                        neighbour.becomeSick(population.daysToBeSick());
                        auxSickPeople.addFirst(neighbour);
                    }
                }
            }

            // Auxiliary list for removing people from sickPeople list
            // Can't remove people from sickPeople list while iterating over it
            for (Person person : upForRemoval) {
                population.sickPeople.remove(person);
            }

            // Day is over!
            // Remove people who have either died or gotten well
            population.sickPeople.addAll(auxSickPeople);

            // Fix variables for data collection
            howManyGotSick = auxSickPeople.size();
            totalPeopleDead += howManyDied;
            totalPeopleSick += howManyGotSick;

            howManyWasSickToday = population.sickPeople.size();

            // Create SimulationData-object
            totalSimulationData.addLast(new SimulationData(
                    howManyGotSick,
                    howManyDied,
                    howManyGotWell,
                    howManyWasSickToday,
                    totalPeopleSick,
                    totalPeopleDead
            ));

            // Clear local variables for next day
            auxSickPeople.clear();
            upForRemoval.clear();
            howManyDied = 0;
        }
    }
}
