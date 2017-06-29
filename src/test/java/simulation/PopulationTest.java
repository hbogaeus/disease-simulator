package simulation;

import org.junit.Before;
import org.junit.Test;
import simulator.Person;
import simulator.Population;

import static org.junit.Assert.assertTrue;

public class PopulationTest {

    Population population;
    Person[][] populationArray;

    @Before
    public void initPopulation() {
        population = new Population(3, 0);
        population.getPopulation();
    }

    @Test
    public void createPopulation() {
        assertTrue("Size of array", populationArray.length == 3);
        assertTrue("Size of array", populationArray[0].length == 3);
    }

    @Test
    public void getPersonInPopulation() {
        Person testPerson = population.getPersonInPopulation(0, 0);
        assertTrue("Person is person?",testPerson.getClass() == Person.class);
        assertTrue("Person has correct X pos", testPerson.getX() == 0);
        assertTrue("Person has correct Y pos", testPerson.getY() == 0);
    }
}
