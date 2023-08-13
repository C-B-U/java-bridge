package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final OutputView outputView = new OutputView();
    private static final InputValidator inputValidator = new InputValidator();

    public int readBridgeSize() {
        outputView.printBridgeLengthInputMessage();
        String bridgeSize = Console.readLine();
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printBridgeSpaceInputMessage();
        String selectedBridge = Console.readLine();
        inputValidator.validateMoving(selectedBridge);
        return selectedBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
