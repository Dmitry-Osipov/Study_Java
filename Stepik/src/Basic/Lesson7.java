package Basic;

public class Lesson7 {
    public static void main(String[] args) {
        String str1 = "Java";  // str1, str2 и т.д. являются лишь ссылками на строки, а не самими строками.
        String str2 = new String();
        String str3 = new String(new char[] {'h', 'e', 'l', 'l', 'o'});
        String str4 = new String(new char[] {'w', 'e', 'l', 'c', 'o', 'm', 'e'}, 3, 4);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str1.length());
        char[] helloArray = str3.toCharArray();

        String s = null;
        if (s == null || s.length() == 0) System.out.println("String is empty");
        if (s == null || s.isEmpty()) System.out.println("String is empty");

        str2 = str1 + " " + str3;
        System.out.println(str2);

        str4 = "Год " + 2019;
        System.out.println(str4);

        str1 = "Java";
        str2 = "Hello";
        str3 = String.join(" ", str1, str2);
        System.out.println(str3);

        char c = str1.charAt(2);
        System.out.println(c);

        String str = "Hello World!";
        int start = 6;
        int end = 11;
        char[] dst = new char[end-start];
        str.getChars(start, end, dst, 0);
        System.out.println(dst);

        str1 = "Hello";
        str2 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        str1 = "hello";
        str2 = "world";
        str3 = "hell";
        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str1.compareTo(str1));

        str1 = "Hello world";
        str2 = "I work";
        boolean result = str1.regionMatches(6, str2, 2, 3);
        System.out.println(result);

        str1 = "Hello world";
        System.out.println(str1.indexOf('l'));
        System.out.println(str1.indexOf("wo"));
        System.out.println(str.lastIndexOf('l'));

        str = "Hello world";
        System.out.println(str.startsWith("my"));
        System.out.println(str.endsWith("exe"));

        System.out.println(str.replace("l", "d"));
        System.out.println(str.replace("Hello", "Bye"));

        str = "   hello world   ";
        System.out.println(str.trim());

        str = "Hello world";
        System.out.println(str.substring(6));
        System.out.println(str.substring(3, 5));

        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        
        String text = "Я люблю язык Java!";
        String[] words = text.split(" ");
        for (String word : words) System.out.print(word + " ");
    }
}
