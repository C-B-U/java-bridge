package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeGameTest {

    BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    List<String> bridge = bridgeMaker.makeBridge(3);


    @Test
    @DisplayName("다리가 'U','D'로 구성되어 있는지 확인한다.")
    void BridgeComposeByUAndD(){
        assertThat(bridge).containsExactly("U", "D", "D");
    }


}
