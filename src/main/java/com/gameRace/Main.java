package com.gameRace;

import com.gameRace.controller.GameController;
import com.gameRace.model.computer.Computer;
import com.gameRace.model.computer.RandomNumber;
import com.gameRace.service.GameService;

public class Main {
    public static void main(String[] args) {
        Computer computer = new RandomNumber();
        GameService gameService = new GameService(computer);
        GameController gameController = new GameController(gameService);

        gameController.getCarNumberAndTryNumber();
    }
}
