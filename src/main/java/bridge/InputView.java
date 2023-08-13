package bridge;

import camp.nextstep.edu.missionutils.Console;

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

    public String readMoving() {
        outputView.printBridgeSpaceInputMessage();
        String selectedBridge = Console.readLine();
        inputValidator.validateMoving(selectedBridge);
        return selectedBridge;
    }

    public String readGameCommand() {
        outputView.printRetryMessage();
        String gameOrNot = Console.readLine();
        inputValidator.validateGameCommand(gameOrNot);
        return gameOrNot;
    }
}
