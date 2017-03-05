package mapsAndHashingQuizzes;

import java.util.ArrayList;

public class HashTable {
    ArrayList<ArrayList<String>> table = new ArrayList<>();
    {
        for (int i=0; i<300; i++) {
            table.add(new ArrayList<String>());
        }
    }
    public int hashForString(String string) {
        if(string.length()<2) {
            return -1;
        }
        return string.charAt(0) + string.charAt(1);
    }

    public void store(String string) {
        int hash = hashForString(string);
        table.get(hash).add(string);
    }

    public int lookup(String string) {
        int hash = hashForString(string);
        for (String str: table.get(hash)) {
            if(str.equals(string)) {
                return hash;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.store("ZZcd");
        hashTable.store("MIlk");
        System.out.println(hashTable.lookup("ZZcd"));
        System.out.println(hashTable.lookup("ABcdK"));

    }
}
