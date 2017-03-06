package obj;

public class ObjCheck {
    public boolean check(int num) {
        Integer integer = new Integer(num);
        return Integer.parseInt(integer.toString())==integer.hashCode();
    }
}
