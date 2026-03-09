//Idwou Popoola
// 4546626
import java.util.Arrays;

public class Anagrams {

    public static String signature(String word){
    char[] letters = word.toCharArray(); // breaking word into characters
    Arrays.sort(letters); // sorting them aplhabeticalli order
    return new String(letters); // rejoining them into string
   }
}
