package de.dhbw.mosbach.inf16.se.task03;

public class StopMotorCommand {

    private IMotor motor;

    public StopMotorCommand(IMotor motor) {
        this.motor = motor;
    }

    public void execute() {
        motor.stop();
    }
}
