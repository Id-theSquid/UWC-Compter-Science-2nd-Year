public class chainedHash {

    private static class Node {
        String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    private Node[] table;
    private  int m;
    private int size;

    public chainedHash(int m ){
        this.m = m;
        this.table = new Node[m];
        this.size = 0;
    }

    public int hash(String key){
        int h = key.hashCode();
        h = Math.abs(h);
        return h % m;
    }

    public void insert(String key,String value) {
        int index = hash(key);
        Node head = table[index];

        if(head == null){
            table[index] = new Node(key,value);
            size++;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }
        prev.next = new Node(key,value);
        size++;
    }

    public String lookup(String key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null){
            if (current.key.equals(key)){
                return current.value;
            }
           current = current.next;
        }
        return null;
    }

    public String remove(String key){
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while(current != null) {
            if (current.key.equals(key)) {

                if (prev == null){

                    table[index] = current.next;
                }
                else{
                    prev.next = current.next;
                }
                size--;
                current = current.next;
            }
            prev = current;
            current = current.next;
        }
        return  null;
    }

}
