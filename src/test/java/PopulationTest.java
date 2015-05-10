import org.junit.Test;
import simulator.Population;

import static org.junit.Assert.*;


public class PopulationTest {

    @Test
    public void createPopulation() {
        Population population = new Population(20);
        assertTrue(population.getPopulation().length  > 0);
    }
}
