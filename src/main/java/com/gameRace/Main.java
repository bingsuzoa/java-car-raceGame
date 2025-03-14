package com.gameRace;


import com.gameRace.controller.GameController;
import com.gameRace.service.GameService;

public class Main {
    public static void main(String[] args) {

        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        gameController.startGame();

    }
}
