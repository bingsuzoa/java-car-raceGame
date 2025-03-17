package com.gameRaceTest.carTest;

import com.gameRace.model.car.Car;
import com.gameRace.model.car.CarNames;
import com.gameRace.model.car.Cars;

import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomNumberCondition;
import com.gameRace.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {

    Condition condition = new RandomNumberCondition();
    GameService gameService = new GameService(condition);


    @Test
    @DisplayName("라운드가 시작하면 자동차는 앞으로 가거나 멈출 수 있다.")
    void 라운드마다_자동차는_앞으로가거나_멈추는지_확인하는_테스트() {
        String input = "car1,car2";
        CarNames carNames = new CarNames(input);
        Cars cars = gameService.initGame(carNames);
        List<Car> answerCarList = cars.getCars();
        List<Car> carListFirstRace = gameService.getRaceResult();
        for (int i = 0; i < carListFirstRace.size(); i++) {
            assert carListFirstRace.get(i).getPosition() >= answerCarList.get(i).getPosition();
        }
    }

    @Test
    @DisplayName("사용자가 입력한 자동차 이름으로 자동차가 만들어진다.")
    void 사용자가_자동차_이름_입력하면_리스트_만들어지는_테스트() {
        String input = "car1,car2";
        CarNames carNames = new CarNames(input);
        Cars cars = gameService.initGame(carNames);
        Car car1 = new Car("car1", condition);
        Car car2 = new Car("car2", condition);
        List<Car> answerCarList = new ArrayList<>();
        answerCarList.add(car1);
        answerCarList.add(car2);

        for (int i = 0; i < cars.getCars().size(); i++) {
            Car car = cars.getCars().get(i);
            Car answerCar = answerCarList.get(i);
            Assertions.assertThat(car.getName()).isEqualTo(answerCar.getName());
        }
    }

    @Test
    @DisplayName("라운드 진행 될 경우 carList는 유지되며, 라운드 종료 시 carList는 초기화된다.")
    void 라운드_종료될경우_carList_초기화하는_테스트() {
        String input = "car1,car2";
        CarNames carNames = new CarNames(input);
        Cars cars = gameService.initGame(carNames);
        int tryNumber = 3;
        int nowRound = 2;
        gameService.endGameIfFinalRound(nowRound, tryNumber);
        assertFalse(cars.getCars().isEmpty());

        nowRound = 4;
        gameService.endGameIfFinalRound(nowRound, tryNumber);
        assertTrue(cars.getCars().isEmpty());
    }


}
