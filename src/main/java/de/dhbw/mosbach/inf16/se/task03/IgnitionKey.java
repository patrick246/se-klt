package de.dhbw.mosbach.inf16.se.task03;

public class IgnitionKey {
    private CommandFactory factory;

    public IgnitionKey(CommandFactory factory) {
        this.factory = factory;
    }

    public void turnForward() {
        StartMotorCommand command = factory.createStartCommand();
        command.execute();
    }

    public void turnBack() {
        StopMotorCommand command = factory.createStopCommand();
        command.execute();
    }
}
