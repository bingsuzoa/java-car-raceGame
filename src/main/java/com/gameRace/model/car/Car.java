package com.gameRace.model.car;

import com.gameRace.model.condition.Condition;
import com.gameRace.view.Message;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private int position;
    private final Condition condition;

    public Car(CarName carName, Condition condition) {
        this.carName = carName;
        this.position = 1;
        this.condition = condition;
    }

    public String getName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position;
    }

    public String getThisRoundResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(Message.CAR.getMessage());
        }
        return stringBuilder.toString();
    }

    public void startRound() {
        goOrStop();
    }

    private void goOrStop() {
        int number = condition.getCondition();
        if (number >= 4) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName) && Objects.equals(condition, car.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position, condition);
    }
}
