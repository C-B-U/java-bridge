package bridge.model;

import bridge.constant.BridgeDirection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeDirectionTest {

    @Test
    void convertDOWN() {
        int value = 0;

        BridgeDirection direction = BridgeDirection.convertDirection(value);

        assertThat(direction.getDirection()).isEqualTo("D");
    }

    @Test
    void convertUP() {
        int value = 1;

        BridgeDirection direction = BridgeDirection.convertDirection(value);

        assertThat(direction.getDirection()).isEqualTo("U");
    }
}
