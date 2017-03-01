package recursive;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class FibTest {
    @Test
    public void get_fib() throws Exception {
        assertThat(Fib.get_fib(6), is(8));
        assertThat(Fib.get_fib(9), is(34));
    }

}