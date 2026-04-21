package tasks;

import java.util.HashMap;
import java.util.Map;

public class Task6PhoneBook {
    public static void run(){
        System.out.println("\nTask 6: Phone Book");

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("Alex", "0770220910");
        phoneBook.put("Ioan", "0722880990");
        phoneBook.put("George", "0740909102");

        System.out.println("Search Alex: " + phoneBook.get("Alex"));
        System.out.println("All contacts: " + phoneBook);
    }
}
