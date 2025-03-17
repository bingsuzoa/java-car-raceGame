package com.gameRaceTest.carTest;

import com.gameRace.model.car.CarNames;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesTest {
    /// //////해피테스트
    @Test
    @DisplayName("경주 할 자동차 이름 제대로 입력한 경우 문자열 리턴한다.")
    void 경주_할_자동차_이름_제대로_입력시_문자열_리턴() {
        String input = "car1, car2";
        CarNames carNames = new CarNames(input);
        input = input.replace(" ", "");
        Assertions.assertThat(carNames.getCarNames()).isEqualTo(input);
    }

    /// //////예외 테스트
    @DisplayName("자동차 이름 입력 시 입력값의 맨 앞 / 맨 뒤에 ,이외의 특수문자 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {",car1,car2", "car1,car2,"})
    void 입력값의_맨앞_또는_맨뒤에_허용되지않는_입력있으면_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            CarNames carNames = new CarNames(value);
        });
    }

    @DisplayName("자동차 이름 입력 시 입력값에 ,없으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"car"})
    void 하나만입력한경우_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            CarNames carNames = new CarNames(value);
        });
    }

    @DisplayName("자동차 이름 입력 시 입력값에 중복 이름이 있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"car,car"})
    void 중복이름_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            CarNames carNames = new CarNames(value);
        });
    }
}