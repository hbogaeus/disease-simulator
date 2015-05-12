package simulator;

import java.util.LinkedList;

public class Simulation {

    public LinkedList<SimulationData> totalSimulationData;

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

        totalSimulationData.addLast(new SimulationData(
                howManyGotSick,
                howManyDied,
                howManyGotWell,
                howManyWasSickToday,
                totalPeopleSick,
                totalPeopleDead
        ));

        while (population.sickPeople.size() > 0){

            // Start of day

            for (Person sickPerson : population.sickPeople){
                if (population.shouldIBecomeDead()) {
                    sickPerson.becomeDead();
                    upForRemoval.addLast(sickPerson);
                    howManyDied++;
                    continue;
                }
                sickPerson.sickDaysLeft--;

                if (sickPerson.sickDaysLeft <= 0){
                    sickPerson.becomeWell();
                    upForRemoval.addLast(sickPerson);
                    howManyGotWell++;
                    continue;
                }

                LinkedList<Person> neighbours = population.getNeighbours(sickPerson);

                for (Person neighbour : neighbours) {
                    if (neighbour.getStatus() == Status.HEALTHY && population.shouldIBecomeSick()){
                        neighbour.becomeSick(population.daysToBeSick());
                        auxSickPeople.addFirst(neighbour);
                    }
                }
            }
            for (Person person : upForRemoval) {
                population.sickPeople.remove(person);
            }

            // Day is over!
            population.sickPeople.addAll(auxSickPeople);

            howManyGotSick = auxSickPeople.size();
            totalPeopleDead += howManyDied;
            totalPeopleSick += howManyGotSick;

            howManyWasSickToday = population.sickPeople.size();

            totalSimulationData.addLast(new SimulationData(
                    howManyGotSick,
                    howManyDied,
                    howManyGotWell,
                    howManyWasSickToday,
                    totalPeopleSick,
                    totalPeopleDead
            ));



            auxSickPeople.clear();
            upForRemoval.clear();
            howManyDied = 0;
        }
    }
}
