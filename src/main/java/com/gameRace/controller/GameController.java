package com.gameRace.controller;

import com.gameRace.model.Car;
import com.gameRace.service.GameService;
import com.gameRace.view.InputView;
import com.gameRace.view.OutputView;
import com.gameRace.view.PlayOption;

import java.util.List;

public class GameController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final InputValidator inputValidator = new InputValidator();
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        String carNames = getValidCarNames();
        int tryNumber = Integer.parseInt(getValidTryNumber());
        startGameAndGetResult(carNames, tryNumber);
    }

    public void printResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            outputView.printResult(carList.get(i).getName(), carList.get(i).getPosition());
        }
        outputView.printBlank();
    }

    private String getValidCarNames() {
        String input;
        do {
            input = inputView.getPlayerInput(PlayOption.CAR_NAMES);
        } while (!checkValidationOfCarNames(input));
        return input;
    }

    private boolean checkValidationOfCarNames(String input) {
        try {
            return inputValidator.validateCarNames(input);
        } catch (IllegalArgumentException e) {
            outputView.printNotInvalidMessage(e.getMessage());
            return false;
        }
    }

    private String getValidTryNumber() {
        String input;
        do {
            input = inputView.getPlayerInput(PlayOption.TRY_NUMBER);
        } while (!checkValidationOfTryNumber(input));
        return input;
    }

    private boolean checkValidationOfTryNumber(String input) {
        try {
            return inputValidator.validateTryNumber(input);
        } catch (IllegalArgumentException e) {
            outputView.printNotInvalidMessage(e.getMessage());
            return false;
        }
    }

    private void startGameAndGetResult(String carNames, int tryNumber) {
        outputView.printResultMessage();
        for (int i = 1; i <= tryNumber; i++) {
            printResult(gameService.startGame(carNames, i));
        }
        outputView.printWinner(gameService.getWinner());
        gameService.checkGameOver();
    }
}
