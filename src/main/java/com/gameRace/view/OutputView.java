package com.gameRace.view;


import com.gameRace.model.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getOutputView() {
        return outputView;
    }

    public void printString(String message) {
        System.out.println(message);
    }

    public void printRaceResult(List<Car> raceResultForRound) {
        for (Car car : raceResultForRound) {
            System.out.println(car.getName() + " : " + car.getThisRoundResult());
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNameList) {
        String winnerNames = winnerNameList.stream()
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승 하셨습니다!");
    }
}
