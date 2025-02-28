package com.gameRace.model;

import com.gameRace.model.computer.Computer;

public class Car {
    private final Computer computer;
    private int moveCount;

    public Car(Computer computer) {
        this.computer = computer;
        this.moveCount = 1;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void decideMoveOrStop() {
        addMoveCount();
    }

    private void addMoveCount() {
        int randomNumber = computer.makeNumber();
        if (randomNumber >= 4) {
            moveCount++;
        }
    }
}
