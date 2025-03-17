package com.gameRace.model.car;

import com.gameRace.model.condition.Condition;
import com.gameRace.view.Message;

public class Car {
    private final String name;
    private int position;
    private final Condition condition;

    public Car(String name, Condition condition) {
        this.name = name;
        this.position = 1;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getThisRoundResult() {
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
        int number = condition.getCondition();
        if (number >= 4) {
            position++;
        }
    }


}
