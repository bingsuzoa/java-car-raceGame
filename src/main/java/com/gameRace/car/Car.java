package com.gameRace.car;

public class Car {
    private final String name;
    private int raceCount;

    public Car(String name) {
        this.name = name;
        this.raceCount = 0;
    }

    public String getName() {
        return name;
    }


}
