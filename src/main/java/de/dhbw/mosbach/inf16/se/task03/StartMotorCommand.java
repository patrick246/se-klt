package de.dhbw.mosbach.inf16.se.task03;

public class StartMotorCommand {
    private IMotor motor;

    public StartMotorCommand(IMotor motor) {
        this.motor = motor;
    }

    public void execute() {
        motor.start();
    }
}
