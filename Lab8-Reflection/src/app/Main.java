package app;

import model.Student;

import model.Student;
import utils.ReflectionUtils;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Student.class;

            // ex1
            System.out.println("Task 1: Class information");
            ReflectionUtils.printClassInfo(studentClass);

            // ex2
            System.out.println("Task 2: Declared fields");
            ReflectionUtils.printFields(studentClass);

            // ex3
            System.out.println("Task 3: Declared methods");
            ReflectionUtils.printMethods(studentClass);

            // ex4
            System.out.println("Task 4: Create object dynamically");
            Object student1 = ReflectionUtils.createWithConstructor(
                    studentClass,
                    new Class<?>[]{String.class, int.class},
                    new Object[]{"Ana", 20}
            );
            System.out.println(student1);
            System.out.println();

            // ex5
            System.out.println("Task 5: Call public method");
            ReflectionUtils.callPublicMethod(student1, "sayHello");

            // ex6
            System.out.println("Task 6: Access private field");
            ReflectionUtils.accessPrivateField(student1, "name", "Ana");
            System.out.println(student1);
            System.out.println();

            // ex7
            System.out.println("Task 7: Call private method");
            ReflectionUtils.callPrivateMethod(student1, "secretMethod");

            // ex8
            System.out.println("Task 8: Constructor selection");
            Object student2 = ReflectionUtils.createWithConstructor(
                    studentClass,
                    new Class<?>[]{String.class},
                    new Object[]{"Maria"}
            );
            System.out.println(student2);

            Object student3 = ReflectionUtils.createWithConstructor(
                    studentClass,
                    new Class<?>[]{String.class, int.class},
                    new Object[]{"George", 21}
            );
            System.out.println(student3.toString());
            System.out.println();

            // ex9
            System.out.println("Task 9: Object inspector");
            ReflectionUtils.inspect(student3);

            // ex10
            System.out.println("Task 10: JSON serializer");
            String json = ReflectionUtils.toJson(student3);
            System.out.println(json);
            System.out.println();

            // ex11
            System.out.println("Task 11: CSV mapper");
            String[] columns = {"name", "age"};
            String[] csvValues = {"Elena", "22"};

            Student studentFromCsv = ReflectionUtils.fromCsv(Student.class, columns, csvValues);
            System.out.println(studentFromCsv);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}