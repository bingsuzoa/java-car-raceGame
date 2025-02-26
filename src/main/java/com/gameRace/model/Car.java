package com.gameRace.model;

public class Car {
    private int moveCount;

    public Car() {
        this.moveCount = 1;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void getNumberAndMove(int number) {
        move(number);
    }

    private void move(int number) {
        if(number >= 4) {
            moveCount++;
        }
    }
}
