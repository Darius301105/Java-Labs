package model;

public class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "n/a";
        this.age = 0;
    }

    public Student(String name) {
        this.name = name;
        this.age = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name + ".");
    }

    public String introduce(String otherPerson) {
        return "Hello " + otherPerson + ", I am " + name + ".";
    }

    private void secretMethod() {
        System.out.println("Private method");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student: name='" + name + "', age=" + age;
    }
}