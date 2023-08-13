package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeLengthInputMessage() {
        System.out.println("\n다리의 길이를 입력해주세요.");
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    public void printBridgeSpaceInputMessage() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printRetryMessage() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
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