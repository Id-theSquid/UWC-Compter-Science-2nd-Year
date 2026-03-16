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
    }
}

