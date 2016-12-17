package Core;

/**
 * Created by Оксана on 25.08.2016.
 */
public class InitializationOrder {
    static int x;
    int y;
    static{
        System.out.println("Static block");
        System.out.println("static x = "+x);
        System.out.println("_________");
    }

    {
        System.out.println("Dynamic block");
        System.out.println("dynamic y = "+y);
        System.out.println("_________");
    }
    InitializationOrder(){
        System.out.println("Constructor without args");
        System.out.println("_________");
        x=5;
    }
    InitializationOrder(String s){
        this();
        y=8;
        System.out.println(s);
        System.out.println("x = "+x);
        System.out.println("y = "+y);
        System.out.println("_________");
    }

    public static void main(String[] args) {
        InitializationOrder ex = new InitializationOrder("Constructor with String arg");
    }
}
