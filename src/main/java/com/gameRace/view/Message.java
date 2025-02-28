package com.gameRace.view;

public enum Message {
    GET_CAR_NUMBER("자동차 대수는 몇 대인가요?"),

    GET_TRY_NUMBER("시도할 횟수는 몇 회인가요?"),

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
