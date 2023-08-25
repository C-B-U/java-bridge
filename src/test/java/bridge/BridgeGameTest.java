package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @Test
    @DisplayName("게임 재시작 시 현재 stage와 이동 여부를 기본값으로 reset되는지 확인하다.")
    void checkBridgeStageRecordReset(){
        //given
        bridgeGame.retry("R");
        BridgeStageRecord.reset();

        //when
        boolean canNotMoveNextStage = BridgeStageRecord.canNotMoveNextStage();

        //then
       assertThat(canNotMoveNextStage).isFalse();
    }

}
