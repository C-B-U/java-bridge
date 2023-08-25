package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class BridgeWindowTest {

    @Test
    @DisplayName("입력한 칸이 성공했을 때 SUCCESS를 반환하는지 확인한다.")
    void getBridgeWindowElement(){
        BridgeMapElement bridgeWindowElement = BridgeMapElement.getStageWindowElement(true);
        assertThat(bridgeWindowElement).isEqualTo(BridgeMapElement.SUCCESS);
    }

}
