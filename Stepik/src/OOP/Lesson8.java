package OOP;

public class Lesson8 {
    public static void main(String[] args) {
        MySubClass mySubClass = new MySubClass();
        mySubClass.getIds();
        System.out.println(mySubClass instanceof MyClass);  // Проверяем даунгрейд.
        MyClass myClass = new MyClass();
        myClass = (MyClass) new MySubClass();  // Апгрейд не нуждается в проверке и приведении типов.
    }
}

class MyClass {
    public int id = 2;
}

class MySubClass extends MyClass {
    public int id = 1;

    public  void getIds() {
        System.out.println("ID подкласса = " + id + ", ID базового класса = " + super.id);
    }
}
