package com.gameRace.view;

public enum Message {
    CAR_NUMBER_INPUT_MESSAGE("자동차 대수는 몇 대인가요?"),

    TRY_NUMBER_INPUT_MESSAGE("시도할 횟수는 몇 회인가요?"),

    RESULT_MESSAGE("실행 결과"),

    ERROR_INVALID_INPUT("올바른 입력이 아닙니다. 다시 입력해주세요"),

    CAR("-");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
