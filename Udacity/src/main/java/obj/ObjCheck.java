package obj;

import java.util.ArrayList;
import java.util.List;

public class ObjCheck {
    public Object check() {
        List<Object> list = new ArrayList<>();
        Object result = null;
        for(int i=0; i<100_000_000; i++) {
            Object object = new Object();
           list.add(object);
            if(String.valueOf(object.hashCode()).equals(object.toString())){
                result=object;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ObjCheck().check());
    }
}
