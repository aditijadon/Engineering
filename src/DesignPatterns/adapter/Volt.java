package DesignPatterns.adapter;

public class Volt {
    private int volts;

    Volt(int volts){
        this.volts = volts;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}
