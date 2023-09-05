package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BridgeMaker의")
class BridgeMakerTest {
    private final BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

    @Test
    @DisplayName("다리 만들기가 수행되는가")
    void makeBridge() {
        //given

        //when
        final List<String> bridge = bridgeMaker.makeBridge(3);

        //then
        assertThat(bridge).containsExactly("D", "D", "D");
    }
}
