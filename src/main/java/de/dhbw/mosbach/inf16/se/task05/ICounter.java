package de.dhbw.mosbach.inf16.se.task05;

public interface ICounter {
    void checkPassport(Passport passport);
    void subscribe(ICounterHandler handler);
}
