package bridge;

import bridge.model.BridgeStageRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BridgeStageRecordTest {

    @Test
    @DisplayName("Bridge 게임 진행의 기본 상태가 true인지 확인한다.")
    void checkDefaultGameProcessing(){
        boolean isProcessing = BridgeStageRecord.isProgressing();
        assertThat(isProcessing).isTrue();
    }

    @Test
    @DisplayName("Bridge 게임 진행의 기본 stage가 0인지 확인한다.")
    void checkDefaultGameStage(){
        int curStage = BridgeStageRecord.getCurStage();
        assertThat(curStage).isEqualTo(0);
    }

    @Test
    @DisplayName("Bridge 게임의 다음 단계로 이동 시 stage가 1 증가하는지 확인한다.")
    void checkNextGameStage(){
        BridgeStageRecord.nextStage();

        int curStage = BridgeStageRecord.getCurStage();

        assertThat(curStage).isEqualTo(1);
    }

    @Test
    @DisplayName("Bridge 게임의 상태가 이동할 수 없을 때 Record에 저장되는지 확인한다.")
    void checkNextGameStatus(){
        BridgeStageRecord.changeMoveStatus(false);

        boolean canNotMoveNextStage = BridgeStageRecord.canNotMoveNextStage();

        assertThat(canNotMoveNextStage).isTrue();
    }
}
