package bridge.factory;

import bridge.constant.BridgeType;
import bridge.constant.MoveResult;

public class MoveResultMapper {
    private static final int NO_LEFT_ELEMENT = 0;

    public MoveResult mapToMoveResult(final BridgeType input, final BridgeType answer, final int leftSize) {
        if (leftSize == NO_LEFT_ELEMENT) {
            return checkSuccess(input, answer);
        }
        return checkContinue(input, answer);
    }

    private MoveResult checkContinue(final BridgeType input, final BridgeType answer) {
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
