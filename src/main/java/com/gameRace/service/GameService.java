package com.gameRace.service;


import com.gameRace.model.car.Car;
import com.gameRace.model.car.CarNames;
import com.gameRace.model.car.Cars;
import com.gameRace.model.condition.Condition;


import java.util.ArrayList;
import java.util.List;

public class GameService {
    private int nowRound;
    private final Condition condition;
    private Cars cars;

    public GameService(Condition condition) {
        this.condition = condition;
        nowRound = 1;
    }

    public int getNowRound() {
        return nowRound;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getRaceResult() {
        cars.startRace();
        this.nowRound++;
        return cars.getCars();
    }

    public Cars initGame(CarNames carNames) {
        List<Car> cars = new ArrayList<>();
        for (String car : carNames.getCarNames().split(",")) {
            cars.add(new Car(car, condition));
        }
        this.cars = new Cars(cars);
        return this.cars;
    }

    public void endGameIfFinalRound(int nowRound, int tryNumber) {
        cars.clearCars(nowRound, tryNumber);
    }
}