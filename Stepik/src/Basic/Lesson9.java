package Basic;

public class Lesson9 {
    public static void main(String[] args) {
        int var = 121;
        int not_v = ~var;
        System.out.println(not_v);

        byte flags = 5;
        byte mask = 4;
        int res = flags & mask;
        System.out.println(res);

        if ((flags & mask) == mask) System.out.println("Включён 2-ой бит числа");
        else System.out.println("2-ой бит выключен");

        flags = 13;
        mask = 5;
        flags = (byte) (flags & ~mask);
        System.out.println(flags);

        flags = 8;
        flags |= mask;
        System.out.println(flags);

        flags = 9;
        mask = 1;
        flags ^= mask;
        System.out.println(flags);
        flags ^= mask;
        System.out.println(flags);

        String msg = "Привет мир!";
        byte key = 111;
        char[] str = msg.toCharArray();
        for (int i = 0; i < msg.length(); i++) str[i] ^= key;
        msg = new String(str);
        System.out.println(msg);

        int x = 160;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x >>= 1;
        System.out.println(x);
        x <<= 1;
        System.out.println(x);
        x <<= 1;
        System.out.println(x);
        x <<= 1;
        System.out.println(x);
        x <<= 1;
        System.out.println(x);
        x <<= 1;
        System.out.println(x);
        x <<= 1;
        System.out.println(x);
    }
}
