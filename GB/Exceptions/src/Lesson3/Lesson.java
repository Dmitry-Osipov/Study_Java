package Lesson3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson {
    public static void main(String[] args) {
        try (FileReader reader =
                 new FileReader("/Users/dimao/IdeaProjects/Study_Java/GB/Exceptions/src/Lesson2/names.txt");
             FileWriter writer =
                 new FileWriter("/Users/dimao/IdeaProjects/Study_Java/GB/Exceptions/src/Lesson3/lesson.txt")
            ) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally start");
//            if (test != null) {
//                try {
//                    test.close();
//                } catch (IOException e) {
//                    System.out.println("exception while close");
//                }
//            } - блок try with resources закрывает всё сам.
            System.out.println("finally finished");
        }
        System.out.println("copy successfull");

        throw new MyException("Работает");
    }
}

class MyException extends RuntimeException {
    public MyException(String message, Exception e) {
        super(message, e);
    }

    public MyException(String message) { super(message); }

    public MyException() {}
}