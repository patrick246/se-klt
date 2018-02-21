package de.dhbw.mosbach.inf16.se.task05;

import java.util.ArrayList;
import java.util.List;

public class EUCounter implements ICounter {
    private List<ICounterHandler> handlers = new ArrayList<ICounterHandler>();
    private ICounter next;

    public EUCounter(ICounter next) {
        this.next = next;
    }

    public void checkPassport(final Passport passport) {
        if(passport.getType() == Passport.Type.EU) {
            if(!passport.isValid()) {
                handlers.forEach(h -> h.handleInvalid(this, passport));
            }
        } else {
            if(next != null) next.checkPassport(passport);
        }
    }

    public void subscribe(ICounterHandler handler) {
        handlers.add(handler);
    }
}
