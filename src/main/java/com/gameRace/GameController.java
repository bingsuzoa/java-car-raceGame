package com.gameRace;

import com.gameRace.car.CarList;
import com.gameRace.tryRound.TryRound;
import com.gameRace.view.InputView;
import com.gameRace.view.Message;
import com.gameRace.view.OutputView;

public class GameController {
    private final InputView inputView = InputView.getInputView();
    private final OutputView outputView = OutputView.getOutputView();
    private final GameService gameService;
    TryRound tryRound;
    CarList carList;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        getCarList();
        getTryRound();
        outputView.printString(Message.RESULT_MESSAGE.getMessage());
        gameService.initGame(carList);
        while(gameService.getNowRound() <= tryRound.getTryRound()) {
            outputView.printRaceResult(gameService.getRaceResult());
        }
        outputView.printWinnerNames(gameService.getWinnerNames());
        gameService.endGameIfFinalRound(gameService.getNowRound(), tryRound.getTryRound());
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

    private void getTryRound() {
        String playerInputOfTryRound;
        do {
            playerInputOfTryRound = inputView.getTryRoundInput();
        } while(!validateTryRound(playerInputOfTryRound));
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
