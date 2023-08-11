package bridge;
public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public int inputBridgeSize(String bridgeSize) {
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputBridgeMoveStep(String bridgeMoveStep) {
        inputValidator.validateBridgeMoveStep(bridgeMoveStep);
        return bridgeMoveStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
