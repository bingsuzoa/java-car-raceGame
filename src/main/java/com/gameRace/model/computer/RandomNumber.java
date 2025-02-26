package com.gameRace.model.computer;


public class RandomNumber implements Computer {
    @Override
    public int makeNumber() {
        return (int) (Math.random() * 10);
    }
}
