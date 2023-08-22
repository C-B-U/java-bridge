package bridge.model;

import bridge.domain.BridgeSize;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeSizeTest {

    String ERROR_MESSAGE = "[ERROR]";

    @Test
    void movingCommandException() {
        int length = 21;

        assertThatThrownBy(() -> new BridgeSize(length))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
