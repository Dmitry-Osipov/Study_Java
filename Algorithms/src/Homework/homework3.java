package Homework;

/*
Домашнее задание:
Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево, а также
реализовать в нем метод добавления новых элементов с балансировкой.
Красно-черное дерево имеет следующие критерии:
● Каждая нода имеет цвет (красный или черный);
● Корень дерева всегда черный;
● Новая нода всегда красная;
● Красные ноды могут быть только левым ребенком;
● У красной ноды все дети черного цвета.
Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести
балансировку, благодаря которой все критерии выше станут валидными.
Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.
Критерии применения операций по смене цвета, левому и правому повороту следующие:
● Если правый ребенок – красный, а левый - черный, то применяем правый поворот;
● Если левый ребенок красный и его левый ребенок тоже красный – применяем левый поворот;
● Если оба ребенка красные – делаем смену цвета;
● Если корень стал красным – просто перекрашиваем его в черный.
*/
public class RedBlackNode {
    public static final String RED = "RED";
    public static final String BLACK = "BLACK";

    public int value;
    public RedBlackNode left;
    public RedBlackNode right;
    public String color;

    public RedBlackNode(int value) {
        if (!(value instanceof Integer)) {
            throw new IllegalArgumentException("Значение для добавления в красно-чёрное дерево должно быть целочисленным");
        }

        this.value = value;
        this.left = null;
        this.right = null;
        this.color = RED;
    }
}

public class RedBlackTree {
    public RedBlackNode root;

    public void insertWithBalance(int value) {
        root = insertRecursive(root, value);
    }

    public RedBlackNode search(int value) {
        return searchRecursive(root, value);
    }

    public void traverseInorder() {
        traverseInorderRecursive(root);
    }

    private RedBlackNode insertRecursive(RedBlackNode node, int value) {
        if (node == null) {
            return new RedBlackNode(value);
        }

        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }

        return balance(node);
    }

    private RedBlackNode searchRecursive(RedBlackNode node, int value) {
        if (node == null || node.value == value) {
            return node;
        }

        if (value < node.value) {
            return searchRecursive(node.left, value);
        } else {
            return searchRecursive(node.right, value);
        }
    }

    private RedBlackNode balance(RedBlackNode node) {
        if (node == null) {
            return null;
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if (isRed(node.right)) {
            node = rotateLeft(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private boolean isRed(RedBlackNode node) {
        return node != null && node.color.equals(RED);
    }

    private RedBlackNode rotateLeft(RedBlackNode node) {
        RedBlackNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.color = node.color;
        node.color = RED;
        return newRoot;
    }

    private RedBlackNode rotateRight(RedBlackNode node) {
        RedBlackNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.color = node.color;
        node.color = RED;
        return newRoot;
    }

    private void flipColors(RedBlackNode node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }
}
