package de.dhbw.mosbach.inf16.se.task03;

public class Application {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .withMotorPS(CarBuilder.MotorPS.PS75)
                .build();
        car.getKey().turnForward();
        car.getKey().turnBack();
    }
}
