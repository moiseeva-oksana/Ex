package queueAndStack;

import org.junit.Before;
import org.junit.Test;
import queueAndStack.QueueThroughStacks;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class QueueThroughStacksTest {
    QueueThroughStacks<String> queue = new QueueThroughStacks<>();
    @Before
    public void init() {
        for(int i=0; i<10; i++) {
            queue.push("element " + i);
        }
    }

    @Test
    public void pop() throws Exception {
        assertThat(queue.pop(), is("element 0"));
        assertThat(queue.pop(), is("element 1"));
        assertThat(queue.pop(), is("element 2"));
        assertThat(queue.pop(), is("element 3"));
    }

}