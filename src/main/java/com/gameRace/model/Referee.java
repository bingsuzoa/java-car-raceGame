package com.gameRace.model;


import com.gameRace.model.computer.Computer;

import java.util.List;

public class Referee {
    private final Computer computer;

    public Referee(Computer computer) {
        this.computer = computer;
    }

    public List<Car> provideNumberToCar(List<Car> carList) {
        for(int i = 0; i < carList.size(); i++) {
            carList.get(i).getNumberAndMove(computer.makeNumber());
        }
        return carList;
    }
}
