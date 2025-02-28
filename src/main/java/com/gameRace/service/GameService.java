package com.gameRace.service;

import com.gameRace.model.Car;
import com.gameRace.model.computer.Computer;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final Computer computer;
    private List<Car> carList;

    public GameService(Computer computer) {
        this.computer = computer;
        this.carList = new ArrayList<>();
    }

    public List<Car> startGame(int carNumber) {
        makeCarList(carNumber);
        for (Car car : carList) {
            car.decideMoveOrStop();
        }
        return carList;
    }

    public void getNowTryNumber(int nowTryNumber, int tryNumber) {
        if (nowTryNumber == tryNumber) {
            carList.clear();
        }
    }

    private void makeCarList(int carNumber) {
        if (carList.isEmpty()) {
            for (int i = 0; i < carNumber; i++) {
                carList.add(new Car(computer));
            }
        }
    }
}
