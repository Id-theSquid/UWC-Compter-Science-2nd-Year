// idowu Popoola
// 4546626
// Used claude to structure the practical pdf better to understand
//2026/03/16

public class tryHeapsort {
    static class Node {
        String key;
        Node(String key) { this.key = key; }
        int compareTo(Node other) {
            return this.key.compareToIgnoreCase(other.key);
        }
        @Override
        public String toString() { return key; }
    }

    static class Heap {
        Node[] A;
        int n;
        private int parent (int i){
            return i / 2;
        }
        private int left (int i) {
            return 2*i;
        }
        private void swap(int i,int j) {
            Node temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        public void heapify(int i) {
            int child = left(i);
            while(child <= n) {
                if (child < n && A[child].compareTo(A[child + 1]) < 0)
                    child++;
                if (A[child].compareTo(A[i]) > 0) {
                    swap(i, child);
                    i     = child;
                    child = left(i);
                } else {
                    break;
                }
            }
        }
        public void insert(Node N){
            n++;
            int i = n;

            while (i > 1 && A[parent(i)].compareTo(N) < 0) {
                A[i] = A[parent(i)];
                i = parent(i);
            }
            A[i] = N;
        }
        // O(nlogn since we diving)
        public void buildup(Node[] X ,int sizeX){
            for (int i = 0; i <= sizeX; i++) {
               A[i] = X[i];
               n= sizeX;
            }
            for (int i = n/2; i > 0 ; i--) {
                heapify(i);
            }
        }
        public void buildDown(Node[] X, int sizeX) {
            n = 0;
            for (int i = 1; i <= sizeX ; i++) {
                insert(X[i]);
            }
        }
        public void heapsort(){
            while (n > 1) {
                swap(1,n);
                n--;
                heapify(1);
            }
        }
        public String[] getSortedWords(int originalSize) {
            String[] out = new String[originalSize];
            for (int i = 0; i < originalSize; i++)
                out[i] = A[i + 1].key;
            return out;
        }
    }
    private static Heap runBottomUp(Node[] input, int size) {
        Heap h = new Heap();
        h.A = new Node[size + 1];   // index 0 unused (1-based)
        h.buildup(input, size);
        h.heapsort();
        return h;
    }

    private static Heap runTopDown(Node[] input, int size) {
        Heap h = new Heap();
        h.A = new Node[size + 1];
        h.buildDown(input, size);
        h.heapsort();
        return h;
    }
}

