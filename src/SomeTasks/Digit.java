package SomeTasks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Оксана on 18.12.2016.
 */
public class Digit {
    int shift =0;
    public static void main(String[] args) {
      getDigitals(3456789).forEach(System.out::println);
    }
    public static List<Integer> getDigitals(int x) {
        List<Integer> result = new ArrayList<>();
        Digit digit = new Digit();
        while (x>10) {
            int first = digit.getFirst(x);
            result.add(first);
            x = (int) (x-Math.round(Math.pow(10, digit.shift))*first);
            digit.shift=0;
        }
        result.add(x);
        return result;
    }

    public int getFirst(int x) {
        int digit = x;
        while (digit > 10) {
            digit /= 10;
            this.shift++;
        }
        return digit;
    }
}
