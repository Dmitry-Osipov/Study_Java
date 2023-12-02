package OOP;

public class Lesson4 {
    public static void main(String[] args) {
        Rect2 rect1 = new Rect2(1, 2, 3 ,4);
    }
}

class Rect2 {
    private int x1, x2, y1, y2;

    public Rect2() {}

    public Rect2(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
}
