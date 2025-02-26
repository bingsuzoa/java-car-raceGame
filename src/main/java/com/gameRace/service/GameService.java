package com.gameRace.service;


import com.gameRace.model.Car;
import com.gameRace.model.Referee;
import com.gameRace.model.computer.Computer;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<Car> carList;
    private Computer computer;
    private Referee referee;

    public GameService(Computer computer) {
        this.carList = new ArrayList<>();
        this.computer = computer;
    }

    public List<Car> makeCarList(int carNumber) {
        if(carList.isEmpty()) {
            for(int i = 0; i < carNumber; i++) {
                carList.add(new Car());
            }
        }
        referee = new Referee(computer);
        return referee.provideNumberToCar(carList);
    }

    public void clearCarList(int nowTryNumber, int tryNumber) {
        if(nowTryNumber == tryNumber) {
            carList.clear();
        }
    }
}
