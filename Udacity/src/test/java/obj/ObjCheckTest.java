package obj;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ObjCheckTest {
    @Test
    public void checkTest() throws Exception {
        assertThat(new ObjCheck().check(20), is(true));
        assertThat(new ObjCheck().check(1), is(true));
        assertThat(new ObjCheck().check(35667), is(true));
    }

}