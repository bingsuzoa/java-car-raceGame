package com.gameRace.controller;

import com.gameRace.gameException.InvalidDelimiterPosition;
import com.gameRace.service.GameService;
import com.gameRace.view.InputView;
import com.gameRace.view.Message;
import com.gameRace.view.OutputView;

public class GameController {
    private final InputView inputView = InputView.getInputView();
    private final OutputView outputView = OutputView.getOutputView();
    private final GameService gameService;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        try {
            start();
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
        }
    }

    private void start() {
        getCarNames();
        int tryRound = getTryRound();
        outputView.printString(Message.RESULT_MESSAGE.getMessage());
        while (gameService.getNowRound() <= tryRound) {
            outputView.printRaceResult(gameService.getRaceResult());
        }
        outputView.printWinners(gameService.getWinners());
        gameService.endGameIfFinalRound(gameService.getNowRound(), tryRound);
    }

    private void getCarNames() {
        String playerInput;
        boolean isValidCarNames;
        boolean isValidCarNameLength;
        do {
            playerInput = inputView.getCarNameInput();
            isValidCarNames = validateCarNames(playerInput);
            isValidCarNameLength = validateCars(isValidCarNames, playerInput);
        } while (!isValidCarNames || !isValidCarNameLength);
    }

    private boolean validateCars(boolean isValidCarNames, String playerInput) {
        try {
            getCars(isValidCarNames, playerInput);
            return true;
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
        }
        return false;
    }

    private void getCars(boolean isValidCarNames, String playerInput) {
        if (isValidCarNames) {
            gameService.getCars(playerInput);
        }
    }

    private boolean validateCarNames(String playerInput) {
        try {
            validatePlayerInput(playerInput);
            return true;
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
        }
        return false;
    }

    private void validatePlayerInput(String playerInput) {
        playerInput = playerInput.replace(" ", "");
        if (!playerInput.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)+$")) {
            throw new InvalidDelimiterPosition();
        }
    }

    private int getTryRound() {
        int tryRound;
        do {
            tryRound = inputView.getTryRoundInput();
        } while (tryRound == 0);
        return tryRound;
    }
}