package bridge.model;

import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    @DisplayName("다리 길이 입력시 길이에 맞는 다리를 생성하는가")
    @Test
    void makeBridge() {
        BridgeNumberGenerator numberGenerator = new BridgeMakerTest.TestNumberGenerator(newArrayList(1, 0, 0));
        bridge.BridgeMaker bridgeMaker = new bridge.BridgeMaker(numberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(3);

        assertThat(bridge).hasSize(3);
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
