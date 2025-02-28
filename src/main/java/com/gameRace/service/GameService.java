package com.gameRace.service;

import com.gameRace.model.Car;
import com.gameRace.model.computer.Computer;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int FIRST_TRY = 1;
    private final Computer computer;
    private List<Car> carList;

    public GameService(Computer computer) {
        this.computer = computer;
        this.carList = new ArrayList<>();
    }

    public List<Car> startGame(int tryNumber, int carNumber) {
        if(tryNumber == FIRST_TRY) {
            makeCarList(carNumber);
        }
        for (Car car : carList) {
            car.move();
        }
        return carList;
    }

    public void getNowTryNumber(int nowTryNumber, int tryNumber) {
        if (nowTryNumber == tryNumber) {
            carList.clear();
        }
    }

    private void makeCarList(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car(computer));
        }
    }
}
