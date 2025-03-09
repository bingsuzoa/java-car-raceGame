package model;

import com.gameRace.model.Car;
import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    Condition condition = new RandomCondition();
//    Car car = new Car(condition);

//    @Test
//    @DisplayName("Car는 전진 또는 멈출 수 있는지 확인하는 테스트 : nowPosition의 숫자가 +1 증가하거나, 그대로일 때 통과")
//    void getPosition() {
//        int nowPosition = car.getPosition();
//        car.move();
//        Assertions.assertTrue(nowPosition == car.getPosition()
//                                || nowPosition + 1 == car.getPosition());
//    }

}
