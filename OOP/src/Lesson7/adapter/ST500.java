package Lesson7.adapter;

import java.util.Random;

public class ST500 implements SensorTemperature {

    private Random random = new Random();

    private int id;

    {
        id = random.nextInt(10001, 99999);
    }
    @Override
    public int getIdentifier() {
        return id;
    }

    @Override
    public double temperature() {
        return 30.1;
    }
}
