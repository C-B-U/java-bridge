package bridge.view;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final OutputView outputView = new OutputView();
    private static final InputValidator inputValidator = new InputValidator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size;
        do {
            size = inputBridgeSize();
        } while (size == null);
        return Integer.parseInt(size);
    }

    private String inputBridgeSize() {
        String input;
        try {
            input = Console.readLine();
            inputValidator.validateBridgeSize(input);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return null;
        }
        return input;
    }

    public String readMoving() {
        String moving;
        do {
            moving = inputMoving();
        } while (moving == null);
        return moving;
    }

    private String inputMoving() {
        String input;
        try {
            input = Console.readLine();
            inputValidator.validateMoving(input);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return null;
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
