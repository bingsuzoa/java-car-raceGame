package com.gameRaceTest.conditionTest;

import com.gameRace.model.condition.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberCondition {

    @Test
    @DisplayName("랜덤 숫자는 항상 1 - 9 까지의 숫자인지 확인하는 테스트")
    void 랜덤_숫자_확인_테스트() {
        Condition condition = new com.gameRace.model.condition.RandomNumberCondition();
        int number = condition.getCondition();
        Assertions.assertTrue(number >= 1 && number <= 9);

    }
}
