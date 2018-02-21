package de.dhbw.mosbach.inf16.se.task05;

import org.junit.Test;

public class DiplomatTest extends CounterTest {

    @Test
    public void testValidPassport() {
        super.testValidPassport(new DiplomatCounter(null), Passport.Type.Diplomat);
    }

    @Test
    public void testInvalidPassport() {
        super.testInvalidPassport(new DiplomatCounter(null), Passport.Type.Diplomat);
    }
}
