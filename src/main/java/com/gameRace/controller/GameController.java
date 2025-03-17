package com.gameRace.controller;

import com.gameRace.model.car.CarNames;
import com.gameRace.service.GameService;
import com.gameRace.view.InputView;
import com.gameRace.view.Message;
import com.gameRace.view.OutputView;


public class GameController {
    private final InputView inputView = InputView.getInputView();
    private final OutputView outputView = OutputView.getOutputView();
    private final GameService gameService;
    private CarNames carNames;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        getCars();
        int tryRound = getTryRound();
        gameService.initGame(carNames);
        outputView.printString(Message.RESULT_MESSAGE.getMessage());
        while (gameService.getNowRound() <= tryRound) {
            outputView.printRaceResult(gameService.getRaceResult());
        }
        outputView.printWinners(gameService.getWinners());
        gameService.endGameIfFinalRound(gameService.getNowRound(), tryRound);
    }

    private void getCars() {
        String playerInput;
        do {
            playerInput = inputView.getCarNameInput();
        } while (!validateCars(playerInput));
    }

    private boolean validateCars(String playerInput) {
        try {
            carNames = new CarNames(playerInput);
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
            return false;
        }
        return true;
    }

    private int getTryRound() {
        int tryRound;
        do {
            tryRound = inputView.getTryRoundInput();
        } while (tryRound == 0);
        return tryRound;
    }
}