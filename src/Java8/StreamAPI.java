package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Оксана on 16.12.2016.
 */
public class StreamAPI {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Int");
        list.add("String");
        list.add("Long");
        list.add("Big Integer");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        list.stream().filter(s -> s.charAt(0)=='L').map(s -> s+"END").forEach(System.out::println);
        Object[] arr = list.stream().filter(s -> s.charAt(0)=='L').map(s -> s+"END").toArray();
        System.out.println(arr[0]);

        Optional<String> result = list.stream().findFirst();
        System.out.println(result.get());

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> summ = nums.stream().reduce((x,y)-> x+y);
        System.out.println(summ.get());
    }
}
