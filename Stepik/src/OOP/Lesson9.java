package OOP;

public class Lesson9 {
    public static void main(String[] args) {
        Line2 line1 = new Line2();
        System.out.println(line1.getId());
        line1.draw();

        Properties1 p = line1;
        p.draw();

        final int N = 2;
        Properties1[] properties1 = new Properties1[N];
        properties1[0] = new Line2();
        properties1[1] = new Properties1();

        for (Properties1 geom : properties1) geom.draw();
        line1.setName("Line");
        System.out.println(line1.getName());
    }
}

class Properties1 {  // Если прописать final, то его невозможно будет наследовать.
    protected int id = 0;
    protected String name = "";

    public Properties1() {
        id++;
    }

    public void draw(){
        System.out.println("Этот метод следует переопределить");
    }

    public final void setName(String name) {  // final запрещает переопределение, но разрешает использование в дочерних.
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Line2 extends Properties1 {
    protected int id = super.id;
    private int x, y;

    public Line2() {
        id++;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем линию...");
    }
}
