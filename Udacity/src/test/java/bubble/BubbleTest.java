package bubble;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Acer on 28.02.2017.
 */
public class BubbleTest {
    @Test
    public void sort() throws Exception {
        int[] list = {5,4,3,0,2,-7,9,11,-5};
        int[] expected = Arrays.copyOf(list, list.length);
        Arrays.sort(expected);
        Bubble.sort(list, list.length);
        assertArrayEquals(list, expected);

    }

}