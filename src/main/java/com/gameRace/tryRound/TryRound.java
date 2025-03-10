package com.gameRace.tryRound;


public class TryRound {
    private final int tryRound;

    public TryRound(String tryRound) {
        if(!tryRound.matches("^[1-9][0-9]*$")) {
            throw new InvalidTryNumberException();
        }
        this.tryRound = Integer.parseInt(tryRound);
    }

    public int getTryRound() {
        return tryRound;
    }
}
