package hashtable;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinearProbingTest {
    @Test
    public void getTest() throws Exception {
        LinearProbing linearProbing = new LinearProbing();
        String string = "Test";
        linearProbing.put(string);
        assertThat(linearProbing.get(string), is(linearProbing.getHashOfString(string)));
        assertThat(linearProbing.get("New String"), is(-1));
    }

    @Test
    public void deleteTest() throws Exception {
        LinearProbing linearProbing = new LinearProbing();
        String string = "Test";
        linearProbing.put(string);
        linearProbing.delete(string);
        assertThat(linearProbing.get(string), is(-1));
    }

}