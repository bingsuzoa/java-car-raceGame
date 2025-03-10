package com.gameRaceTest;

import com.gameRace.car.Car;
import com.gameRace.car.CarList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    @DisplayName("사용자가 입력한 자동차 이름으로 자동차가 만들어진다.")
    void test1() {
        String input = "car1,car2";
        CarList carList = new CarList(input);

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> answerCarList = new ArrayList<>();
        answerCarList.add(car1);
        answerCarList.add(car2);

        for(int i =0; i < carList.getCarList().size(); i++) {
            Car car = carList.getCarList().get(i);
            Car answerCar = answerCarList.get(i);
            Assertions.assertThat(car.getName()).isEqualTo(answerCar.getName());
        }
    }


    @DisplayName("사용자가 자동차 이름을 제대로 입력하지 않을 때")
    @ParameterizedTest
    @ValueSource(strings = {",car1,car2", "car1,car2,", "car1,car2,car1"})
    void test2(String value) {
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            CarList carList = new CarList(value);
        });
    }
}
