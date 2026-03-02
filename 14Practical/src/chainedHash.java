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



}
