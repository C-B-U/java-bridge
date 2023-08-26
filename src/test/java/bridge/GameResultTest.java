package bridge;

import bridge.constant.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("게임 결과 메시지를 반환하는지 확인한다.")
    void getBridgeGameResult(){
        String gameResult = GameResult.gameResult();
        assertThat(gameResult).isEqualTo(GameResult.GAME_FAILED.toString());
    }
}
