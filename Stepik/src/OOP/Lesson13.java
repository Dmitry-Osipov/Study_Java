package OOP;

public class Lesson13 {
    public static void main(String[] args) {
        Button btnCopy = new Button() {  // Создали анонимный внутренний класс.
            @Override
            public void click() { System.out.println("Копирование данных"); doSome(); }

            public void doSome() { System.out.println("do something"); }  // Новые методы в анонимных классах не
            // отработают снаружи, но они доступны внутри. Либо можно обойти это ограничение, если присвоить переменной
            // значение var - тогда переменной btnCopy будет присвоено не Button, а сам внутренний анонимный класс.
        };
        btnCopy.click();

        NewButton newButton = new NewButton(
                new EventHandler() {
                    @Override
                    public void execute() { System.out.println("Обработка нажатия"); }
                }  // Можно заменить лямбдой: () -> System.out.println("Обработка нажатия").
        );  // Работа с интерфейсами надёжнее, ибо они не участвуют в наследовании между классами, что обезопасит программу.
        newButton.click();
    }
}

class Button {
    public void click() {
        System.out.println("Нажатие на кнопку");
    }
}

class ButtonOpen extends Button {
    @Override
    public void click() {
        System.out.println("Открытие файла");
    }
}

interface EventHandler {
    void execute();
}

class NewButton {
    EventHandler handler;

    public NewButton(EventHandler handler) {
        this.handler = handler;
    }

    public void click() { handler.execute(); }
}
