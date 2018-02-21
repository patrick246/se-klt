package de.dhbw.mosbach.inf16.se.task05;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CounterTest {

    protected void testValidPassport(ICounter counter, Passport.Type type) {
        Passport passport = new Passport(type, true);

        counter.subscribe((ICounter c, Passport p) -> assertTrue("Handler should not be called", true));
        counter.checkPassport(passport);
    }

    protected void testInvalidPassport(ICounter counter, Passport.Type type) {
        Passport passport = new Passport(type, false);

        final boolean[] called = {false};
        counter.subscribe((ICounter c, Passport p) -> called[0] = true); // Workaround as only final values can be used in lambdas

        counter.checkPassport(passport);

        assertThat(called[0], is(true));
    }


    @Test
    public void testChaining() {
        DiplomatCounter diplomatCounter = new DiplomatCounter(null);
        NEUCounter neuCounter = new NEUCounter(diplomatCounter);
        EUCounter euCounter = new EUCounter(neuCounter);

        Passport diplomat = new Passport(Passport.Type.Diplomat, false);
        Passport nonEU = new Passport(Passport.Type.NonEU, false);
        Passport eu = new Passport(Passport.Type.EU, false);

        final boolean[] diplomatCalled = {false};
        final boolean[] nonEUCalled = {false};
        final boolean[] euCalled = {false};

        diplomatCounter.subscribe((c, p) -> {
            diplomatCalled[0] = true;
            assertThat(p.getType(), is(Passport.Type.Diplomat));
        });

        neuCounter.subscribe((c, p) -> {
            nonEUCalled[0] = true;
            assertThat(p.getType(), is(Passport.Type.NonEU));
        });

        euCounter.subscribe((c, p) -> {
            euCalled[0] = true;
            assertThat(p.getType(), is(Passport.Type.EU));
        });

        euCounter.checkPassport(diplomat);
        euCounter.checkPassport(nonEU);
        euCounter.checkPassport(eu);

        assertThat(diplomatCalled[0], is(true));
        assertThat(nonEUCalled[0], is(true));
        assertThat(euCalled[0], is(true));
    }
}

