package com.gameRace;

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

    public List<Car> getRaceResult() {
        carList.startRace();
        this.nowRound++;
        return carList.getCarList();
    }

    public void initGame(CarList carList) {
        this.carList = carList;
    }

    public void endGameIfFinalRound(int nowRound, int tryNumber) {
        carList.clearCarList(nowRound, tryNumber);
    }
}