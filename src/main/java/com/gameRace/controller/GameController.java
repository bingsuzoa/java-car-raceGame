package com.gameRace.controller;

import com.gameRace.model.Car;
import com.gameRace.service.GameService;
import com.gameRace.view.InputView;
import com.gameRace.view.Message;
import com.gameRace.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void gameStart() {
        int carNumber = inputView.getCarNumber();
        int tryNumber = inputView.getTryNumber();
        outputView.printMessage(Message.RESULT_MESSAGE);
        for (int i = 1; i <= tryNumber; i++) {
            printResult(gameService.makeCarList(carNumber));
            gameService.clearCarList(i, tryNumber);
        }
    }


    public void printResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            outputView.printResult(carList.get(i).getMoveCount());
        }
        outputView.printBlank();
    }

}
