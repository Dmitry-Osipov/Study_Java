package Lesson1;

import java.io.File;

public class Lesson {
    public static void main(String[] args) {
        System.out.println(getFileSize(new File("/Users/dimao/IdeaProjects/Study_Java/Basic/src/Lesson1/Homework.java")));
        //System.out.println(divide(10, 0));
        //a();
    }

    public static long getFileSize(File file){
        if (!file.exists()) return -1;
        return file.length();
    }

    public static int divide(int a1, int a2){
        if (a2 == 0) throw new RuntimeException("На ноль делить нельзя");
        return a1 / a2;
    }

    public static void a(){
        b();
    }

    public static void b(){
        c();
    }

    public static void c(){
        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }
}
