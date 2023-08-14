package bridge.factory;

import bridge.constant.BridgeType;
import bridge.constant.MoveResult;

public class MoveResultMapper {
    public MoveResult mapToMoveResult(final BridgeType input, final BridgeType answer, final int leftSize) {
        if (leftSize == 0) {
            return checkSuccess(input, answer);
        }
        return checkKeepGoing(input, answer);
    }

    private MoveResult checkKeepGoing(final BridgeType input, final BridgeType answer) {
        if (input == answer) {
            return MoveResult.CONTINUE;
        }
        return MoveResult.FAILED;
    }

    private MoveResult checkSuccess(final BridgeType input, final BridgeType answer) {
        if (input == answer) {
            return MoveResult.SUCCESS;
        }
        return MoveResult.FAILED;
    }
}
