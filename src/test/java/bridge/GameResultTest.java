package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class GameResultTest {

    GameResult gameResult = new GameResult();
    BridgeStatus bridgeStatus = new BridgeStatus();

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

    @Test
    @DisplayName("윗 칸을 누르고 실패했을 때 게임 화면이 만들어지는지 확인한다.")
    void upStairFail(){
        bridgeStatus.failStair("U");

        String upStairSuccess = bridgeStatus.toString();

        assertThat(upStairSuccess).contains("[ X ]\n[   ]\n");

    }




}
