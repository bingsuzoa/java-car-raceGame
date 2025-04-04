package com.gameRace.gameException;

public class InvalidTryRoundException extends RuntimeException {
    private static final String INVALID_TRY_NUMBER_EXCEPTION = "시도 횟수는 양의 정수만 입력이 가능합니다.";

    public InvalidTryRoundException() {
        super(INVALID_TRY_NUMBER_EXCEPTION);
    }
}
