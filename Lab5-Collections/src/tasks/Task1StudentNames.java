package tasks;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class Task1StudentNames {
    public static void run(){
        System.out.println("\nTask 1 : Create an arraylist of students");

        List <String> students = new ArrayList<>();
        students.add("Ana");
        students.add("Bob");
        students.add("David");
        students.add("Daniel");
        students.add("Cristi");

        System.out.println("Initial list: " + students);
        students.remove(2);
        System.out.println("After removing 3rd name: " + students);
    }
}
