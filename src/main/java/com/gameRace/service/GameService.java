package com.gameRace.service;

import com.gameRace.model.Car;
import com.gameRace.model.condition.Condition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {
    private static final int FIRST_ATTEMPT = 1;
    private final Condition condition;
    private List<Car> carList;

    public GameService(Condition condition) {
        this.condition = condition;
        this.carList = new ArrayList<>();
    }

    public List<Car> startGame(String carNames, int tryNumber) {
        if (tryNumber == FIRST_ATTEMPT) {
            makeCarList(carNames);
        }
        for (Car car : carList) {
            car.move();
        }
        return carList;
    }

    public List<Car> getWinner() {
        carList.sort((o1, o2) -> o2.getPosition() - o1.getPosition());
        int winnerPosition = carList.get(0).getPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .collect(Collectors.toList());

    }

    public void checkGameOver() {
        carList.clear();
    }

    private void makeCarList(String carNames) {
        String[] carNamesArray = carNames.split(",");
        for (int i = 0; i < carNamesArray.length; i++) {
            String carName = carNamesArray[i].replace(" ", "");
            carList.add(new Car(carName, condition));
        }
    }
}
