package com.gameRace.model.car;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    private final CarName carName;

    public Cars(String playerInput) {
        this.carName = new CarName(playerInput);
        this.cars = new ArrayList<>();
        makeCars();
    }

    public void startRace() {
        for (Car car : cars) {
            car.startRound();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void clearCars(int nowRound, int tryNumber) {
        if (nowRound > tryNumber) {
            cars.clear();
        }
    }

    public List<String> getWinnerList() {
        Collections.sort(cars, (o1, o2) -> {
            return o2.getRaceCount() - o1.getRaceCount();
        });
        int winnerRaceCount = cars.get(0).getRaceCount();
        return cars.stream()
                .filter(car -> car.getRaceCount() == winnerRaceCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void makeCars() {
        String[] carNameArray = carName.getValidatedPlayerInput().split(",");
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }
}
