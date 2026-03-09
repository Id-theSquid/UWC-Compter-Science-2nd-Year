//Idwou Popoola
// 4546626
import java.io.*;
import java.util.*;

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
                String[] words = line.split("\\s+"); // any chreacter thats not in a-zA-z
                for (String w : words){
                    String cleaned = w.replaceAll("[^a-zA-Z']",""); // therre was a mistake here but i fixed it 
                    cleaned = cleaned.toLowerCase(); // makes it lower case
                    if (cleaned.isEmpty()) continue;
                    D.put(cleaned, D.getOrDefault(cleaned, 0) + 1); // added one if its a new word
                }
            }
            fileReader.close();
            System.out.println("Total unique words found: " + D.size());
          //----------------------------
        HashMap<String, List<String>> A = new HashMap<>();

        for (String word : D.keySet()) {
            String sig = signature(word); // computing the word signate

            if (!A.containsKey(sig)) {
                A.put(sig,new ArrayList<>()); // first time we see it we making a new list
            }
            A.get(sig).add(word); // adding the word to the list of signatures
       }
        System.out.println("Total unique signatures: " + A.size());

        //------------------------------------
        List<List<String>> anagramGroups = new ArrayList<>();
        int totalAnagramWords = 0;

        for (String sig : A.keySet()) {
            List<String> group = A.get(sig);
            if (group.size() > 1) {  // only keeping groups with more then 2 words
                Collections.sort(group);
                anagramGroups.add(group);
                totalAnagramWords += group.size();
            }

        }
        anagramGroups.sort(Comparator.comparing(g -> g.get(0)));
        System.out.println("Anagram groups found: " + anagramGroups.size());
        System.out.println("Total words that have at least one anagram: " + totalAnagramWords);
        //--------------------------

        String outputFile = "anagrams_output.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("=====ANAGRAM DICTIONARY=======");
            writer.println("Generated from: " + filename);
            writer.println("Total anagram groups: " + anagramGroups.size());
            writer.println("===============================");
            writer.println();

            char currentLetter  = ' ';
            for (List<String> group : anagramGroups) {
                char firstLetter = group.get(0).charAt(0);
                if (Character.toLowerCase(firstLetter) !=Character.toLowerCase(currentLetter)){
                    currentLetter = firstLetter;
                    writer.println("\n---" + Character.toUpperCase(currentLetter) + "----");
                }
                writer.println(String.join(", " , group));
            }

            System.out.println("\nAnagram dictionary was written to: " + outputFile);
        } catch (IOException e){
            System.err.println("There was an error writing output file: " + e.getMessage());
        }

    }


}
