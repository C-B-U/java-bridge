package bridge;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final InputValidator inputValidator;
    private final OutputView outputView;

    public InputView() {
        this.inputValidator = new InputValidator();
        this.outputView = new OutputView();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input;
        do {
            input = inputBridgeSize();
        } while (input == null);

        return Integer.parseInt(input);
    }

    private String inputBridgeSize() {
        outputView.printInputBridgeSize();
        String bridgeSize = Console.readLine();
        try {
            inputValidator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return null;
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
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
