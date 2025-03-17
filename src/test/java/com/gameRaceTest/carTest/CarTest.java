package com.gameRaceTest.carTest;

import com.gameRace.model.car.Car;
import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomNumberCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    Condition condition = new RandomNumberCondition();

    @Test
    @DisplayName("Car이름을 출력하는 테스트")
    void 자동차_이름_출력하는_테스트() {
        Car car = new Car("car", condition);
        Assertions.assertThat(car.getName()).isEqualTo("car");
    }

    @Test
    @DisplayName("Car의 처음 위치 확인하는 테스트")
    void 자동차_처음_위치_확인하는_테스트() {
        Car car = new Car("car", condition);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
