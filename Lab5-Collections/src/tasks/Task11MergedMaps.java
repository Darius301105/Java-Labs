package tasks;

import java.util.Map;
import java.util.HashMap;

public class Task11MergedMaps {
    public static void run(){
        System.out.println("\nTask11: Merged Two Maps");

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 2);
        map1.put("banana", 3);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("banana", 4);
        map2.put("orange", 5);

        Map<String, Integer> merged = new HashMap<>(map1);

        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            merged.put(entry.getKey(), merged.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        System.out.println(merged);
    }
}
