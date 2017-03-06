package hashtable;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ChainingTable {
    private List<List<String>> table = new ArrayList<>();
    {
        for (int i=0; i<2_000_000; i++) {
            table.add(new LinkedList<>());
        }
    }
    public int getHashOfString(String string) {
        return string.hashCode()/10000;
    }

    public void put(String string) {
        int hash = getHashOfString(string);
        table.get(hash).add(string);
    }

    public int get(String string) {
        int hash = getHashOfString(string);
        for (String str: table.get(hash)) {
            if(str.equals(string)) {
                return hash;
            }
        }
        return -1;
    }

    public void delete(String string) {
        int hash = getHashOfString(string);
        if(table.get(hash).contains(string)) {
            table.get(hash).remove(string);
        }
    }

}
