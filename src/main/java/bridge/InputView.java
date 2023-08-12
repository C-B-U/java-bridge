package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator = new InputValidator();

    public int inputBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        inputValidator.validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String inputBridgeMoveStep() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String bridgeMoveStep = Console.readLine();
        inputValidator.validateBridgeMoveStep(bridgeMoveStep);
        return bridgeMoveStep;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String inputGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        inputValidator.validateBridgeStartCommand(gameCommand);
        return gameCommand;
    }
}
