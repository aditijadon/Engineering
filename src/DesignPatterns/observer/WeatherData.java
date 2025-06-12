package DesignPatterns.observer;

public class WeatherData {
    int temperature;
    int humidity;
    int pressure;

    public WeatherData(int temperature, int humidity, int pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void measurementsChanged(){

    }

}
