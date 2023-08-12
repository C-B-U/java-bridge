package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printLengthMessage();
        String userInput = Console.readLine();
        inputValidator.validateBridgeLength(userInput);
        outputView.printNewLine();
        return Integer.parseInt(userInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMoveLocation();
        String input = Console.readLine();
        inputValidator.validateMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printRetryMessage();
        String input = Console.readLine();
        inputValidator.validateRetry(input);
        return input;
    }
}
