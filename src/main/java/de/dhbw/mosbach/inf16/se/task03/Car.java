package de.dhbw.mosbach.inf16.se.task03;

public class Car {
    private IMotor motor;
    private IgnitionKey key;

    public Car(IMotor motor, IgnitionKey key) {
        this.motor = motor;
        this.key = key;
    }

    public IMotor getMotor() {
        return motor;
    }

    public IgnitionKey getKey() {
        return key;
    }
}
