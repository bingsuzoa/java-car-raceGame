package com.gameRace.model;

import com.gameRace.model.condition.Condition;

public class Car {
    private String name;
    private final Condition condition;
    private int position;

    public Car(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
        this.position = 1;
    }

    public String getName() {
        return name;
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
