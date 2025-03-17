package com.gameRace.gameException;

public class DuplicatedCarNamesException extends RuntimeException {
    private static final String DUPLICATED_CAR_NAME_EXCEPTION = "중복된 자동차 이름이 있습니다. 다시 입력해주세요.";

    public DuplicatedCarNamesException() {
        super(DUPLICATED_CAR_NAME_EXCEPTION);
    }
}