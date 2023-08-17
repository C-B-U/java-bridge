package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

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
        System.out.println(GameProgressMessage.INPUT_BRIDGE_LENGTH);
        String bridgeSize = Console.readLine();
        System.out.println(GameProgressMessage.BLANK);
        try {
            inputValidator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(){
        String input;
        do{
            input = inputBridgeMoveStep();
        }while (input == null);
        return input;
    }

    private String inputBridgeMoveStep() {
        System.out.println(GameProgressMessage.INPUT_MOVE_STAIR);
        String bridgeMoveStep = Console.readLine();
        try {
            inputValidator.validateBridgeMoveStep(bridgeMoveStep);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
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
