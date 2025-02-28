package com.gameRace.model.condition;


public class RandomCondition implements Condition {
    @Override
    public boolean canMove() {

        return Math.random() * 10 >= 4;
    }
}
