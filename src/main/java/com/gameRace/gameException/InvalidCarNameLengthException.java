package com.gameRace.gameException;

public class InvalidCarNameLengthException extends RuntimeException {
    private static final String INVALID_CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 5글자 이상이어야 합니다.";

    public InvalidCarNameLengthException() {
        super(INVALID_CAR_NAME_LENGTH_EXCEPTION);
    }
}
