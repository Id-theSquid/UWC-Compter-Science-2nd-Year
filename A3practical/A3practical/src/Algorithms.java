import java.util.Arrays;
import java.util.Random;

public class Algorithms {
    public static int mscOn3X(int[] X) {
        int n = X.length;
        int maxSoFar = 0;
        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = 0;
                for (int r = low; r <= high; r++) {
                    sum += X[r];
                }
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }


    public static int mscOn2A(int[] x) {
        int n = x.length;
        int maxSoFar = 0;
        for (int low = 0; low < n; low++) {
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += x[r];
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }


    public static int mscOn2B(int[] x) {
        int n = x.length;
        int[] sumTO = new int[n + 1];
        int maxSoFar = 0;
        sumTO[0] = 0;
        for (int i = 0; i < n; i++) {
            sumTO[i + 1] = sumTO[i] + x[i];
        }


        for (int low = 0; low < n; low++) {
            for (int high = low; high < n; high++) {
                int sum = sumTO[high + 1] - sumTO[low];
                if (sum > maxSoFar) {
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }

    public static float mcsOn(int[] X) {
        int n = X.length;
        float maxSoFar = 0;
        float maxToHere = 0;
        for (int i = 0; i < n; i++) {
            maxToHere = Math.max(0, maxToHere + X[i]);
            maxSoFar = Math.max(maxSoFar, maxToHere);
        }
        return maxSoFar;
    }


    public static int[] arrayMaker(int n) {
        Random random = new Random();
        int[] X = new int[n];
        for (int k = 0; k < n; k++) {
            int value = random.nextInt(n) + 1;
            int exponent = random.nextInt(3) + 2;
            int sign = (exponent % 2 == 0) ? 1 : -1;
            X[k] = value * sign;
        }
        return X;
    }

    public static void main(String[] args) {
        int n = 20;
        int[] X = arrayMaker(n);
        long startTime = 0;
        long endTime = 0;
        long duration = 0;
        startTime = System.nanoTime();
        System.out.println("O(n3) : " + mscOn3X(X));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken in Nanoseconds: " + duration);


        startTime = 0;
        endTime = 0;
        duration = 0;

        //
        startTime = System.nanoTime();
        System.out.println("O(n2) : " + mscOn2A(X));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken in Nanoseconds: " + duration);

        //
        startTime = 0;
        endTime = 0;
        duration = 0;

        //
        startTime = System.nanoTime();
        System.out.println("O(n2) : " + mscOn2B(X));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken in Nanoseconds: " + duration);

        //
        startTime = 0;

        //
        startTime = System.nanoTime();
        System.out.println("O(n) : " + mcsOn(X));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Time taken in Nanoseconds: " + duration);
    }
}

