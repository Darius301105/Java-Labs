package app;

import model.GenericBox;
import utils.GenericUtils;
import model.GenericStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEx 1: GenericBox");
        GenericBox<Integer> intBox = new GenericBox<>(10);
        System.out.println("Initial value: " + intBox.getValue());
        intBox.setValue(5);
        System.out.println("Updated value: " + intBox.getValue());

        GenericBox<String> stringBox = new GenericBox<>("Hello World!");
        System.out.println("String value: " + stringBox.getValue());

        System.out.println("\nEx 2: PrintTwice");
        GenericUtils.printTwice("Salut");
        GenericUtils.printTwice(100);

        System.out.println("\nEx 3: Max");
        System.out.println("Max of Integers: " + GenericUtils.max(10,45));
        System.out.println("Max of Strings: " + GenericUtils.max("banana", "apple"));

        System.out.println("\nEx 4: CountElements");
        List<String> names = Arrays.asList("Ana", "Bogdan", "Cristi", "Daria");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("Names count: " + GenericUtils.count(names));
        System.out.println("Numbers count: " + GenericUtils.count(numbers));

        System.out.println("\nEx 5: CopyLists");
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Number> destination = new ArrayList<>();
        GenericUtils.copy(source, destination);
        System.out.println("Destination after copy: " + destination);

        System.out.println("\nEx 6: GenericStack");
        GenericStack<String> stack = new GenericStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack after pushes: " + stack.toString());

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek after pop: " + stack.peek());
        System.out.println("Empty? " + stack.isEmpty());

        stack.pop();
        stack.pop();
        System.out.println("Empty after removing all existing items? " + stack.isEmpty());
    }
}
