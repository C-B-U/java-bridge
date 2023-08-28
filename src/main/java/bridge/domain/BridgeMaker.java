package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.Keyword;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(bridgeIndex -> Keyword.convert(bridgeNumberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
