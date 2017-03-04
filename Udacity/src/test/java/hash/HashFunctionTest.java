package hash;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashFunctionTest {
    private HashFunction hashFunction = new HashFunction();
    @Test
    public void hashFunctionTest() throws Exception {
        assertThat(hashFunction.hashFunction(5), is(1));
        assertThat(hashFunction.hashFunction(2467), is(3));
        assertThat(hashFunction.hashFunction(555_555), is(556));
        assertThat(hashFunction.hashFunction(1_000_000), is(1000));
        assertThat(hashFunction.hashFunction(899_999), is(900));
        assertThat(hashFunction.hashFunction(998_998), is(999));
    }

    @Test
    public void collisionTest() throws Exception {
        int[] arr = new int[1001];
        arr[0] =1000;
        for(int i=1; i<=1_000_000; i++) {
            int hash = hashFunction.hashFunction(i);
            arr[hash]++;
        }
        boolean collisionIsRight=true;
        for(int i: arr) {
            if(i!=1000) collisionIsRight=false;
        }

        assertThat(collisionIsRight, is(true));

    }

}