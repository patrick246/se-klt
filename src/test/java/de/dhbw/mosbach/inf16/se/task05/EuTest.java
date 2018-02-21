package de.dhbw.mosbach.inf16.se.task05;

import org.junit.Test;

public class EuTest extends CounterTest {
    @Test
    public void testValidPassport() {
        super.testValidPassport(new EUCounter(null), Passport.Type.EU);
    }

    @Test
    public void testInvalidPassport() {
        super.testInvalidPassport(new EUCounter(null), Passport.Type.EU);
    }
}
