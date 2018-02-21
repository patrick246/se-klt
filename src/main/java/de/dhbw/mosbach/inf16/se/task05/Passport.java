package de.dhbw.mosbach.inf16.se.task05;

public class Passport {
    enum Type {
        EU,
        NonEU,
        Diplomat
    }

    private final Type type;
    private final boolean valid;

    public Passport(Type type, boolean valid) {
        this.type = type;
        this.valid = valid;
    }

    public Type getType() {
        return type;
    }

    public boolean isValid() {
        return valid;
    }
}
