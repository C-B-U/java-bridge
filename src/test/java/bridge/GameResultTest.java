package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    GameResult gameResult = new GameResult();

    @Test
    @DisplayName("게임 시도 횟수가 하나씩 증가하는지 확인한다.")
    void upAttemptCount(){
        // given
        gameResult.upAttemptCount();

        //when
        int attemptCount = gameResult.getAttemptCount();

        //then
        assertThat(attemptCount).isEqualTo(1);
    }
}
