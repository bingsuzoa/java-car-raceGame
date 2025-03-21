package com.gameRaceTest.carTest;

import com.gameRace.model.car.Car;
import com.gameRace.model.car.CarName;
import com.gameRace.model.car.Cars;
import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomNumberCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {
    Condition condition = new RandomNumberCondition();

    @Test
    @DisplayName("플레이어의 입력대로 Cars가 생성되는지 확인하는 테스트")
    void 플레이어_입력대로_Cars_생성확인() {
        CarName carName1 = new CarName("carName1");
        Car car1 = new Car(carName1, condition);

        CarName carName2 = new CarName("carName2");
        Car car2 = new Car(carName2, condition);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        Cars answer = new Cars(cars);

        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertTrue(cars.get(i) == answer.getCars().get(i));
        }

    }

    @Test
    @DisplayName("라운드 종료 시 Cars 초기화 되는지 확인하는 테스트")
    void 라운드_종료_시_Cars_초기화() {
        CarName carName1 = new CarName("carName1");
        Car car1 = new Car(carName1, condition);

        CarName carName2 = new CarName("carName2");
        Car car2 = new Car(carName2, condition);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        Cars answer = new Cars(cars);

        int nowRound = 6;
        int tryRound = 5;
        answer.clearCars(nowRound, tryRound);
        Assertions.assertTrue(answer.getCars().isEmpty());

    }
}
