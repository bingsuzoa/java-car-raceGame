package com.gameRace.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace() {
        for (Car car : cars) {
            car.startRound();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void clearCars(int nowRound, int tryRound) {
        if (nowRound > tryRound) {
            cars.clear();
        }
    }

    public List<String> getWinners() {
        Collections.sort(cars, (o1, o2) -> {
            return o2.getPosition() - o1.getPosition();
        });
        int winnerPosition = cars.get(0).getPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
