package de.dhbw.mosbach.inf16.se.task05;

import java.util.List;

public class FederalPolice implements ICounterHandler {
    public FederalPolice(List<ICounter> counters) {
        counters.forEach(c -> c.subscribe(this));
    }

    public void handleInvalid(ICounter counter, Passport passport) {
        System.out.println("Detected invalid passport at " + counter.getClass().getSimpleName() + ": " + passport.getType().toString());
    }
}

