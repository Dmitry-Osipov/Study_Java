package Lesson4;

import java.util.ArrayList;
import java.util.LinkedList;

public class Homework {
    public static void main(String[] args) {
        // Напишите метод, который принимает на вход связанный список, а возвращает перевёрнутый связанный список.
        LinkedList<Object> myList = new LinkedList<>();
        myList.add(1);
        myList.add("One");
        myList.add(2);
        myList.add("Two");
        System.out.println(revert(myList));

        // В классе MyQueue реализуйте очередь с помощью LinkedList со следующими методами:
        // enqueue() - помещает элемент в конец очереди;
        // dequeue() - возвращает первый элемент из очереди и удаляет его;
        // first() - возвращает первый элемент из очереди, не удаляя;
        // getElements() - возвращает все элементы в очереди.
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(5);

        System.out.println(queue.getElements());

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.first());

        // В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
        //Отмена последней операции должна быть реализована следующим образом: если передан оператор '<' калькулятор
        // должен вывести результат предпоследней операции.
        System.out.println(Calculator.calculate('+', 3, 7));
        System.out.println(Calculator.calculate('+', 4, 7));
        System.out.println(Calculator.calculate('<', 0, 0));

        System.out.println(Calculator.calculate('*', 3, 2));
        System.out.println(Calculator.calculate('-', 7, 4));
        System.out.println(Calculator.calculate('<', 0, 0));
    }

    public static LinkedList<Object> revert(LinkedList<Object> ll) {
        LinkedList<Object> llNew = new LinkedList<>();
        for (Object item : ll) llNew.addFirst(item);

        return llNew;
    }


    static class MyQueue<T> {
        LinkedList<T> userList = new LinkedList<>();

        public void enqueue(T element) {
            userList.add(element);
        }

        public T dequeue() {
            return userList.removeFirst();
        }

        public T first() {
            return userList.getFirst();
        }

        public LinkedList<T> getElements() {
            return userList;
        }
    }

    static class Calculator {
        static ArrayList<Integer> calculateResults = new ArrayList<>();

        public static int calculate(char op, int a, int b) {
            int result;
            switch (op) {
                case '+' -> {
                    result = a + b;
                    calculateResults.add(result);
                }
                case '-' -> {
                    result = a - b;
                    calculateResults.add(result);
                }
                case '*' -> {
                    result = a * b;
                    calculateResults.add(result);
                }
                case '/' -> {if (b != 0) {
                    result = a / b;
                    calculateResults.add(result);
                    } else {return -1;}
                }
                case '<' -> {return calculateResults.get(calculateResults.size() - 2);}
                default -> {return -1;}
            }

            return result;
        }
    }
}
