package model;

import com.gameRace.controller.InputValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    /// //////해피 테스트
    @DisplayName("유효한 자동차 이름인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1, car2", "car1, car2, car3"})
    void validateCarNames(String value) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertTrue(inputValidator.validateCarNames(value));
    }

    @DisplayName("유효한 시도 횟수 입력인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1","2","10"})
    void validateTryNumbers(String value) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertTrue(inputValidator.validateTryNumber(value));
    }


    /// //////에러 테스트
    @DisplayName("유효한 자동차 이름인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "car1", ",car1 , car2", "car1, car2,", "car1.car2"})
    void validateCarNamesThrowTest(String value) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateCarNames(value));
    }

    @DisplayName("유효한 시도 횟수 입력인지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "-1", "0"})
    void validateTryNumbersThrowTest(String value) {
        InputValidator inputValidator = new InputValidator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> inputValidator.validateTryNumber(value));
    }
}