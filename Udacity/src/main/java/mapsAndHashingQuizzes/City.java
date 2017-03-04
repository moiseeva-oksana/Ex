package mapsAndHashingQuizzes;

import java.util.*;

public class City {
    private Map<String, String> countries = new HashMap<>();
    private Map<String, String> cities = new HashMap<>();

    public City() {
        countries.put("India", "Asia");
        countries.put("USA", "North America");
        countries.put("Egypt", "Africa");
        countries.put("China", "Asia");

        cities.put("Bangalore","India");
        cities.put("Atlanta","USA");
        cities.put("Mountain View","USA");
        cities.put("Cairo","Egypt");
        cities.put("Shanghai","China");

    }

    public Set<String> allUSACities() {
        Set<String> result = new TreeSet<>();
        for (Map.Entry<String, String> entry : cities.entrySet()) {
            if(entry.getValue().equals("USA")) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public Set<String> citiesInAsia() {
        Set<String> result = new TreeSet<>();
        for (Map.Entry<String, String> city : cities.entrySet()) {
            if(countries.get(city.getValue()).equals("Asia")) {
                result.add(city.getKey());
            }
        }
        return result;
    }
}
