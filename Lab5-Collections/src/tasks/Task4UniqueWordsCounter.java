package tasks;

import java.util.HashSet;
import java.util.Set;

public class Task4UniqueWordsCounter {
    public static void run(){
        System.out.println("\nTask 4: UWC");

        String sentence = "Ana are mere mari si gustoase";
        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("Unique words: " + uniqueWords);
        System.out.println("Count: " + uniqueWords.size());
    }
}
