package com.gameRaceTest;

import com.gameRace.car.Car;
import com.gameRace.car.CarList;
import com.gameRace.game.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    GameService gameService = new GameService();

    @Test
    @DisplayName("라운드 진행 될 경우 carList는 유지되며, 라운드 종료 시 carList는 초기화된다.")
    void test4() {
        String input = "car1,car2";
        CarList carList = new CarList(input);
        int tryNumber = 3;
        int nowRound = 2;
        gameService.startGame(carList);
        gameService.endGameIfFinalRound(nowRound, tryNumber);
        assertFalse(carList.getCarList().isEmpty());

        nowRound = 4;
        gameService.endGameIfFinalRound(nowRound, tryNumber);
        assertTrue(carList.getCarList().isEmpty());
    }

    @Test
    @DisplayName("라운드가 시작하면 자동차는 앞으로 가거나 멈출 수 있다.")
    void test3() {
        String input = "car1,car2";
        CarList carList = new CarList(input);
        List<Car> answerCarList = carList.getCarList();

        List<Car> carListFirstRace = gameService.startGame(carList);
        for(int i = 0; i < carListFirstRace.size(); i++) {
            assert carListFirstRace.get(i).getRaceCount() >= answerCarList.get(i).getRaceCount();
        }
    }

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
        assertThrows(RuntimeException.class, () -> {
            CarList carList = new CarList(value);
        });
    }
}
