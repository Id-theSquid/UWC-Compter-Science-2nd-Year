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
}
