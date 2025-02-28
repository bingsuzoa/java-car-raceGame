package service;

import com.gameRace.model.condition.Condition;
import com.gameRace.model.condition.RandomCondition;
import com.gameRace.service.GameService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    Condition condition = new RandomCondition();
    GameService gameService = new GameService(condition);

    @Test
    @DisplayName("플레이어가 입력한 자동차 대수만큼 List에 Car가 생기도록 하는 테스트")
    void startGame() {
        int carNumber = 5;
        int tryNumber = 1;
        Assertions.assertThat(gameService.startGame(tryNumber, carNumber).size()).isEqualTo(carNumber);
    }

}
