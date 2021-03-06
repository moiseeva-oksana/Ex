package Core;

/**
 * Created by Оксана on 25.08.2016.
 */
public class NullExample {

    public static void someMethod(A a){
        System.out.println("Core.A");
    }

    public static void someMethod(B b){
        System.out.println("Core.B");
    }

    public static void someMethod(C c){
        System.out.println("Core.C");
    }

    public static void main(String[] args) {
        A a = new A();
        someMethod(a);

        B b = new B();
        someMethod(b);

        C c = new C();
        someMethod(c);

        System.out.println("someMethod for null:");
        someMethod(null);
    }
}
