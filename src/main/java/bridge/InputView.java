package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public int inputBridgeSize() {
        System.out.println(GameProgressMessage.INPUT_BRIDGE_LENGTH);
        String bridgeSize = Console.readLine();
        System.out.println(GameProgressMessage.BLANK);
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputBridgeMoveStep() {
        System.out.println(GameProgressMessage.INPUT_MOVE_STAIR);
        String bridgeMoveStep = Console.readLine();
        inputValidator.validateBridgeMoveStep(bridgeMoveStep);
        return bridgeMoveStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String inputRetryCommand() {
        System.out.println(GameProgressMessage.INPUT_RETRY_GAME);
        String retryCommand = Console.readLine();
        inputValidator.validateBridgeStartCommand(retryCommand);
        return retryCommand;
    }
}
