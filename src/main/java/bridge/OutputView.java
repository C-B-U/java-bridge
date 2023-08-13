package bridge;

import bridge.SuccessFailure;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECTED_BRIDGE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_COMMAND_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MESSAGE = "\n최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE_MESSAGE = "\n게임 성공 여부: ";
    private static final String TOTAL_ATTEMPT_COUNT = "총 시도한 횟수: ";

    public void printGameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printBridgeLengthInputMessage() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
    }

    public void printBridgeSpaceInputMessage() {
        System.out.println(INPUT_SELECTED_BRIDGE_MESSAGE);
    }

    public void printRetryMessage() {
        System.out.println(INPUT_RETRY_COMMAND_MESSAGE);
    }

    public void printBridge(String bridge) {
        System.out.println(bridge);
    }

    public void printFinalResult(String resultBridge, SuccessFailure successFailure, int attempt) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println(resultBridge);
        System.out.println(SUCCESS_OR_FAILURE_MESSAGE + successFailure.getResult());
        System.out.println(TOTAL_ATTEMPT_COUNT + attempt);
    }

    public void printErrorMessage(IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }
}