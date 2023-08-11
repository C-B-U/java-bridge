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
    public String inputGameCommand(String gameCommand) {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        inputValidator.validateBridgeStartCommand(gameCommand);
        return gameCommand;
    }
}
