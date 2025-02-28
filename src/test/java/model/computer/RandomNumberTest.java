package model.computer;

import com.gameRace.model.computer.Computer;
import com.gameRace.model.computer.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    Computer computer = new RandomNumber();

    @Test
    @DisplayName("0-9까지의 랜덤숫자가 생성되는지 확인하는 테스트")
    void makeNumber() {
        Assertions.assertTrue(0 <= computer.makeNumber() && computer.makeNumber() <= 9);
    }
}
