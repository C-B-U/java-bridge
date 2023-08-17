package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final int BRIDGE_UPPER_CASE = 1;
    private static final int BRIDGE_LOWER_CASE = 0;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .map(i -> bridgeNumberGenerator.generate())
                .filter(this::validateRandomNumber)
                .boxed()
                .map(GameCommand::bridgeStageCase)
                .collect(Collectors.toList());
    }

    private boolean validateRandomNumber(int number){
        return number == BRIDGE_UPPER_CASE || number == BRIDGE_LOWER_CASE;
    }

}
