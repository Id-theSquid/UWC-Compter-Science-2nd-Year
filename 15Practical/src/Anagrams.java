//Idwou Popoola
// 4546626
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class Anagrams {
    public static String signature(String word){
    char[] letters = word.toCharArray(); // breaking word into characters
    Arrays.sort(letters); // sorting them aplhabeticalli order
    return new String(letters); // rejoining them into string
   }

    public static void main(String[] args) {
        String filename = "ulysses.text"; // Making a varable to store the path of the given textfile
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            System.out.println("Opened the file: " + filename);
        } catch (FileNotFoundException e) { // catching the eroor if the file is not found in the floder
            System.out.println("File not found");

        }
    }


}
