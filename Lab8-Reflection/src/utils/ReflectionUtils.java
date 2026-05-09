package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionUtils {

    // ex1
    public static void printClassInfo(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getName());

        Package pkg = clazz.getPackage();
        System.out.println("Package name: " + (pkg != null ? pkg.getName() : "No package"));

        Class<?> superClass = clazz.getSuperclass();
        System.out.println("Superclass: " + (superClass != null ? superClass.getName() : "None"));

        Class<?>[] interfaces = clazz.getInterfaces();
        System.out.println("Implemented interfaces: " + Arrays.toString(interfaces));
        System.out.println();
    }

    // ex2
    public static void printFields(Class<?> clazz) {
        System.out.println("Declared fields:");
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(
                    Modifier.toString(field.getModifiers()) + " " + field.getType().getSimpleName() + " " + field.getName()
            );
        }
        System.out.println();
    }

    // ex3
    public static void printMethods(Class<?> clazz) {
        System.out.println("Declared methods:");
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers()) + " ");
            System.out.print(method.getReturnType().getSimpleName() + " ");
            System.out.print(method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
        System.out.println();
    }

    // ex4
    public static Object createWithNoArgs(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getConstructor();
        return constructor.newInstance();
    }

    // ex5
    public static void callPublicMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        method.invoke(obj);
    }

    // ex6
    public static void accessPrivateField(Object obj, String fieldName, Object newValue) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.println("Original value of private field '" + fieldName + "': " + field.get(obj));
        field.set(obj, newValue);
        System.out.println("Modified value of private field '" + fieldName + "': " + field.get(obj));
        System.out.println();
    }

    // ex7
    public static void callPrivateMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);
        System.out.println();
    }

    // ex8
    public static Object createWithConstructor(Class<?> clazz, Class<?>[] paramTypes, Object[] values) throws Exception {
        Constructor<?> constructor = clazz.getConstructor(paramTypes);
        return constructor.newInstance(values);
    }

    // ex9
    public static void inspect(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Inspecting object of type: " + clazz.getSimpleName());
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(obj));
        }
        System.out.println();
    }

    // ex10
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder json = new StringBuilder();
        json.append("{");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);

            json.append("\"").append(fields[i].getName()).append("\":");

            Object value = fields[i].get(obj);

            if (value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }

            if (i < fields.length - 1) {
                json.append(",");
            }
        }
        json.append("}");
        return json.toString();
    }

    // ex11
    public static <T> T fromCsv(Class<T> clazz, String[] columnNames, String[] values) throws Exception {
        T obj = clazz.getConstructor().newInstance();
        for (int i = 0; i < columnNames.length; i++) {
            Field field = clazz.getDeclaredField(columnNames[i]);
            field.setAccessible(true);
            if (field.getType() == int.class) {
                field.setInt(obj, Integer.parseInt(values[i]));
            } else if (field.getType() == String.class) {
                field.set(obj, values[i]);
            }
        }
        return obj;
    }
}
