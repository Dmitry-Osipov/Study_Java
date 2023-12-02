package OOP;

public class Lesson3 {
    public static void main(String[] args) {
        Rect1 rect1 = new Rect1(0, 0, 10, 20);
        Rect1 rect2 = new Rect1(40, 20, 100, 200);
        System.out.println(rect1.square());
        System.out.println(rect2.square());
        rect1.setCoords(4, 7, 12, 18);
        System.out.println(rect1.square());
        Rect1 rect3 = new Rect1();
        rect3.setCoords(12, 120, 120, -12);
        System.out.println(rect3.square());
        System.out.println(rect1.getX2());
    }
}

class Rect1 {
    private int x1, y1, x2, y2;
    private static final int MAX_COORD = 1000;

    public Rect1() {}

    public Rect1(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int square() {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    public void setCoords(int x1, int y1, int x2, int y2) {
        if (isCorrect(x1) && isCorrect(y1) && isCorrect(x2) && isCorrect(y2)) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private boolean isCorrect (int coord) {
        return (0 <= coord && coord <= MAX_COORD);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
