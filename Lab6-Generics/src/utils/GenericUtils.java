package utils;

import java.util.List;

public class GenericUtils {
    public static <T> void printTwice(T value) {
        System.out.println(value);
        System.out.println(value);
    }
    public static <T extends Comparable<T>> T max(T a, T b) {
        if(a.compareTo(b) >= 0){
            return a;
        }
        return b;
    }

    public static <T> int count(List<T> list) {
        return list.size();
    }

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T element : src) {
            dest.add(element);
        }
    }




}
