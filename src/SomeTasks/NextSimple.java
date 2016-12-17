package SomeTasks;

/**
 * Created by Оксана on 17.12.2016.
 */
public class NextSimple {
    public static void main(String[] args) {
        System.out.println(nextSimpleInt(800));
    }
    public static int nextSimpleInt(int x) {
        int result=0;
        while (result==0){
            int next=++x;
            if(isSimple(next)){
                result=next;
            }
        }
        return result;
    }

    public static boolean isSimple(int x) {
        for(int i=2; i<=Math.round(Math.sqrt(x)); i++) {
            if(x%i==0) return false;
        }
        return true;
    }
}
