package bridge.domain;

import bridge.Keyword;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMapTest {
    private static final BridgeMap bridgeMap = new BridgeMap();
    @Test
    void isUpPosition() {
    }

    @Test
    void isSuccessMoving() {
        boolean input = true;
        String expected = "O";
        assertThat(bridgeMap.isSuccessMoving(input)).isEqualTo(expected);
    }

    @Test
    void isFailedMoving() {
        boolean input = false;
        String expected = "X";
        assertThat(bridgeMap.isSuccessMoving(input)).isEqualTo(expected);
    }

    @Test
    void testToString() {
    }
}