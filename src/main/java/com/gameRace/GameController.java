package com.gameRace;

import com.gameRace.car.CarList;
import com.gameRace.gameRaceException.InvalidTryNumberException;
import com.gameRace.view.InputView;
import com.gameRace.view.Message;
import com.gameRace.view.OutputView;

public class GameController {
    private final InputView inputView = InputView.getInputView();
    private final OutputView outputView = OutputView.getOutputView();
    private final GameService gameService;
    private int tryNumber;
    CarList carList;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        getCarList();
        getTryNumber();
        outputView.printString(Message.RESULT_MESSAGE.getMessage());
        while(gameService.getNowRound() <= tryNumber) {
            outputView.printRaceResult(gameService.startGame(carList));
        }
        outputView.printWinnerNames(gameService.getWinnerNames());
        gameService.endGameIfFinalRound(gameService.getNowRound(), tryNumber);
    }

    private void getTryNumber() {
        String playerInputOfTryNumber;
        do {
            playerInputOfTryNumber = inputView.getTryNumberInput();
        } while(!validateTryNumber(playerInputOfTryNumber));
        tryNumber = Integer.parseInt(playerInputOfTryNumber);
    }

    private void getCarList () {
        String playerInputOfCarName;
        do {
            playerInputOfCarName = inputView.getCarNameInput();
        } while(!validateCarList(playerInputOfCarName));
    }

    private boolean validateCarList(String playerInput) {
        try {
            carList = new CarList(playerInput);
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean validateTryNumber(String input) {
        try {
            return throwExceptionInValidTryNumber(input);
        } catch (RuntimeException e) {
            outputView.printString(e.getMessage());
        }
        return false;
    }

    private boolean throwExceptionInValidTryNumber(String playerInputOfTryNumber) {
        if(playerInputOfTryNumber.matches("^[1-9][0-9]*$")) {
            return true;
        }
        throw new InvalidTryNumberException();
    }
}
