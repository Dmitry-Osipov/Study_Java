package Lesson1;

public class Lesson {
    public static void main(String[] args) {
        Point2D a = new Point2D(0, 2);
        System.out.println("Y-координата для точки a = " + a.getY());
        System.out.println("Координаты точки a -> " + a);

        Point2D b = new Point2D(10);
        b.setX(20);
        System.out.println("Координаты точки b -> " + b);

        Point2D c = new Point2D();
        System.out.println("Координаты точки c -> " + c);

        System.out.println("Расстояние между точками a и b: " + Point2D.distance(a, b));

        // -------------------------------------------------------------------------------------------------------------
        Robot chappy = new Robot("Chappy");
        System.out.println(chappy.getName() + " " + chappy.getLevel());
        chappy.power();
        chappy.power();

        // -------------------------------------------------------------------------------------------------------------
        Magician hero1 = new Magician();
        System.out.println(hero1.getInfo());

        Priest hero2 = new Priest();
        System.out.println(hero2.getInfo());

        Priest hero3 = new Priest();
        System.out.println(hero3.getInfo());

        hero3.GetDamage(hero2.Attack());
        hero3.GetDamage(hero3.Attack());
        System.out.println(hero3.getInfo());
        System.out.println(hero2.getInfo());
        //hero3.GetDamage(hero3.Attack());
    }
}
