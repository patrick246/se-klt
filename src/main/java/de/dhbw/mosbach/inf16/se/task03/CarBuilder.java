package de.dhbw.mosbach.inf16.se.task03;

public class CarBuilder {

    enum MotorPS {
        PS75,
        PS90
    }

    private IMotor motor;

    public CarBuilder withMotorPS(MotorPS ps) {
        motor = getMotorWithPS(ps);
        return this;
    }

    public Car build() {
        if(motor == null) {
            throw new IllegalStateException("Can't build car without motor");
        }
        return new Car(motor, new IgnitionKey(new CommandFactory(motor)));
    }

    private IMotor getMotorWithPS(MotorPS ps) {
        switch (ps) {
            case PS75:
                return new Motor75PS();
            case PS90:
                return new Motor90PS();
            default:
                throw new IllegalArgumentException("Unknown MotorPS value");
        }
    }
}
