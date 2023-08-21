package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
