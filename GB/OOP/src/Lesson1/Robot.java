package Lesson1;

import java.util.ArrayList;

public class Robot {
    enum State {
        On, Off
    }

    private static int defaultIndex;
    private static ArrayList<String> names;

    static {
        defaultIndex = 1;
        names = new ArrayList<String>();
    }

    /** Уровень робота */
    private int level;
    /** Имя робота */
    private String name;

    private State state;

    /**
     * Создание робота
     * @param name Имя робота! Не должно начинаться с цифры
     * @param level Уровень робота
     */
    private Robot(String name, int level) {
        if (
                (name.isEmpty()
                || Character.isDigit(name.charAt(0)))
                || Robot.names.contains(name)
        ) { this.name = String.format("DefaultName_%d", defaultIndex++); }
        else { this.name = name; }

        Robot.names.add(this.name);
        this.level = level;
        this.state = State.Off;
    }

    public Robot(String name) { this(name, 1); }

    public Robot() { this(""); }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void power() {
        if (this.state == State.Off) {
            this.powerOn();
            this.state = State.On;
        } else {
            this.powerOff();
            this.state = State.Off;
        }
        System.out.println();
    }

    /** Метод включения систем */
    private void powerOn() {
        this.startBIOS();
        this.startOS();
        this.sayHi();
    }

    /** Метод выключения систем */
    private void powerOff() {
        this.sayBye();
        this.stopOS();
        this.stopBIOS();
    }

    /** Загрузка BIOS */
    private void startBIOS() { System.out.println("Start BIOS..."); }

    /** Загрузка OS */
    private void startOS() { System.out.println("Start OS..."); }

    /** Приветствие */
    private void sayHi() { System.out.println("Hello World..."); }

    /** Прощание */
    private void sayBye() { System.out.println("Goodbye World..."); }

    /** Выгрузка BIOS */
    private void stopBIOS() { System.out.println("Stop BIOS..."); }

    /** Выгрузка OS */
    private void stopOS() { System.out.println("Stop OS..."); }
}
