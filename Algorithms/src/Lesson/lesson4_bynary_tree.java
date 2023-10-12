package Lesson;

/*
Бинарное дерево - частный случай дерева, где все элементы обязательно строго уникальны, каждый родитель имеет не более
2 детей, при этом левый ребёнок всегда меньше родителя, а правый - больше. Засчёт этого не пригодна для работы с
иерархией в компании или с отображением файловой системы. Но есть и свои плюсы. Например, для поиска элемента бинарное
дерево не нужно перебирать целиком, ибо находясь на каждом узле, мы всегда точно понимаем, где именно мы будем искать
элемент. Поэтому бинарные деревья используются для хранения одного типа данных и ускоренного доступа к ним.
Частным случаем бинарного дерева для таких задач является сбалансированное дерево, у которого выполняется следующее
требование: для любого узла дерева высота его правого поддерева отличается от высот левого поддерева не более чем на
единицу. Сбалансированное дерево даёт нам идеальную структуру для бинарного поиска. Корень такого дерева - это его
центральный элемент. Количество элементов справа и слева от него различается не более чем на единицу, что характерно для
выбора стартовой позиции в бинарном поиске. Таким образом, сложность поиска по сбалансированному дереву составляет
O(log(n)), что даёт очень высокую производительность. Сбалансированное дерево также имеет особенности: если мы добавляем
в него элемент, то мы должны всегда чётко понимать, куда конкретно внутри нашего дерева требуется добавить элемент,
чтобы оно сохраняло свою сбалансированность, поэтому для любого сбалансированного дерева характерны любые операции
балансировки, чтобы при динамическом расширении данного дерева мы сохраняли свойства и скорость поиска.
Существуют различные типы балансировки. Самым классическим и базовым является AVL-дерево, оно имеет сложную формулу
балансировки, но оно позволяет гарантированно создавать корректно сбалансированное дерево с разницей глубины каждого
поддерева не более единицы. Для совершения этих операций каждая нода хранит помимо информации о своём значении и детях,
также дополнительно будет хранить информацию о своей глубине. И на основе информации о глубине происходит определённый
анализ, который для каждой операции вставки или удаления будет производить корректировку узлов в случае необходимости.

Рассмотрим красно-чёрное дерево:
1) каждый узел может быть либо чёрным, либо красным и иметь двух потомков;
2) корень всегда чёрный;
3) дети красного узла обязательно чёрные;
4) для частного случая - левостороннее красно-чёрное дерево - также применяется критерий: красный узел может быть только
левым потомком.
*/

public class lesson4_bynary_tree {
    private Node root;

    private enum Color{  // Заводим цвета для нашего дерева
        RED, BLACK
    }

    private class Node{
        private int value;
        private Color color;
        private Node leftChild;
        private Node rightChild;

        @Override
        public String toString(){
            return "NodeRB{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }
    public boolean addNode(Node node, int value){  // Метод добавляет нам новые ноды. Метод возвращает булева-значение,
        // ибо в бинарном дереве все значения должны быть уникальны, и если в нашем дереве существует нода с таким
        // значением, создать новую будет нельзя.
        if (node.value == value){
            return false;
        } else {
            if (node.value > value){
                if (node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;  // При создании все ноды получают красный цвет.
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else{
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private void colorSwap(Node node){  // Метод изменения цвета. Родитель получает красный цвет, а его правый и левый
        // ребёнок - чёрные.
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node leftSwap(Node node){  // Метод для перестановки левого ребёнка.
        Node leftChild = node.leftChild;  // Выделяем левого ребёнка как отдельную переменную для удобства.
        Node betweenChild = leftChild.rightChild;  // Этот элемент будет менять своего родителя, ибо родители будут
        // меняться местами, относительно родитель и ребёнок.
        leftChild.rightChild = node;  // Т.к. это левосторонний поворот, то эта нода у нас красная, соответственно,
        // вместо правого ребёнка красной ноды мы назначаем наш root-элемент, с которого мы начали (т.е. с текущего
        // родителя).
        node.leftChild = betweenChild;  // У родителя левы элемент становится не красный нод, на который мы ранее
        // ссылались, а промежуточный ребёнок, который согласно бинарному дереву имеет значение между красной нодой и
        // root-нодой.
        leftChild.color = node.color;  // В свою очередь, левый ребёнок получает цвет своего родителя.
        node.color = Color.RED;  // А сам корень, который был корнем, но опустился ниже, обязательно становится красным.
        return leftChild;
    }

    private Node rightSwap(Node node){  // Аналогичный методу выше, но меняем правого ребёнка.
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    (result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED)){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    (result.rightChild != null && result.rightChild.color == Color.RED)){
                needRebalance = true;
                colorSwap(result);
            }
        }
        while(needRebalance);
        return result;
    }

    public boolean add (int value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }
}
