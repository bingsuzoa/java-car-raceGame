package com.gameRace;


import com.gameRace.game.GameService;

public class Main {
    public static void main(String[] args) {

        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        gameController.startGame();

    }
}
