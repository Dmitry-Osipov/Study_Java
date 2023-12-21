package meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {
        ISum sum = new ISum() {  // Объявляем анонимный класс.
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        };
        ISum sum2 = (x, y) -> x + y;  // Объявляем анонимную функцию.
        ISum sum3 = (int x, int y) -> {
            if (x == 0) return 0;
            return x + y;
        };  // Пример многострочной лямбды.

        ISqrt sqrt = x -> Math.sqrt(x);
        ISqrt sqrt2 = Math::sqrt;  // Передача ссылки на функцию.

        System.out.println(sqrt2.sqrt(4));  // Пример вызова анонимной функции.

        final Consumer<String> printer = System.out::println;
        printer.accept("1");

        // Задача: создать список студентов и посчитать количество невалидных студентов.
        final List<Student> students = new ArrayList<>(){{
            add(new Student(36, "Абдул"));
            add(new Student(35, "a"));
            add(new Student(34, "b"));
            add(new Student(33, "c"));
            add(new Student(31, "null"));
        }};
        // Было до stream:
//        int counter = 0;
//        for (Student student : students) {
//            if (student.age > 30 && (student.name == null || student.name.length() <= 4)) counter++;
//        }
//        System.out.println(counter);
        // Стало со stream:
        System.out.println(students.stream()
                .filter(student -> student.age > 30)
                .map(student -> student.name)
                .filter(name -> name == null || name.length() <= 4)
                .count());
    }

    @FunctionalInterface  // Функциональный интерфейс содержит в себе лишь 1 объявленный метод.
    public interface ISum {
        public int sum(int x, int y);
    }

    @FunctionalInterface
    public interface ISqrt {
        public double sqrt(double x);
    }

    private static class Student {
        final int age;
        final String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
