package Lesson;

import java.util.ArrayList;
import java.util.List;

/*
Дерево - это структура данных, представленная в виде набора связанных узлов. Для дерева характерно следующее: самый
верхний узел, который не имеет родителей, - это корень. Все элементы дерева - это узлы. При этом узлы, которые не
имеют детей, - это листья. Для деревьев нехарактерен двусвязный формат, ибо зачастую, мы не храним ссылки на наши листы,
а любой обход будет начинаться с корня, соответственно, вверх по дереву в большинстве случаев нам ходить не нужно.

Как можно работать с деревом?
Обход в глубину - это рекурсивный обход узлов дерева (самый часто используемый и самый простой).

Обход в ширину - циклический обход узлов дерева. В нём мы проверяем каждый уровень нашего дерева отдельно. Сначала root,
потом всех его детей, потом всех детей их детей и т.д.

Следующая структура данных - это хэш-таблица.
Хэш-таблица представляет собой ассоциативный массив, использующий хэш-функцию для выполнения операций добавления,
удаления и поиска элементов.
В свою очередь ассоциативным массивом называют структуру данных, которая хранит пару ключ-значение, где ключ каждой пары
является уникальным в пределах всего массива данных.
Огромным плюсом хэш-таблиц является сложность операций с ними - O(1).
Скорость работы хэш-таблицы обусловлена хэш-функцией. Хэш-функция - это специальный алгоритм, позволяющий преобразовать
входные данные произвольного размера и состава в битовую строку фиксированной длины. Популярные хэш-алгоритмы: MD5,
SHA-1, SHA-256, SHA-384, SHA-512.
При этом, хэш-функция является необратимой. Из хэша назад получить значение невозможно, потому что каждому хэшу может
соответствовать большое количество значений. Именно поэтому это называется односторонней функцией. Само по себе
хэширование очень популярно. Почти всё шифрование использует ту или иную хэш-функцию.
*/

public class lesson4 {
    Node root;  // Это начало нашего дерева.

    public class Node{
        int value;
        List<Node> children;
    }

    /*
    Обход в глубину. Создадим функции для возвращения информации, существует ли данное значение в нашей структуре.
    Первая функция будет искать интересующую нас ноду, а вторая - публичная функция, которая будет отображать,
    получилось ли найти ноду (если да, то возвращаем значение). Плюсы данного подхода в том, что рекурсия внутри
    дерева не является ресурсо-затратной операцией, ибо дерево не используется для огромных объёмов данных.
    */
    private Node findDeep(Node node,int value){  // Указали ноду, которую будем проверять (ибо функция рекурсивная),
                                                 // а также искомое значение.
        if (node.value == value){
            return node;
        } else {  // Если текущая нода не является искомой, то уходим в поиск её детей.
            for (Node child : node.children) {  // Перебираем каждого ребёнка.
                Node result = findDeep(child, value);  // Для каждого ребёнка рекурсивно запускаем функцию поиска.
                if (result != null){  // Если хотя бы одна из нод получит нужное значение, то мы вернём ноду.
                    return result;
                }
            }
        }
        return null;
    }

    public boolean existDeep(int value){
        if (root != null) {
            Node node = findDeep(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    /*
    Обход в ширину - используются исключительно циклы, что является плюсом, если мы имеем огромное дерево. Один из
    минусов данного обхода - это необходимость помнить о всех элементах на указанном уровне. Необходимо создать в памяти
    некий объект, в котором будут ссылки на все текущие ноды и на все будущие ноды, если мы говорим про сохранение
    детей. Тем самым с точки зрения памяти этот процесс более ресурсо-затратный, чем классическая рекурсия при обходе в
    глубину, ибо эта рекурсия хранит минимальное количество данных, необходимых для обхода нашего списка.
    */
    private Node findWidth(int value){
        List<Node> line = new ArrayList<>();
        line.add(root);  // По умолчанию добавляем root, ибо именно с него мы и начинаем работать.
        while (line.size() > 0){  // Пока в нашем дереве существуют дети, мы будем работать.
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line){
                if (node.value == value){
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;  // Обновляем линию и перезапускаем цикл.
        }
        return null;
    }
}
