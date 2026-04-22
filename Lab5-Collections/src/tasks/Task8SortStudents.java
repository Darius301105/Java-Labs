package tasks;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Task8SortStudents {
    public static void run(){
        System.out.println("\nTask 8: Sort Students");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mihai", 8));
        students.add(new Student("Ana", 10));
        students.add(new Student("Bogdan", 7));
        students.add(new Student("Cristi", 9));

        students.sort(Comparator.comparing(Student::getName));
        System.out.println("Students sorted by their names:");
        for (Student student : students){
            System.out.println(student);
        }

        students.sort((s1, s2) -> Integer.compare(s1.getGrade(), s2.getGrade()));
        System.out.println("Students sorted by their grades ascending:");
        for (Student student : students){
            System.out.println(student);
        }
    }
}
