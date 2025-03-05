package com.gameRace.view;


import com.gameRace.model.Car;

import java.util.List;

public class OutputView {
    private static final OutputView outputView = new OutputView();


    public static OutputView getInstance() {
        if (outputView == null) {
            return new OutputView();
        }
        return outputView;
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printNotInvalidMessage() {
        System.out.println(Message.ERROR_INVALID_INPUT.getMessage());
    }

    public void printResultMessage() {
        System.out.println(Message.RESULT_MESSAGE.getMessage());
    }

    public void printResult(String carName, int moveCount) {
        System.out.print(carName + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print(Message.CAR.getMessage());
        }
        System.out.println();
    }

    public void printWinner(List<Car> carList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < carList.size() - 1; i++) {
            stringBuilder.append(carList.get(i).getName() + " , ");
        }
        stringBuilder.append(carList.get(carList.size()-1).getName() + " 가 최종 우승했습니다.");
        System.out.println(stringBuilder);
    }

    public void printBlank() {
        System.out.println();
    }
}
