package com.gameRace.model.car;

import com.gameRace.gameException.InvalidCarNameLengthException;

import java.util.Objects;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        if (carName.length() < 5) {
            throw new InvalidCarNameLengthException();
        }
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }
}
