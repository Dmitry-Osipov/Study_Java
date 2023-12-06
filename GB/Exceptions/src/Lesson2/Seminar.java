package Lesson2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seminar {
    public static void main(String[] args) {
        String path = "/Users/dimao/IdeaProjects/Study_Java/GB/Exceptions/src/Lesson2/names.txt";
        List<String[]> list = readFile(path);
        modificationArray(list);
        writeFile(list, path);
    }

    public static List<String[]> readFile(String path) {
        List<String[]> listNames = new ArrayList<>();;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                listNames.add(line.split("="));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listNames;
    }

    public static void writeFile(List<String[]> listNames, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String[] subArray : listNames) writer.write(subArray[0] + "=" + subArray[1] + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void modificationArray(List<String[]> array) {
        for (String[] subArray : array) {
            if (!Objects.equals(subArray[1], "?") && !isDigit(subArray[1])) {
                throw new IllegalArgumentException("Элемент не является числом или знаком вопроса.");
            }

            if (subArray[1].equals("?") || Integer.parseInt(subArray[1]) != subArray[0].length()) {
                subArray[1] = String.valueOf(subArray[0].length());
            }
        }
    }

    private static boolean isDigit(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
