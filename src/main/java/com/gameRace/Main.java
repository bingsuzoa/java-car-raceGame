package com.gameRace;


import com.gameRace.controller.GameController;
import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomNumberCondition;
import com.gameRace.service.GameService;

public class Main {
    public static void main(String[] args) {

        Condition condition = new RandomNumberCondition();
        GameService gameService = new GameService(condition);
        GameController gameController = new GameController(gameService);
        gameController.startGame();

    }
}
