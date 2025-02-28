package com.gameRace.model;

import com.gameRace.model.computer.Computer;

public class Car {
    private final Computer computer;
    private int position;

    public Car(Computer computer) {
        this.computer = computer;
        this.position = 1;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        addPosition();
    }

    private void addPosition() {
        int randomNumber = computer.makeNumber();
        if (randomNumber >= 4) {
            position++;
        }
    }
}
