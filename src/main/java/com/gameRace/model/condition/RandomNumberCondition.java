package com.gameRace.model.condition;


import java.util.Random;

public class RandomNumberCondition implements Condition {
    Random random = new Random();

    @Override
    public int getCondition() {
        return random.nextInt(9) + 1;
    }
}
