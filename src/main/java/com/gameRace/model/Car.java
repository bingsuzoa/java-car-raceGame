package com.gameRace.model;

import com.gameRace.model.condition.Condition;

public class Car {
    private final Condition condition;
    private int position;

    public Car(Condition condition) {
        this.condition = condition;
        this.position = 1;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        addPosition();
    }

    private void addPosition() {
        if (condition.canMove()) {
            position++;
        }
    }
}
