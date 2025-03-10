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
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        int carNumber = Integer.parseInt(getValidPlayerInput(PlayOption.CAR_NUMBER));
        int tryNumber = Integer.parseInt(getValidPlayerInput(PlayOption.TRY_NUMBER));
        startGameAndGetResult(carNumber, tryNumber);
    }

    public void printResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            outputView.printResult(carList.get(i).getPosition());
        }
        outputView.printBlank();
    }

    private String getValidPlayerInput(PlayOption playOption) {
        String input;
        do {
            input = inputView.getPlayerInput(playOption);
        } while (!validateInput(input));
        return input;
    }

    private boolean validateInput(String input) {
        if (input.matches("^[1-9]+$")) {
            return true;
        }
        outputView.printNotInvalidMessage();
        return false;
    }

    private void startGameAndGetResult(int carNumber, int tryNumber) {
        outputView.printResultMessage();
        for (int i = 1; i <= tryNumber; i++) {
            printResult(gameService.startGame(i, carNumber));
            gameService.checkGameOver(i, tryNumber);
        }
    }
}
