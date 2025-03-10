package com.gameRace.view;

public enum Message {
    CAR_NAMES_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)"),

    TRY_NUMBER_INPUT_MESSAGE("시도할 횟수는 몇 회인가요?"),

    RESULT_MESSAGE("실행 결과"),

    CAR("-");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}