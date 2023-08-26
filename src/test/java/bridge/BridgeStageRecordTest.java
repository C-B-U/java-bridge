package bridge;

import bridge.model.BridgeStageRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BridgeStageRecordTest {

    @Test
    @DisplayName("Bridge 게임 진행의 기본 상태가 true인지 확인한다. ")
    void checkDefaultGameProcessing(){
        boolean isProcessing = BridgeStageRecord.isProgressing();
        assertThat(isProcessing).isTrue();
    }
}
