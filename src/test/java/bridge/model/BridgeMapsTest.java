package bridge.model;

import bridge.domain.BridgeMaps;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMapsTest {

    @Test
    void addResult() {
        String direction = "U";
        boolean isCorrect = true;
        BridgeMaps bridgeMaps = new BridgeMaps();

        bridgeMaps.addResult(direction, isCorrect);

        assertThat(bridgeMaps.toString()).contains("[ O ]", "[   ]");
    }
}
