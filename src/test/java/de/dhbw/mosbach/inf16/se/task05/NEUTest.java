package de.dhbw.mosbach.inf16.se.task05;

import org.junit.Test;

public class NEUTest extends CounterTest {

    @Test
    public void testValidPassport() {
        super.testValidPassport(new NEUCounter(null), Passport.Type.NonEU);
    }

    @Test
    public void testInvalidPassport() {
        super.testInvalidPassport(new NEUCounter(null), Passport.Type.NonEU);
    }
}
