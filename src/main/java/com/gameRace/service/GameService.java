package com.gameRace.service;

import com.gameRace.model.Car;
import com.gameRace.model.condition.Condition;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int FIRST_ATTEMPT = 1;
    private final Condition condition;
    private List<Car> carList;

    public GameService(Condition condition) {
        this.condition = condition;
        this.carList = new ArrayList<>();
    }

    public List<Car> startGame(int tryNumber, int carNumber) {
        if(tryNumber == FIRST_ATTEMPT) {
            makeCarList(carNumber);
        }
        for (Car car : carList) {
            car.move();
        }
        return carList;
    }

    public void checkGameOver(int nowTryNumber, int tryNumber) {
        if (nowTryNumber == tryNumber) {
            carList.clear();
        }
    }

    private void makeCarList(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car(condition));
        }
    }
}
