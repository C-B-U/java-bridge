package bridge.model;

import bridge.domain.Bridge;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @Test
    void isCorrectMoving() {
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        int position = 2;
        String direction = "U";

        boolean isCorrect = bridge.isCorrectMoving(direction, position);

        assertThat(isCorrect).isTrue();
    }
}
