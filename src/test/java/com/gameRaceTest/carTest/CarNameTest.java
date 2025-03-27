package com.gameRaceTest.carTest;

import com.gameRace.gameException.InvalidCarNameLengthException;
import com.gameRace.model.car.CarName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    /// ////////해피 테스트
    @Test
    @DisplayName("자동차 이름이 같은 경우 같은 자동차로 간주")
    void 자동차_이름이_같으면_같은_자동차인지_확인하는_테스트() {
        String input1 = "carName1";
        CarName carName = new CarName(input1);
        CarName carName1 = new CarName(input1);
        Assertions.assertEquals(carName, carName1);
    }


    /// /////////예외 테스트
    @Test
    @DisplayName("자동차 이름이 5글자 미만인 경우 예외 발생")
    void 자동차_이름_5글자_미만이면_예외_발생() {
        String input = "car1";
        Assertions.assertThrows(InvalidCarNameLengthException.class, () ->
        {
            CarName carName = new CarName(input);
        });
    }
}
