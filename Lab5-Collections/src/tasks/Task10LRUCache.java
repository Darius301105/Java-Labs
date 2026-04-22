package tasks;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task10LRUCache {
    public static void run(){
        System.out.println("\nTask 10: LRU Cache");
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<>(3,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 3;
            }
        };

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);
        cache.put(4, "D");

        System.out.println(cache);
    }
}
