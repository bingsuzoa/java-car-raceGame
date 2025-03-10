package com.gameRace.car;

import java.util.Random;

public class Car {
    private final String name;
    private int raceCount;
    private final Random random;

    public Car(String name) {
        this.name = name;
        this.raceCount = 0;
        random = new Random();
    }

    public String getName() {
        return name;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public void startRound() {
        goOrStop();
    }

    private void goOrStop() {
        int number = random.nextInt(9) + 1;
        if(number >= 4) {
            raceCount ++;
        }
    }


}
