package mapsAndHashingQuizzes;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CityTest {
    City city = new City();
    @Test
    public void allUSACities() throws Exception {
        Set<String> expected = new HashSet<>();
        expected.add("Atlanta");
        expected.add("Mountain View");
        assertEquals(city.allUSACities(), expected);
    }

    @Test
    public void citiesInAsia() throws Exception {
        Set<String> expected = new HashSet<>();
        expected.add("Bangalore");
        expected.add("Shanghai");
        assertEquals(city.citiesInAsia(), expected);
    }

}