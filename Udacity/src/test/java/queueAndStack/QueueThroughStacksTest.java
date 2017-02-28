package queueAndStack;

import org.junit.Before;
import org.junit.Test;
import queueAndStack.QueueThroughStacks;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class QueueThroughStacksTest {
    private QueueThroughStacks<String> queue = new QueueThroughStacks<>();
    @Before
    public void init() {
        for(int i=0; i<5; i++) {
            queue.push("element " + i);
        }
    }

    @Test
    public void pop() throws Exception {
        assertThat(queue.pop(), is("element 0"));
        assertThat(queue.pop(), is("element 1"));
        assertThat(queue.pop(), is("element 2"));
        assertThat(queue.pop(), is("element 3"));
        queue.push("Hello");
        assertThat(queue.pop(), is("element 4"));
        assertThat(queue.pop(), is("Hello"));
        queue.push("Hi");
        queue.push("Hola");
        assertThat(queue.pop(), is("Hi"));
        queue.push("Salut");
        assertThat(queue.pop(), is("Hola"));
        assertThat(queue.pop(), is("Salut"));

    }

}