public class Algorithms {
    public static int mscOn3X(int[] X){
        int n = X.length;
        int maxSoFar = 0;
        for (int low = 0; low < n; low++) {
            for (int high = low; high < n ; high++) {
                int sum = 0;
                for (int r = low; r < high ; r++) {
                    sum += X[r];
                }
                if (sum > maxSoFar){
                    maxSoFar = sum;
                }
            }
        }
        return maxSoFar;
    }
    public static int mscOn2B(int[] x){
        int n = x.length;
        int maxSoFar = 0;
        for (int low = 0; low < n ; low++) {
            int sum = 0;
            for (int r = low; r < n; r++) {
                sum += x[r];
                if (sum > maxSoFar){
                    maxSoFar = sum;
                }
            }

        }
        return maxSoFar;
    }

}
