package heap;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HeapTest {
    private Heap<Integer> heap = new Heap<>();
    @Before
    public void init() {
        heap.insert(15);
        heap.insert(1);
        heap.insert(6);
        heap.insert(12);
        heap.insert(8);
        heap.insert(20);
        heap.insert(17);
        heap.insert(13);
        heap.insert(16);
    }

    @Test
    public void insertTest() throws Exception {
        for(int i = 1; i< heap.getArray().size(); i++ ) {
            assertThat(heap.getArray().get(i)< heap.parent(i), is(true));
        }
        heap.insert(10);
        heap.insert(14);
        heap.insert(-7);
        heap.insert(4);
        for(int i = 1; i< heap.getArray().size(); i++ ) {
            assertThat(heap.getArray().get(i)< heap.parent(i), is(true));
        }
    }

    @Test
    public void peekTest() throws Exception {
        assertThat(heap.peek(), is(20));
        heap.insert(30);
        assertThat(heap.peek(), is(30));
    }

    @Test
    public void removeTest() throws Exception {
        assertThat(heap.remove(), is(20));
        assertThat(heap.peek(), is(17));
        heap.insert(30);
        assertThat(heap.remove(), is(30));
    }

    @Test
    public void isEmptyTest() throws Exception {
        int count = heap.getSize();
        for(int i=0; i<count; i++) {
            heap.remove();
        }
        assertThat(heap.isEmpty(), is(true));
    }

}