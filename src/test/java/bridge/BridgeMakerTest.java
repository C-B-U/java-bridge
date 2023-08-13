package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {
    @DisplayName("다리 길이로 5를 입력하면 길이가 5인 다리가 생성된다.")
    @Test
    void 다리_길이_5_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(5);
        assertThat(bridge).containsExactly("U", "D", "D", "D", "U");
    }

    @DisplayName("랜덤값이 1이면 다리에 U가 들어간다.")
    @Test
    void 전부_U인_다리_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "U", "U");
    }
}
