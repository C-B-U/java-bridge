package bridge;

public class MoveResultMapper {
    private static MoveResultMapper INSTANCE;
    private MoveResultMapper() {}

    public static MoveResultMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MoveResultMapper();
        }
        return INSTANCE;
    }

    public MoveResult mapToMoveResult(final BridgeType input, final BridgeType answer, final int leftSize) {
        if (leftSize == 0) {
            return checkSuccess(input, answer);
        }
        return checkKeepGoing(input, answer);
    }

    private MoveResult checkKeepGoing(final BridgeType input, final BridgeType answer) {
        if (input == answer) {
            return MoveResult.KEEP_GOING;
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
