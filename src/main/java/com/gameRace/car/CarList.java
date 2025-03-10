package com.gameRace.car;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;
    private final CarName carName;

    public CarList(String playerInput) {
        this.carName = new CarName(playerInput);
        this.carList = new ArrayList<>();
        makeCarList();
    }

    private void makeCarList() {
        String[] carNameArray = carName.getValidatedPlayerInput().split(",");
        for(String carName : carNameArray) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
