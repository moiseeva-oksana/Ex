package obj;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ObjCheckTest {
    public static boolean check(int num) {
        Integer integer = new Integer(num);
        return Integer.parseInt(integer.toString())==integer.hashCode();
    }
    @Test
    public void checkTest() throws Exception {
        assertThat(check(20), is(true));
        assertThat(check(1), is(true));
        assertThat(check(35667), is(true));
    }

}