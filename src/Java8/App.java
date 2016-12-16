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
    }
}
