package com.gameRace.model.car;

import com.gameRace.view.Message;

import java.util.Random;

public class Car {
    private final String name;
    private int position;
    private final Random random;

    public Car(String name) {
        this.name = name;
        this.position = 1;
        random = new Random();
    }

    public String getName() {
        return name;
    }

    public int getRaceCount() {
        return position;
    }

    public String getRaceCountResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(Message.CAR.getMessage());
        }
        return stringBuilder.toString();
    }

    public void startRound() {
        goOrStop();
    }

    private void goOrStop() {
        int number = random.nextInt(9) + 1;
        if (number >= 4) {
            position++;
        }
    }


}
