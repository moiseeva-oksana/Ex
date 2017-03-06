package hashtable;

public class LinearProbing {
    private String[] table = new String[20_000_000];

    public int getHashOfString(String s) {
        return s.hashCode()/1000;
    }

    public void put(String string) {
        int i= getHashOfString(string);
        int count=0;
        while (table[i]!=null) {
            count++;
            i++;
            if(i==table.length-1) {
                i=0;
            }
            if (count==table.length) {
                throw new IndexOutOfBoundsException("Table is full");
            }
        }
        table[i]=string;
    }

    public int get(String string) {
        int i= getHashOfString(string);
        int count=0;
        while (table[i]==null || !table[i].equals(string)) {
            count++;
            i++;
            if(i==table.length-1) {
                i=0;
            }
            if (count==table.length) {
                return -1;
            }
        }
        return i;
    }

    public void delete(String string) {
        int index = get(string);
        if(index==-1) {
            return;
        }
        table[index]=null;
    }

}
