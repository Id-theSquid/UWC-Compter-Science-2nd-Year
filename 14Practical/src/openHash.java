public class openHash {

    private static class Entry {
        String key;
        String value;
        boolean deleted;

        Entry(String key,String value){
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private Entry[] table;
    private int m;
    private int size;

    public openHash(int m){
        this.m = m;
        this.table = new Entry[m];
        this.size = 0;
    }
    // Question 3A
    public int hash(String key){
        int h = key.hashCode();
        h = Math.abs(h);
        return h % m;
    }
    // Question 3B
    public boolean insert(String key,String value){
        if (isFull()) return false;
        int index = hash(key);

        while ((table[index] != null && !table[index].deleted)){
            if (table[index].key.equals(key)){
                table[index].value = value;
                return true;
            }
            index = (index + 1) % m;
        }
        table[index] = new Entry(key,value);
        size++;
        return true;
    }
      // Question 3C
    public String lookup(String key) {
        int index = hash(key);
        int start = index;
        while(table[index] != null){
            if(!table[index].deleted && table[index].key.equals(key)){
                return  table[index].value;
            }
            index = (index + 1) % m;

            if (index == start)
                break;
        }
        return null;
    }

    
}
