package com.gameRace.service;


import com.gameRace.model.car.Car;
import com.gameRace.model.car.Cars;

import java.util.List;

public class GameService {
    private int nowRound;
    private Cars cars;

    public GameService() {
        nowRound = 1;
    }

    public int getNowRound() {
        return nowRound;
    }

    public List<String> getWinnerNames() {
        return cars.getWinnerList();
    }

    public List<Car> getRaceResult() {
        cars.startRace();
        this.nowRound++;
        return cars.getCarList();
    }

    public void initGame(Cars cars) {
        this.cars = cars;
    }

    public void endGameIfFinalRound(int nowRound, int tryNumber) {
        cars.clearCarList(nowRound, tryNumber);
    }
}