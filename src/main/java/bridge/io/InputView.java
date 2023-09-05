package bridge.io;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public String readBridgeSize() {
        final String input = Console.readLine();
        inputValidator.validateBridgeSize(input);
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        final String input = Console.readLine();
        inputValidator.validateMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        final String input = Console.readLine();
        inputValidator.validateRetryCommand(input);
        return input;
    }
}
