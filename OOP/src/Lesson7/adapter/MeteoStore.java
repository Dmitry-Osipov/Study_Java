package Lesson7.adapter;

public class MeteoStore {

    boolean save(MeteoSensor meteoSensor){
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %.2f ; humidity - %.2f ; pressure - %.2f \n\r",
                meteoSensor.getId(),
                meteoSensor.getDateTime(),
                meteoSensor.getTemperature(),
                meteoSensor.getHumidity(),
                meteoSensor.getPressure());
        return true;
    }

    /*boolean save(SensorTemperature meteoSensor){
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %.2f ; humidity - %.2f ; pressure - %.2f \n\r",
                meteoSensor.getIdentifier(),
                LocalDateTime.now(),
                meteoSensor.temperature(),
                0.0,
                0.0);
        return true;
    }*/

}
