package Core;

/**
 * Created by Оксана on 26.08.2016.
 */
public class Task2 {
    public static void getMin(int n, double e){
    int minIndex = 1;
    for(int i=0; i<n; i++){
        double c = 1/Math.pow((i+1), 2);
        System.out.println(i+1 +"     "+ c);
        if(c>e) minIndex++;

    }
        System.out.println("min i = " + minIndex);

    }

    public static void main(String[] args) {
        getMin(50, 0.0005);
    }
}
