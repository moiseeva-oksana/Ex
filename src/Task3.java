/**
 * Created by Оксана on 26.08.2016.
 *
 * Составить программу для вычисления значений
 * функции F(x)=tg(2x)-3 на отрезке [а, b] с шагом h.
 * Результат представить в виде таблицы,
 * первый столбец которой – значения аргумента,
 * второй - соответствующие значения функции:
 */
public class Task3 {
    public static void tgFunction(double[] nums, int h){
        int resultLength = nums.length/h;
        if(nums.length%h!=0) resultLength=resultLength+1;
        double[] result=new double[resultLength];
        for(int i=0, k=0; i<nums.length; i=i+h, k++){
            double x = Math.tan(2*nums[i])-3;
            result[k]=x;
            System.out.println(nums[i]+"     "+result[k]);
        }
    }

    public static void main(String[] args) {
        double[] arr = {1.0, 5.7, 11.0, 0.0, -6.0, -87.8};
        tgFunction(arr,5);

    }
}
