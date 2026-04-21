package tasks;

import java.util.HashMap;
import java.util.Map;

public class Task5WordFrequencyCounter {
    public static void run(){
        System.out.println("\nTask 5: WFC");
        String text = "apple banana apple orange banana apple";
        String[] words = text.split(" ");

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println(freq);
    }
}
