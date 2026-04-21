package tasks;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Task3ReverseList {
    public static void run() {
        System.out.println("\nTask 3 : Reverse a list");
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> reversed = new ArrayList<>();

        for (int i = numbers.size() - 1; i >= 0; i--) {
            reversed.add(numbers.get(i));
        }

        System.out.println("Original: " + numbers);
        System.out.println("Reversed: " + reversed);
    }
}
