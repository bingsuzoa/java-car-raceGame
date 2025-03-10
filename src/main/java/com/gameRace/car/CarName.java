package com.gameRace.car;



import com.gameRace.game.gameException.carNameException.DuplicatedCarNameException;
import com.gameRace.game.gameException.carNameException.InvalidDelimiterPosition;

import java.util.HashSet;
import java.util.Set;

public class CarName {
    private final String playerInput;

    public CarName(String playerInput) {
        playerInput = playerInput.replace(" ", "");
        if(!playerInput.matches("^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)+$")) {
            throw new InvalidDelimiterPosition();
        }
        if(!checkDuplicatedCarName(playerInput)) {
            throw new DuplicatedCarNameException();
        }
        this.playerInput = playerInput;
    }

    private boolean checkDuplicatedCarName(String playerInput) {
        String[] carNameArrayForDuplicationCheck = playerInput.split(",");
        Set<String> carNameSetForDuplicationCheck = new HashSet<>();

        for(String carName : carNameArrayForDuplicationCheck) {
            carName = carName.replace(" ", "");
            carNameSetForDuplicationCheck.add(carName);
        }
        if(carNameSetForDuplicationCheck.size() != carNameArrayForDuplicationCheck.length) {
            return false;
        }
        return true;
    }

    public String getValidatedPlayerInput() {
        return playerInput;
    }






}
