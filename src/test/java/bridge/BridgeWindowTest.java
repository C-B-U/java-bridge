package bridge;

import bridge.constant.BridgeMapElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class BridgeWindowTest {

    @Test
    @DisplayName("입력한 칸이 실패했을 때 FAIL을 반환하는지 확인한다.")
    void getBridgeWindowElement(){
        BridgeMapElement bridgeWindowElement = BridgeMapElement.getStageWindowElement(false);
        assertThat(bridgeWindowElement).isEqualTo(BridgeMapElement.FAIL);
    }

}
