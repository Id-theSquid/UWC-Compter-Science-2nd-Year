// idowu Popoola
// 4546626
// Used claude to structure the practical pdf better to understand
//2026/03/16

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static Node[] loadNodes(String filePath) throws IOException {
        List<String> words = new ArrayList<>();
        for (String raw : Files.readAllLines(Path.of(filePath))) {
            String line = raw.trim();
            if (line.isEmpty())               continue;
            if (line.startsWith("="))         continue;
            if (line.startsWith("Generated")) continue;
            if (line.startsWith("Total"))     continue;
            if (line.matches("---.*---"))     continue;
            if (line.matches("\\d+"))         continue;

            for (String token : line.split(",")) {
                String w = token.trim().toLowerCase();
                if (!w.isEmpty()) words.add(w);
            }
        }
        Node[] nodes = new Node[words.size() + 1];
        nodes[0] = null;
        for (int i = 0; i < words.size(); i++)
            nodes[i + 1] = new Node(words.get(i));

        return nodes;
    }
    private static void timeBoth(Node[] input, int size) {

        long t1 = System.nanoTime();
        Heap buHeap = runBottomUp(input, size);
        long buTime = System.nanoTime() - t1;

        long t2 = System.nanoTime();
        Heap tdHeap = runTopDown(input, size);
        long tdTime = System.nanoTime() - t2;

        System.out.println("\n-----Timing Results ---");
        System.out.println("Words sorted: " + size);
        System.out.println("buildUp(bottom-up): " + buTime / 1_000_000 + " ms");
        System.out.println("buildDown(top-down): " + tdTime / 1_000_000 + " ms");

        if (buTime < tdTime)
            System.out.println("=> buildUp was faster");
        else
            System.out.println("=> buildDown was faster");
    }
    private static void smokeTest() {
        String[] words = {
                "ulysses", "bloom", "stephen", "molly", "dedalus",
                "odyssey", "dublin", "wandering", "conscience", "stream",
                "nighttown", "sirens", "cyclops", "nausicaa", "proteus",
                "telemachus", "calypso", "hades", "aeolus", "penelope"
        };
        int size = words.length;

        Node[] input = new Node[size + 1];
        input[0] = null;
        for (int i = 0; i < size; i++)
            input[i + 1] = new Node(words[i]);

        System.out.println("\n========================================================");
        System.out.println(" TEST (" + size + " words)");
        System.out.println("========================================================");
        System.out.print(" Input : ");
        for (int i = 1; i <= size; i++) System.out.print(input[i] + " ");
        System.out.println();

        Heap buHeap = runBottomUp(input, size);
        String[] buSorted = buHeap.getSortedWords(size);
        System.out.println("\n(a) buildUp + heapSort:");
        System.out.println("      " + Arrays.toString(buSorted));


        Heap tdHeap = runTopDown(input, size);
        String[] tdSorted = tdHeap.getSortedWords(size);
        System.out.println("\n(b) buildDown [insert(Node)] + heapSort:");
        System.out.println("      " + Arrays.toString(tdSorted));
        
    }
}

