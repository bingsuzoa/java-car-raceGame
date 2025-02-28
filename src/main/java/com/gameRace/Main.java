package com.gameRace;

import com.gameRace.controller.GameController;
import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomCondition;
import com.gameRace.service.GameService;

public class Main {
    public static void main(String[] args) {
        Condition condition = new RandomCondition();
        GameService gameService = new GameService(condition);
        GameController gameController = new GameController(gameService);

        gameController.startGame();
    }
}
