package com.gameRace.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private List<Car> carList;
    private final CarName carName;

    public CarList(String playerInput) {
        this.carName = new CarName(playerInput);
        this.carList = new ArrayList<>();
        makeCarList();
    }

    public void startRace() {
        for(Car car : carList) {
            car.startRound();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void clearCarList() {
        carList.clear();
    }

    public List<String> getWinnerList() {
        Collections.sort(carList, (o1,o2) -> {
            return o2.getRaceCount() - o1.getRaceCount();
        });
        int winnerRaceCount = carList.get(0).getRaceCount();
        return carList.stream()
                .filter(car -> car.getRaceCount() == winnerRaceCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void makeCarList() {
        String[] carNameArray = carName.getValidatedPlayerInput().split(",");
        for(String carName : carNameArray) {
            carList.add(new Car(carName));
        }
    }
}
