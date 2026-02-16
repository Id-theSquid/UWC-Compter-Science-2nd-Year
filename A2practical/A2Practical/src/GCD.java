public class GCD {
    private static int count = 0;
    public static int gcd(int m ,int n){
        count++;
        if(n==0){
            return m;
        }
        else{
            return gcd(n,m%n);
        }

    }

    public static void main(String[] args) {
        int m = 27;
        int n = 51;
        int result = gcd(m,n);
        System.out.println("GCD of " + m + " and " + n + " is: " + result);
        System.out.println("Recursive calls: " + count);
    }
}
