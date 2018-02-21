package de.dhbw.mosbach.inf16.se.task03;

public class CommandFactory {
    private IMotor motor;

    public CommandFactory(IMotor m) {
        motor = m;
    }

    public StartMotorCommand createStartCommand() {
        return new StartMotorCommand(motor);
    }

    public StopMotorCommand createStopCommand() {
        return new StopMotorCommand(motor);
    }
}
