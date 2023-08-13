package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.Keyword.*;

public class BridgeMaker {
    private static final int IS_UP = 1;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(bridgeIndex -> bridgeNumberGenerator.generate() == IS_UP? UP.getKey() : DOWN.getKey())
                .collect(Collectors.toList());
    }
}
