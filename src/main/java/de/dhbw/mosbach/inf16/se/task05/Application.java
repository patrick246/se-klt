package de.dhbw.mosbach.inf16.se.task05;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();

        DiplomatCounter diplomatCounter = new DiplomatCounter(null);
        NEUCounter neuCounter = new NEUCounter(diplomatCounter);
        EUCounter euCounter = new EUCounter(neuCounter);

        FederalPolice police = new FederalPolice(Arrays.asList(euCounter, neuCounter, diplomatCounter));

        Stream.generate(() -> new Passport(
                Passport.Type.values()[random.nextInt(3)],
                random.nextDouble() < 0.9)
        )
        .forEach(euCounter::checkPassport);

    }
}
