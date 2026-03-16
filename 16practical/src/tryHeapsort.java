public class tryHeapsort {
    private static int parent(int i) {
        return (i - 1) / 2;
    }
    private static int leftChild(int i) {
        return 2 * i + 1;
    }
    private static int rightChild(int i) {
        return 2 * i + 2;
    }
    public static void swap(String[] a,int i,int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
   
}

