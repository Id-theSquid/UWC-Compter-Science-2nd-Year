import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hashing {
    static class KeyValue {
        String key;
        String value;

        KeyValue(String key,String value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int N = 1 << 20;
        int first = 950_000;
        List<Integer> keys = new ArrayList<>(N);

        for (int i = 0; i < N ; i++) {
            keys.add(i);
        }

        //Shuffling
        for (int i = 0; i < N; i++) {
            int randomNumber = i + random.nextInt(N-i);

            Integer temp = keys.get(i);
            keys.set(i, keys.get(randomNumber));
            keys.set(randomNumber, temp);
        }

        KeyValue[] data = new KeyValue[N];

        for (int i = 0; i < N; i++) {
           String key = String.valueOf(keys.get(i));
           String value = String.valueOf(i+1);
           data[i] = new KeyValue(key,value);
        }

        System.out.printf("Genrated %d key values pairs.",N);

    }
}
