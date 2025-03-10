package com.gameRace.game;

import com.gameRace.car.Car;
import com.gameRace.car.CarList;

import java.util.List;

public class GameService {
    private int nowRound;
    private CarList carList;

    public GameService() {
        nowRound = 1;
    }

    public int getNowRound() {
        return nowRound;
    }

    public List<String> getWinnerNames() {
        return carList.getWinnerList();
    }

    public List<Car> startGame(CarList carList) {
        this.carList = carList;

        carList.startRace();
        this.nowRound++;
        return carList.getCarList();
    }

    public void endGameIfFinalRound(int nowRound, int tryNumber) {
        if(nowRound > tryNumber) {
            carList.clearCarList();
        }
    }



}