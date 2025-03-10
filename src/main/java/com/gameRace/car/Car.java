package com.gameRace.car;

import com.gameRace.view.Message;

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

    public String getRaceCountResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < raceCount; i++) {
            stringBuilder.append(Message.CAR.getMessage());
        }
        return stringBuilder.toString();
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
