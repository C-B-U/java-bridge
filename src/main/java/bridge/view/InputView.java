package bridge.view;

import bridge.constant.RetryCommand;
import bridge.domain.BridgeSize;
import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final InputValidator inputValidator = new InputValidator();
    private static final OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSize readBridgeSize() {
        try {
            outputView.printLengthMessage();
            String input = Console.readLine();
            inputValidator.validateIsNumber(input);
            return new BridgeSize(Integer.parseInt(input));
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            outputView.printMovingDirectionMessage();
            String input = Console.readLine();
            inputValidator.validateMoving(input);
            return input;
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public RetryCommand readGameCommand() {
        try {
            outputView.printRetryMessage();
            return RetryCommand.getCommand(Console.readLine());
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            return readGameCommand();
        }
    }
}
