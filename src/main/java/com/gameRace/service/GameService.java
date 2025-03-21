package com.gameRace.service;


import com.gameRace.gameException.DuplicatedCarNamesException;
import com.gameRace.model.car.Car;
import com.gameRace.model.car.CarName;
import com.gameRace.model.car.Cars;
import com.gameRace.model.condition.Condition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Cars getCars(String carNames) throws DuplicatedCarNamesException {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.replace(" ", "").split(",")) {
            CarName carName = new CarName(name);
            cars.add(new Car(carName, condition));
        }
        duplicateCarName(cars);
        this.cars = new Cars(cars);
        return this.cars;
    }

    private void duplicateCarName(List<Car> cars) {
        Set<Car> uniqueCarNames = new HashSet<>();
        for (int i = 0; i < cars.size(); i++) {
            uniqueCarNames.add(cars.get(i));
        }
        if (cars.size() != uniqueCarNames.size()) {
            throw new DuplicatedCarNamesException();
        }
    }

    public void endGameIfFinalRound(int nowRound, int tryNumber) {
        cars.clearCars(nowRound, tryNumber);
    }
}