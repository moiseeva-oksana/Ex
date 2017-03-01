package recursive;


public class Fib {
    public static int get_fib(int position) {
        if(position==0) {
            return 0;
        }
        if (position==1) {
            return 1;
        }
        return get_fib(position-1)+get_fib(position-2);
    }
}
