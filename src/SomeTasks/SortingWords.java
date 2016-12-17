package SomeTasks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Оксана on 17.12.2016.
 */
public class SortingWords {
    public static void main(String[] args) {
        sortWordsByLength("Java is good. Very interesting");
    }

    public static void sortWordsByLength(String str){
        List<String> words = Arrays.asList(str.split(" "));
        Collections.sort(words, Comparator.comparing(String::length));
        words.forEach(System.out::println);
    }
}
