package tasks;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class Task2SumIntegers {
    public static void run(){
        System.out.println("\nTask 2 : Sum of Integers");

        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add(i);
        }
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }

        double average = (double)sum/numbers.size();
        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
