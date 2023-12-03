package Lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lesson {
    public static void main(String[] args) {
        // NullPointerException
        String name = null;
//        System.out.println(name.length());

        // ClassCastException
        Object object = new String("123");
//        System.out.println((File)object);

        // NumberFormatException
        String number1 = "123fq";
//        System.out.println(Integer.parseInt(number1));

        // UnsupportedOperationException
        List<Object> emptyList = Collections.emptyList();
//        emptyList.add(new Object());

        // Все классы наследуются от Throwable, далее идут дочерние классы Error (ошибки, генерируемые JVM) и Exception.
        // В свою очередь от Exception идут 2 общих типа - Checked (Класс Exception и его подклассы - исключения,
        // которые вы обязаны обработать в вашем коде. Если этого не сделать, будет ошибка на этапе компиляции) и
        // Unchecked (Класс RuntimeException и его подклассы - исключения, охватывающие такие ситуации, как деление на
        // ноль или ошибочная индексация массивов: их можно обрабатывать, если есть вероятность возникновения; а можно и
        // не обрабатывать поскольку предполагается, что при правильном поведении программы такие исключения вовсе не
        // должны возникать).

        int number = 1;
        try {
            number = 10 / 1;
            String test = null;
            System.out.println("Длина строки: " + test.length());
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        } catch (NullPointerException e) {
            System.out.println("У null нет длины");
        } catch (Exception e) {  // Общий тип должен всегда идти в самом конце, иначе частные случаи не будут обработаны.
            System.out.println("Возникло какое-то исключение");
        }
        System.out.println(number);

        FileReader fileReader = null;
        try {
            fileReader = new FileReader("test");
            fileReader.read();
        }
        catch (FileNotFoundException | RuntimeException e) { System.out.println("Файл не найден."); }
        catch (IOException e) { System.out.println("Проблема поступления файла."); }
        finally {
            System.out.println("finally start");
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("Проблема закрытия файла");
                }
            }
            System.out.println("finally end");
        }
    }
}
