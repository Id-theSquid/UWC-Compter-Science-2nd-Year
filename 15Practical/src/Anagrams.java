//Idwou Popoola
// 4546626
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
    public static String signature(String word){
    char[] letters = word.toCharArray(); // breaking word into characters
    Arrays.sort(letters); // sorting them aplhabeticalli order
    return new String(letters); // rejoining them into string
   }

    public static void main(String[] args) throws IOException {
        String filename = "ulysses.text"; // Making a varable to store the path of the given textfile
        BufferedReader fileReader;
        try {
            fileReader = new BufferedReader(new FileReader(filename));
            System.out.println("Opened the file: " + filename);
        } catch (FileNotFoundException e) { // catching the eroor if the file is not found in the floder
            System.out.println("File not found");
            return;
        }

        HashMap<String,Integer> D = new HashMap<>();
            String line;
        while ((line = fileReader.readLine()) != null){
                String[] words = line.split("\\s"); // any chreacter thats not in a-zA-z
                for (String w : words){
                    String cleaned = w.replaceAll("[^a-zA-z']","");
                    cleaned = cleaned.toLowerCase(); // makes it lower case
                    if (cleaned.isEmpty()) continue;
                    D.put(cleaned, D.getOrDefault(cleaned, 0) + 1); // added one if its a new word
                }
            }
            fileReader.close();
            System.out.println("Total unique words found: " + D.size());


    }


}
