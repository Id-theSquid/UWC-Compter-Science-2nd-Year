import java.util.Arrays;

public class ShufflingMethods {
    public static void SlowShuffle(int[] arr){
        boolean[] isnotPresent = new boolean[arr.length + 1];
        int N = arr.length;
        for (int i = 0; i < N+1; i++) {
            isnotPresent[i] = true;
        }
        int i = 0;
        while (i < N-1){
          int randomNumber = (int)(Math.random() * N + 1);
          arr[i] = randomNumber;
          isnotPresent[randomNumber] = false;
          i++;
        }
        for (int j = 1; j <= N ; j++) {
            if (isnotPresent[j]){
                arr[N-1] = j;
                        break;
            }
        }
    }
    public static void BiasedShuffling(int[] arr){
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            arr[i] = i +1;
        }

        for (int i = 0; i < N ; i++) {
            int RandomNumber = (int)(Math.random() * N);
            int temp = arr[i];
            arr[i] =arr[RandomNumber];
            arr[RandomNumber] = temp;
        }
    }

    public static void UnBiasedShuffling(int[] arr){
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            arr[i] = i +1;
        }

        for (int i = 0; i < N ; i++) {
            int RandomNumber = i +(int)(Math.random() * (N - i));
            int temp = arr[i];
            arr[i] =arr[RandomNumber];
            arr[RandomNumber] = temp;
        }
    }

    public static void main(String[] args) {
        int[] shuffle = {1,2,3};
        int times = 60000;
        int bcount1 = 0;
        int bcount2 = 0;
        int bcount3 = 0;
        int bcount4 = 0;
        int bcount5 = 0;
        int bcount6 = 0;

        for (int i = 0; i < times; i++) {
            shuffle = new int[]{1,2,3};
            BiasedShuffling(shuffle);
            String s = Arrays.toString(shuffle);
            switch (s){
                case "[1, 2, 3]" -> bcount1++;
                case "[1, 3, 2]" -> bcount2++;
                case "[2, 1, 3]" -> bcount3++;
                case "[2, 3, 1]" -> bcount4++;
                case "[3, 1, 2]" -> bcount5++;
                case "[3, 2, 1]" -> bcount6++;

            }
        }
        System.out.println("Biased Shuffling: ");
        System.out.println("[1, 2, 3] : " + bcount1 );
        System.out.println("[1, 3, 2] : " + bcount2);
        System.out.println("[2, 1, 3] : "  + bcount3);
        System.out.println("[2, 3, 1] : " +  bcount4);
        System.out.println("[3, 1, 2] : "  + bcount5);
        System.out.println("[3, 2, 1] : "  +  bcount6);

      //------------------------------------------------------------
         bcount1 = 0;
         bcount2 = 0;
         bcount3 = 0;
         bcount4 = 0;
         bcount5 = 0;
         bcount6 = 0;
        for (int i = 0; i < times; i++) {
            shuffle = new int[]{1,2,3};
            UnBiasedShuffling(shuffle);
            String s = Arrays.toString(shuffle);
            switch (s){
                case "[1, 2, 3]" -> bcount1++;
                case "[1, 3, 2]" -> bcount2++;
                case "[2, 1, 3]" -> bcount3++;
                case "[2, 3, 1]" -> bcount4++;
                case "[3, 1, 2]" -> bcount5++;
                case "[3, 2, 1]" -> bcount6++;

            }
        }
        System.out.println("UnBiased Shuffling: ");
        System.out.println("[1, 2, 3] : " + bcount1 );
        System.out.println("[1, 3, 2] : " + bcount2);
        System.out.println("[2, 1, 3] : "  + bcount3);
        System.out.println("[2, 3, 1] : " +  bcount4);
        System.out.println("[3, 1, 2] : "  + bcount5);
        System.out.println("[3, 2, 1] : "  +  bcount6);
        System.out.println("Unbiased shuffling is more fiar as seen");
    }

}
