package com.gameRace.car;

public class InvalidDelimiterPosition extends RuntimeException {
    private static final String INVALID_DELIMITER_POSITION = "자동차 이름의 구분자는 ,만 가능하며 올바른 위치에 입력해주세요.";

    public InvalidDelimiterPosition() {
        super(INVALID_DELIMITER_POSITION);
    }
}