package tasks;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task9RemoveDuplicates {
    public static void run(){
        System.out.println("\nTask 9: Remove Duplicates");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ana", 10));
        students.add(new Student("Bogdan", 8));
        students.add(new Student("Ana", 10));
        students.add(new Student("Cristi", 9));
        students.add(new Student("Bogdan", 8));

        System.out.println("With duplicates:");
        System.out.println(students);

        Set<Student> unique = new LinkedHashSet<>(students);
        System.out.println("Removing duplicates:");
        System.out.println(unique);
    }
}
