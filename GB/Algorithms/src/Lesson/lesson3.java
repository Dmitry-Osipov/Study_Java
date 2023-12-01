package Lesson;

/*
Связанный список - это базовая структура данных, состоящая из узлов, где каждый узел содержит одну или две ссылки,
который ссылаются на следующий или на следующий и предыдущий узел соответственно. Связанный список очень похож на
массив, но работает не по принципу индексации каждого элемента, а по принципу связи элементов друг с другом. Связанные
списки бывают однонаправленными и двунаправленными (однонаправленные ссылаются на следующий, а двунаправленные на
предыдущий и следующий элемент списка).

 Head                          Tail
Узел 1 -> Узел 2 -> Узел 3 -> Узел 4 - однонаправленный
  1         3         2         4

 Head                             Tail
Узел 1 <-> Узел 2 <-> Узел 3 <-> Узел 4 - двунаправленный
  1          3          2          4

Сложность поиска элемента - O(n), т.к. поиск любой ноды требует перебора элементов. Использование бинарного поиска не
даёт выгоды, т.к. обращение по индексам с константой скоростью недоступно. Также важно особенностью является вставка
элементов. Вставка элемента в массив занимает O(n), в то время как вставка в связанный список O(1). При этом поиск места
вставки может занимать O(n).

Аналогично со сложностью удаления элемента. Удаление элемента из массива O(n), удаление элемента из связанного списка -
O(1), при этом поиск удаляемой ноды может занимать O(n).

Преимущества связанного списка:
- Массовые вставки и удаления в конец/начало списка;
- Массовые вставки и удаления в середину списка, если операция поиска выполняется единожды;
- Динамическая расширяемость.

Разворот:

 Head                          Tail
Узел 1 -> Узел 2 -> Узел 3 -> Узел 4
  1         3         2         4
                |
                V
 Head                          Tail
Узел 1 <- Узел 2 <- Узел 3 <- Узел 4
  1         3         2         4

Разворот связанного списка говорит нам о том, что раньше было head должно стать tail, и наоборот. При этом все ссылки
соседних элементов должны произвести обмен, т.е. next станет previous и наоборот. Проще всего писать разворот связанного
списка на двусвязном списке, ибо у нас есть ссылки на следующий и прошлый элемент.

Частные случаи связанного списка:
- Стэк - работает по принципу LIFO - Last In - First out;
- Очередь - работает по принципу FIFO - First In - First out.

Когда мы говорим про стэк, то идеально подходит односвязный список. Реализуем ниже 2 метода, которые характерны только
для стэка - push (положить данные) и pop (извлечь данные).
*/
public class lesson3 {   // Сам список содержит ссылку только на первую и последнюю позицию.
    Node head;  // Ссылка на первую позицию.
    Node tail; // Ссылка на последнюю позицию.

    public void pushStack (int value){  // Метод для стэка. Будет добавлять интересующее нас значение в начало стэка.
        Node node = new Node();
        node.value = value;
        node.next = head;  // Добавляем элемент в начало списка.
        head = node;
    }

    public Integer popStack (){  // Метод для стэка. Будет извлекать данные из стэка.
        Integer result = null;
        if (head != null) {
            result = head.value;  // Забираем элемент из стэка.
            head = head.next;
        }
        return result;
    }

    public void pushQueue (int value){  // Метод для очереди. Будет добавлять интересующее нас значение в начало очереди
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek (){  // Метод для очереди. Будет извлекать данные из очереди.
        Integer result = null;
        if (tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

    public void add(int value){  // Реализуем операцию вставки в связанный список. Будем добавлять в конец связанного
        // списка. Т.к. используем двусвязный список (в public class Node есть ссылки на next и previous, мы можем
        // добавлять элемент, обращаясь напрямую к tail. При этом если список пустой, то нужно создать head и tail ноды.
        Node node = new Node();
        node.value = value;
        if (head == null){  // Проверяем, есть ли значение для head.
            head = node;
            tail = node;  // Не допускаем ситуации, когда будет заполнен head, но не заполнен tail.
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    public void add (int value, Node node){  // Т.к. мы благодаря функции find нашли интересующую нас ноду, дальше мы
        // можем добавлять какие-то значения. Т.к. мы имеем ссылку на ноду, каждая нода имеет ссылку на next и previous,
        // то сы должны лишь встроиться в текущую цепочку и вставить интересующее нас значение.
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null){
            tail = newNode;  // Технически, если у элемента связанного списка нет следующего объекта, значит это
            // последний объект и его переменная должна лежать в tail.
        } else{
            next.previous = newNode;
            newNode.next = next;
        }
    }

    public void delete (Node node){  // Создадим функцию по удалению ноды. Аргументом принимаем ноду, которую требуется
        // удалить.
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null){  // Если удаляем head.
            next.previous = null;
            head = next;
        } else{
            if (next == null){  // Если удаляем tail.
                previous.next = null;
                tail = previous;
            } else{
                previous.next = next;  // Удаляем информацию о нашей ноде из связанного списка.
                next.previous = previous;  // Данный алгоритм работает при условии, что мы удаляем не head или tail.
            }
        }
    }

    // Чтобы найти элемент в нашем списке, нам необходимо пройтись по всем элементам, начиная с начала списка.
    public Node Find (int value){  // Т.к. нет индексов, мы будем использовать цикл while для перебора всех доступных
        // детей, пока они у нас существуют - пока node next заполняется.
        Node currentNode = head;
        while (currentNode != null){  // До тех пор, пока currentNode существует.
            if (currentNode.value == value){
                return currentNode;  // Возвращаем currentNode с нужным значением.
            }
            currentNode = currentNode.next;  // Если нужного значения нет, то переходим к следующему значению списка.
        }
        return null;  // Если мы прошлись по всем элементам и не нашли значение, возвращаем null.
        // Особенностью данного перебора служит сложность. Она также O(n) - классическая сложность перебора списка. Но
        // следует учитывать то, что т.к. мы имеем ссылку на head или head и tail, у нас нет возможности обратиться к
        // элементу в середине списка по O(1), как это делается у классического массива, из-за отсутствия индексов,
        // отсутствия прямой ссылки на данный элемент.
    }

    public void revert (){  // Функция для разворота списка.
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null){
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    private void revert_one (Node currentNode, Node previousNode){  // Пишем функцию разворота для однонаправленного
        // связанного списка. Т.к. для пользователя она не особо красивая, то реализуем публичную функцию ниже.
        if (currentNode.next == null){
            head = currentNode;
        } else{
            revert_one(currentNode.next, currentNode);  // Рекурсивно запускаем функцию разворота.
        }
        currentNode.next = previousNode;
    }

    public void revertOne(){  // Есть маленький нюанс: разворот следует запускать, когда у нас есть хотя бы 2 ноды, если
        // есть только head, то разворачивать его смысла нет, операцию можно пропустить. Если список пустой и нет даже
        // head, то его и смысла разворачивать нет.
        if (head != null && head.next != null){
            Node temp = head;
            revert_one(head.next, head);
            temp.next = null;
        }
    }

    public class Node {  // Это заранее созданный класс в Java для связанных списков.
        int value;  // Нужное значение.
        Node next;  // Описывает следующий элемент нашего списка.
        Node previous;  // Описывает предыдущий элемент нашего списка.
    }
}