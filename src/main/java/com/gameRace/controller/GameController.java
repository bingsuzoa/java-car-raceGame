package com.gameRace.controller;

import com.gameRace.model.Car;
import com.gameRace.service.GameService;
import com.gameRace.view.InputView;
import com.gameRace.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class GameController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void getCarNumberAndTryNumber() {
        try {
            int carNumber = inputView.getCarNumber();
            int tryNumber = inputView.getTryNumber();
            startGameAndGetResult(carNumber, tryNumber);
        } catch (InputMismatchException e) {
            outputView.printNotInvalidMessage();
        }
    }

    public void printResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            outputView.printResult(carList.get(i).getMoveCount());
        }
        outputView.printBlank();
    }

    private void startGameAndGetResult(int carNumber, int tryNumber) {
        outputView.printResultMessage();
        for (int i = 1; i <= tryNumber; i++) {
            printResult(gameService.startGame(carNumber));
            gameService.getNowTryNumber(i, tryNumber);
        }
    }
}
