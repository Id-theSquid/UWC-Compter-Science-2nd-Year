public class CounterExample {
    private static int n = 3;              // size of the array
    private static int[] d = new int[n];   // array initialized with zeros
    private static int count = 0;          // global counter

    // Recursive increment function
    public static int inc(int[] d, int i) {
        count++;
        System.out.println("count=" + count);

        int n = d.length;
        if (i < n) {
            if (d[i] < n - 1) {
                d[i] += 1;
                return 0;
            } else {
                d[i] = 0;
                return inc(d, i + 1);
            }
        } else {
            return 1;
        }
    }

    // Counter function
    public static void counter() {
        count = 0;
        int result = 0;
        while (result != 1) {
            int n = d.length;
            System.out.println("In inc: n=" + n + ", d=" + java.util.Arrays.toString(d));
            result = inc(d, 0);
        }
        System.out.println("Final count=" + count);
    }

    public static void main(String[] args) {
        counter();
    }
}
