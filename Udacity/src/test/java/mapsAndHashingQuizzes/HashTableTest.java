package mapsAndHashingQuizzes;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HashTableTest {
    private HashTable hashTable = new HashTable();
    @Test
    public void hashForStringTest() throws Exception {
        assertThat(hashTable.hashForString("TEST"), is('T'+'E'));
    }

    @Test
    public void lookupTest() throws Exception {
        hashTable.store("TEST");
        int result = hashTable.lookup("TEST");
        assertThat(result, is(hashTable.hashForString("TEST")));
        assertThat(hashTable.lookup("None"), is(-1));
    }

}