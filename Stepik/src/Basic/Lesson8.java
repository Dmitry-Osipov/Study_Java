package Basic;

public class Lesson8 {
    public static void main(String[] args) {
        String str = "Java";
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.println("Ёмкость: " + stringBuffer.capacity());  // 20
        stringBuffer.ensureCapacity(32);
        System.out.println("Ёмкость: " + stringBuffer.capacity());  // 42 - jvm дополнительно выделила память.
        System.out.println("Длина: " + stringBuffer.length());  // 4
        stringBuffer.setCharAt(0, 'c');
        System.out.println(stringBuffer);

        StringBuffer stringBuffer1 = new StringBuffer("world");
        int startIndex = 1;
        int endIndex = 4;
        char[] buffer = new char[endIndex-startIndex];
        stringBuffer1.getChars(startIndex, endIndex, buffer, 0);
        System.out.println(buffer);
        stringBuffer1.append(" hello");
        System.out.println(stringBuffer1);

        stringBuffer1.insert(3, 'l');
        stringBuffer1.insert(0, 's');
        System.out.println(stringBuffer1);

        stringBuffer1.delete(0, 2);
        System.out.println(stringBuffer1);

        stringBuffer1.deleteCharAt(6);
        System.out.println(stringBuffer1);

        String str1 = stringBuffer1.substring(6);
        String str2 = stringBuffer1.substring(3, 9);
        System.out.println(str1);
        System.out.println(str2);

        StringBuffer stringBuffer2 = new StringBuffer("hello");
        stringBuffer2.setLength(10);
        System.out.println(stringBuffer2);
        stringBuffer2.setLength(4);
        System.out.println(stringBuffer2);

        StringBuffer stringBuffer3 = new StringBuffer("hello world!");
        stringBuffer3.replace(6, 11, "java");
        System.out.println(stringBuffer3);

        System.out.println(stringBuffer3.reverse());
    }
}
