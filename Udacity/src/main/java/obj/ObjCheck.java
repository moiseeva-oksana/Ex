package obj;

import java.util.ArrayList;
import java.util.List;

/**
 * Work in progress
 */
public class ObjCheck {
    public Object check() {
        List<Object> list = new ArrayList<>();
        Object result = null;
        for(int i=0; i<100_000_000; i++) {
            Object object = new Object();
           list.add(object);
            if((object.hashCode()==object.toString().hashCode())){
                result=object;
                System.out.println(i);
                break;
            }
        }
        return result;
    }
}
