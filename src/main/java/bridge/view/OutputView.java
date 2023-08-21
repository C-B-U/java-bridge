package bridge.view;

import bridge.ProcessMessage;
import bridge.SuccessFailure;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(ProcessMessage.START_GAME_MESSAGE.getMessage());
    }

    public void printBridgeSizeInputMessage() {
        System.out.println(ProcessMessage.NEXT_LINE.getMessage() + ProcessMessage.INPUT_SIZE_MESSAGE.getMessage());
    }

    public void printSelectMovingMessage() {
        System.out.println(ProcessMessage.NEXT_LINE.getMessage() + ProcessMessage.SELECT_MOVING_MESSAGE.getMessage());
    }

    public void printRetryOrEndGameMessage() {
        System.out.println(ProcessMessage.NEXT_LINE.getMessage() + ProcessMessage.RETRY_OR_END_MESSAGE.getMessage());
    }

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printQuitMessage() {
        System.out.println(ProcessMessage.NEXT_LINE.getMessage() + ProcessMessage.FINAL_GAME_MESSAGE.getMessage());
    }

    public void printResult(boolean result, int attemptCount) {
        System.out.println(ProcessMessage.NEXT_LINE.getMessage() + ProcessMessage.SUCCESS_OR_NOT_MESSAGE.getMessage() + SuccessFailure.SUCCESS.equals(result));
        System.out.println(ProcessMessage.TOTAL_ATTEMPTS_MESSAGE.getMessage() + attemptCount);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

}