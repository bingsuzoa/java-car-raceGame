package com.gameRaceTest.carTest;

import com.gameRace.model.car.Car;
import com.gameRace.model.car.CarName;
import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomNumberCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    Condition condition = new RandomNumberCondition();

    /// ////해피 테스트
    @Test
    @DisplayName("Car이름을 출력하는 테스트")
    void 자동차_이름_출력하는_테스트() {
        CarName carName = new CarName("car");
        Car car = new Car(carName, condition);
        Assertions.assertThat(car.getName()).isEqualTo("car");
    }

    @Test
    @DisplayName("Car의 처음 위치 확인하는 테스트")
    void 자동차_처음_위치_확인하는_테스트() {
        CarName carName = new CarName("car");
        Car car = new Car(carName, condition);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }


    /// ////예외 테스트
    @DisplayName("자동차 이름이 5글자 미만인 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1", "c"})
    void 자동차_이름_5글자_미만이면_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            CarName carName = new CarName(value);
        });
    }

}
