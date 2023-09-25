package Lesson2;

/*
Что такое API?
API (Application programming interface) — это контракт, который предоставляет программа. «Ко мне можно обращаться так и
так, я обязуюсь делать то и это».

Что такое API для нас?
Это возможности, который предоставляют разработчики языка для удобного взаимодействия с его функционалом.

Примеры API:
1. Строки;
2. Работа с файловой системой;
3. Логирование;
4. Импорт;
5. Xml.

*/

import java.io.File;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Lesson {
    public static void main(String[] args) {

    }

    // Строки:
    public static void makeStr() {  // Данный код отработает за 41000 ms
        String str = "";
        for (int i = 0; i < 1_000_000; i++) {
            str += "+";
        }
    }

    public static void makeStr1() {  // Данный код отработает за 9 ms
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("+");
        }
    }

    /*
    Методы строк:
    concat(): объединение строк
    valueOf(): преобразует Object в строковое представление (завязан на toString())
    join(): объединяет набор строк в одну с учетом разделителя
    charAt(): получение символа по индексу
    indexOf(): первый индекс вхождения подстроки
    lastIndexOf(): последний индекс вхождения подстроки
    startsWith()/endsWith(): определяет, начинается/заканчивается ли строка с подстроки
    replace(): замена одной подстроки на другую
    trim(): удаляет начальные и конечные пробелы
    substring(): возвращает подстроку, см.аргументы
    toLowerCase()/toUpperCase(): возвращает новую строку в нижнем/верхнем регистре
    сompareTo(): сравнивает две строки
    equals(): сравнивает строки с учетом регистра
    equalsIgnoreCase(): сравнивает строки без учета регистра
    regionMatches(): сравнивает подстроки в строках

    Таким образом, для работы с уже готовой строкой стоит использовать String, а для работы с преобразованием строк -
    StringBuilder.
    */

    // Работа с файловой системой:
    public static void fileSystem() {  // Может возникнуть ошибка, которая нам всё испортит
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat("/file.txt");
        File f3 = new File(pathFile);
        System.out.println(f3.getAbsolutePath ());
        // /Users/sk/vscode/java_projects/file.txt
        // C:/Users/Sk/Documents/xxx/brainexplosion/java/file.txt
    }

    public static void fileSystem1() {  // Для избежания ошибок следует использовать блок try-catch
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file.txt");
            File f3 = new File(pathFile);
            System.out.println("try");
        } catch (Exception e) {
            System.out.println("catch");
        }
        finally
        { System.out.println("finally"); }
    }
    /*
    Методы файлов:
    isHidden(): возвращает истину, если каталог или файл является скрытым
    length(): возвращает размер файла в байтах
    lastModified(): возвращает время последнего изменения файла или каталога
    list(): возвращает массив файлов и подкаталогов, которые находятся в каталоге
    listFiles(): возвращает массив файлов и подкаталогов, которые находятся
    в определенном каталоге
    mkdir(): создает новый каталог
    renameTo(File dest): переименовывает файл или каталог
    length(): возвращает размер файла в байтах
    lastModified(): возвращает время последнего изменения
    файла или каталога
    list(): возвращает массив файлов и подкаталогов, которые находятся в каталоге
    listFiles(): возвращает массив файлов и подкаталогов, которые
    находятся в определенном каталоге
    mkdir(): создает новый каталог
    renameTo(File dest): переименовывает файл или каталог
    */

    // Логирование:
//    public static void log() {
//        Logger logger = Logger.getLogger(Ex0043.class.getName());
//        logger.setLevel(Level.INFO);
//        ConsoleHandler ch = new ConsoleHandler();
//        logger.addHandler(ch);
//        //SimpleFormatter sFormat = new SimpleFormatter();
//        XMLFormatter xml = new XMLFormatter();
//        //ch.setFormatter(sFormat);
//        ch.setFormatter(xml);
//        logger.log(Level.WARNING, "Тестовое логирование");
//        logger.info("Тестовое логирование");
//    }
}
