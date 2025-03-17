package com.gameRaceTest;


import com.gameRace.model.car.Car;
import com.gameRace.model.car.Cars;
import com.gameRace.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarRaceTest {
    GameService gameService = new GameService();


    /// /////해피 테스트
    @Test
    @DisplayName("사용자가 입력한 자동차 이름으로 자동차가 만들어진다.")
    void 사용자가_자동차_이름_입력하면_리스트_만들어지는_테스트() {
        String input = "car1,car2";
        Cars cars = new Cars(input);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> answerCarList = new ArrayList<>();
        answerCarList.add(car1);
        answerCarList.add(car2);

        for (int i = 0; i < cars.getCarList().size(); i++) {
            Car car = cars.getCarList().get(i);
            Car answerCar = answerCarList.get(i);
            Assertions.assertThat(car.getName()).isEqualTo(answerCar.getName());
        }
    }

    @Test
    @DisplayName("라운드 진행 될 경우 carList는 유지되며, 라운드 종료 시 carList는 초기화된다.")
    void 라운드_종료될경우_carList_초기화하는_테스트() {
        String input = "car1,car2";
        Cars cars = new Cars(input);
        int tryNumber = 3;
        int nowRound = 2;
        gameService.initGame(cars);
        gameService.endGameIfFinalRound(nowRound, tryNumber);
        assertFalse(cars.getCarList().isEmpty());

        nowRound = 4;
        gameService.endGameIfFinalRound(nowRound, tryNumber);
        assertTrue(cars.getCarList().isEmpty());
    }

    @Test
    @DisplayName("라운드가 시작하면 자동차는 앞으로 가거나 멈출 수 있다.")
    void 라운드마다_자동차는_앞으로가거나_멈추는지_확인하는_테스트() {
        String input = "car1,car2";
        Cars cars = new Cars(input);
        List<Car> answerCarList = cars.getCarList();
        gameService.initGame(cars);
        List<Car> carListFirstRace = gameService.getRaceResult();
        for (int i = 0; i < carListFirstRace.size(); i++) {
            assert carListFirstRace.get(i).getRaceCount() >= answerCarList.get(i).getRaceCount();
        }
    }

    /// //////예외 테스트
    @DisplayName("자동차 이름 입력 시 입력값의 맨 앞 / 맨 뒤에 ,이외의 특수문자 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {",car1,car2", "car1,car2,"})
    void 입력값의_맨앞_또는_맨뒤에_허용되지않는_입력있으면_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            Cars cars = new Cars(value);
        });
    }

    @DisplayName("자동차 이름 입력 시 입력값에 ,없으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"car"})
    void 하나만입력한경우_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            Cars cars = new Cars(value);
        });
    }

    @DisplayName("자동차 이름 입력 시 입력값에 중복 이름이 있으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"car,car"})
    void 중복이름_예외발생(String value) {
        assertThrows(RuntimeException.class, () -> {
            Cars cars = new Cars(value);
        });
    }
}
