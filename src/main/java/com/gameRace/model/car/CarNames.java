package com.gameRace.model.car;


import com.gameRace.gameException.DuplicatedCarNamesException;
import com.gameRace.gameException.InvalidDelimiterPosition;

import java.util.HashSet;
import java.util.Set;

public class CarNames {
    private final String playerInput;

    public CarNames(String playerInput) {
        playerInput = playerInput.replace(" ", "");
        if (!playerInput.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)+$")) {
            throw new InvalidDelimiterPosition();
        }
        if (!checkDuplicatedCarName(playerInput)) {
            throw new DuplicatedCarNamesException();
        }
        this.playerInput = playerInput;
    }

    public String getCarNames() {
        return playerInput;
    }

    private boolean checkDuplicatedCarName(String playerInput) {
        String[] carNames = playerInput.split(",");
        Set<String> uniqueCarNames = new HashSet<>();

        for (String carName : carNames) {
            carName = carName.replace(" ", "");
            uniqueCarNames.add(carName);
        }
        if (uniqueCarNames.size() != carNames.length) {
            return false;
        }
        return true;
    }


}
