package hashtable;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ChainingTableTest {
    @Test
    public void getTest() throws Exception {
        ChainingTable table = new ChainingTable();
        String string = "Test";
        table.put(string);
        assertThat(table.get(string),is(table.getHashOfString(string)));
        assertThat(table.get("No"),is(-1));

    }

    @Test
    public void deleteTest() throws Exception {
        ChainingTable table = new ChainingTable();
        String string = "Test";
        table.put(string);
        table.delete(string);
        assertThat(table.get(string), is(-1));
    }

}