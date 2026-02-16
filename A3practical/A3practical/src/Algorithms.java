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
    public static int mscOn2A(int[] x){
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

    public static int mscOn2B(int[] x) {
        int n = x.length;
        int[] sumTO = new int[n + 1];
        int maxSoFar = 0;
        for (int i = 0; i < n; i++) {
            sumTO[i] = sumTO[i - 1] + x[i];
            maxSoFar = 0;
            for (int low = 0; low < n; low++) {
                for (int high = low; high < n; high++) {
                    int sum = sumTO[high] - sumTO[low - 1];
                    if (sum > maxSoFar) {
                        maxSoFar = sum;
                    }
                }
            }


        }
        return maxSoFar;
    }

    public static float mcsOn(int[] X){
       int n = X.length;
       float maxSoFar = 0;
       float maxToHere = 0;
        for (int i = 0; i < n; i++) {
            maxToHere = Math.max(maxToHere + X[i],0);
            maxSoFar = Math.max(maxSoFar,maxToHere);
        }
        return maxSoFar;
    }
}
