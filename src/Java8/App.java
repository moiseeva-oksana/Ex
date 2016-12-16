package Java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Оксана on 16.12.2016.
 */
public class App {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Int");
        list.add("String");
        list.add("Long");
        Collections.sort(list, Comparator.comparing(String::length));
        list.forEach(System.out::println);


        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(24, "Jack"));
        persons.add(new Person(11, "Samuel"));
        persons.add(new Person(19, "Ann"));
        Collections.sort(persons, Comparator.comparing(Person::getName));
        persons.forEach(System.out::println);

        Comparator<Person> myComparator = (p1, p2)-> p1.getName().length() - p2.getName().length();
        Collections.sort(persons,myComparator);
        System.out.println("myComparator:");
        persons.forEach(System.out::println);
    }
}
