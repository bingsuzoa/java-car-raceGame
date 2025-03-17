package com.gameRace.controller;

import com.gameRace.model.car.Cars;
import com.gameRace.model.tryRound.TryRound;
import com.gameRace.service.GameService;
import com.gameRace.view.InputView;
import com.gameRace.view.Message;
import com.gameRace.view.OutputView;

public class GameController {
    private final InputView inputView = InputView.getInputView();
    private final OutputView outputView = OutputView.getOutputView();
    private final GameService gameService;
    private TryRound tryRound;
    private Cars cars;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        getCars();
        getTryRound();
        outputView.printString(Message.RESULT_MESSAGE.getMessage());
        gameService.initGame(cars);
        while (gameService.getNowRound() <= tryRound.getTryRound()) {
            outputView.printRaceResult(gameService.getRaceResult());
        }
        outputView.printWinnerNames(gameService.getWinnerNames());
        gameService.endGameIfFinalRound(gameService.getNowRound(), tryRound.getTryRound());
    }

    private void getCars() {
        String playerInputOfCarName;
        do {
            playerInputOfCarName = inputView.getCarNameInput();
        } while (!validateCars(playerInputOfCarName));
    }

    private boolean validateCars(String playerInput) {
        try {
            cars = new Cars(playerInput);
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
            return false;
        }
        return true;
    }

    private void getTryRound() {
        String playerInputOfTryRound;
        do {
            playerInputOfTryRound = inputView.getTryRoundInput();
        } while (!validateTryRound(playerInputOfTryRound));
    }

    private boolean validateTryRound(String input) {
        try {
            tryRound = new TryRound(input);
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
            return false;
        }
        return true;
    }
}