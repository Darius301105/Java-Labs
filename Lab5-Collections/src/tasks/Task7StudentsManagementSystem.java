package tasks;

import model.Student;
import java.util.ArrayList;
import java.util.List;

public class Task7StudentsManagementSystem {
    public static void run(){
        System.out.println("\nTask 7: Students Management System");

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ana", 9));
        students.add(new Student("Bogdan", 7));
        students.add(new Student("Cristi", 10));
        students.add(new Student("Daria", 8));

        for(Student student: students){
            System.out.println(student);
        }

        Student best = students.get(0);
        System.out.println("Student with the highest grade in the list: ");
        for(Student student: students){
            if(student.getGrade() > best.getGrade()){
                best = student;
            }
        }
        System.out.println(best);
    }
}
