package SomeTasks.fractions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Oksana on 18.12.2016.
 */
public class FractionHelper {
    public static int NOD(int x, int y) {
        List<Integer> dividersX = getDividers(x);
        List<Integer> dividersY = getDividers(y);

        dividersY.retainAll(dividersX);
        return Collections.max(dividersY);
    }

    public static List<Integer> getDividers(int x) {
        ArrayList<Integer> dividers = new ArrayList<>();
        dividers.add(1);
        for (int i=2; i<=x/2; i++){
            if(x%i==0) dividers.add(i);
        }
        dividers.add(x);
        return dividers;
    }

    public static int[] getPAndQFromString(String str) {
        if(isStringValid(str)) {
            String[] arr = str.split("/");
            return new int[]{Integer.parseInt(arr[0]), Integer.parseInt(arr[1])};
        }
       else return new int[0];
    }

    public static boolean isStringValid(String str) {
       return str.matches("\\d+/\\d+");
    }
}
