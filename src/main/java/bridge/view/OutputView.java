package bridge.view;

import bridge.constant.OutputMessage;
import bridge.domain.BridgeMaps;
import bridge.domain.GameRecorder;
import bridge.domain.RetryCount;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeMaps bridgeMaps) {
        System.out.println(bridgeMaps.toString());
        printEmpty();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameRecorder gameRecorder, RetryCount tryCount) {
        System.out.printf((OutputMessage.GAME_STATUS.toString()), gameRecorder.getGameClearMessage());
        System.out.printf(OutputMessage.RETRY_NUMBERS.toString(), tryCount.getRetryCount());
    }

    public void printEndMessage() {
        System.out.println(OutputMessage.GAME_END_MESSAGE);
    }

    public void printGameStart() {
        System.out.println(OutputMessage.START_MESSAGE);
        printEmpty();
    }

    public void printLengthMessage() {
        System.out.println(OutputMessage.LENGTH_MESSAGE);
    }

    public void printMovingDirectionMessage() {
        System.out.println(OutputMessage.MOVE_LOCATION);
    }

    public void printRetryMessage() {
        System.out.println(OutputMessage.RETRY_MESSAGE);
    }

    public void printEmpty() {
        System.out.println();
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
        printEmpty();
    }
}
