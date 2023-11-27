package Lesson7.singleton;

public class Settings {
    private static Settings instance;
    private String param1;
    private int param2;
    private boolean param3;

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
            instance.param1 = "A";
            instance.param2 = 2;
            instance.param3 = true;
        }
        return instance;
    }

    // Метод не позволит создать экземпляр класса.
    private Settings(){
    }
}
