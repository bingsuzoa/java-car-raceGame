package com.gameRace.controller;

import com.gameRace.view.Message;

public class InputValidator {

    public boolean validateCarNames(String input) {
        if (input.matches("^[^\\W_].*,[^,\\W_]$")) {
            return true;
        }
        throw new IllegalArgumentException(Message.ERROR_INVALID_INPUT.getMessage());
    }

    public boolean validateTryNumber(String input) {
        if (input.matches("^[1-9]\\d*$")) {
            return true;
        }
        throw new IllegalArgumentException(Message.ERROR_INVALID_INPUT.getMessage());
    }
}
