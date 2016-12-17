package SomeTasks;

import java.util.Arrays;

/**
 * Created by Оксана on 17.12.2016.
 */
public class SortingChars {
    public static void main(String[] args) {
        System.out.println(sortCharsInString("Oksana"));
    }

    public static String sortCharsInString(String str){
        char[] arr = str.toLowerCase().toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
