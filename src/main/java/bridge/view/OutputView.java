package bridge.view;

import bridge.model.AnswerTable;
import bridge.model.GameStatus;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String NEW_LINE = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(AnswerTable answerTable) {
        printBridge(answerTable.getUpper());
        printBridge(answerTable.getLower());
        printNewLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(AnswerTable answerTable, GameStatus gameStatus) {
        System.out.println(OutputMessage.GAME_END_MESSAGE);
        printMap(answerTable);
        System.out.printf((OutputMessage.GAME_STATUS.toString()), gameStatus.getGameResult());
        System.out.printf(OutputMessage.RETRY_NUMBERS.toString(), gameStatus.getRetry());
    }

    public void printGameStart() {
        System.out.println(OutputMessage.START_MESSAGE);
        printNewLine();
    }

    public void printLengthMessage() {
        System.out.println(OutputMessage.LENGTH_MESSAGE);
    }
    public void printMoveLocation() {
        System.out.println(OutputMessage.MOVE_LOCATION);
    }

    public void printRetryMessage() {
        System.out.println(OutputMessage.RETRY_MESSAGE);
    }

    public void printBridge(List<String> bridge) {
        StringJoiner stringJoiner = new StringJoiner(BridgeElement.BRIDGE_DELIMITER.toString(), BridgeElement.BRIDGE_START.toString(), BridgeElement.BRIDGE_END.toString());
        bridge.forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }

    public void printNewLine() {
        System.out.println(NEW_LINE);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
