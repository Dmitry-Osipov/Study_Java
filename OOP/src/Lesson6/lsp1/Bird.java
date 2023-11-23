package Lesson6.lsp1;

/**
 * Тип T
 */
public class Bird {
    private int flySpeed = 25;
    protected boolean canFly = true;

    public int getFlySpeed() { return flySpeed; }

    public boolean isCanFly() { return canFly; }

    public void fly() { System.out.printf("Птица летит со скоростью %d км/ч\n", flySpeed); }
}
