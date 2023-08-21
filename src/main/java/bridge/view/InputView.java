package bridge.view;

import bridge.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final OutputView outputView = new OutputView();
    private static final InputValidator inputValidator = new InputValidator();

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

    public String readGameCommand() {
        String command;
        do {
            command = inputGameCommand();
        } while (command == null);
        return command;
    }

    private String inputGameCommand() {
        String input;
        try {
            input = Console.readLine();
            inputValidator.validateRetryCommand(input);
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return null;
        }
        return input;
    }
}