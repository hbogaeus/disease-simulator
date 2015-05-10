package simulation;

import org.junit.Before;
import org.junit.Test;
import simulator.Person;
import simulator.Population;

import static org.junit.Assert.*;

public class PopulationTest {

    Population population = new Population(20);

    @Test
    public void createPopulation() {
        assertTrue(population.getPopulation().length  > 0);
    }

    @Test
    public void getPersonInPopulation() {
        Person testPerson = population.getPersonInPopulation(0, 0);
        assertTrue("Person is person?",testPerson.getClass() == Person.class);
        assertTrue("Person has correct X pos", testPerson.getX() == 0);
        assertTrue("Person has correct Y pos", testPerson.getY() == 0);
    }
}
