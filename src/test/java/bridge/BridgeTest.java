package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

class BridgeTest {
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    @Test
    @DisplayName("다리가 'U', 'D' 형태로 랜덤 생성 되었는지 확인한다.")
    void makeBridge(){
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).contains("U", "D");
    }
}
