package bridge;

import static bridge.Keyword.*;

public class BridgeDrawing {
    private static final String OPEN_BRACKET = "[ ";
    private static final String CLOSE_BRACKET = " ]";
    private static final String DIVISION = "| ";
    private static final String NEXT_LINE = "\n";
    private static final String SUCCESS = "O";
    private static final String FAILURE = "X";
    private static final String BLANK = " ";
    private final StringBuilder upBridge;
    private final StringBuilder downBridge;

    public BridgeDrawing() {
        this.upBridge = new StringBuilder(OPEN_BRACKET);
        this.downBridge = new StringBuilder(OPEN_BRACKET);
    }

    public String getResultBridge() {
        return upBridge + NEXT_LINE + downBridge;
    }

    public String draw(MovingResult movingResult) {
        if (upBridge.length() > 3) {
            upBridge.deleteCharAt(upBridge.length() - 1);
            downBridge.deleteCharAt(downBridge.length() - 1);
            upBridge.append(DIVISION);
            downBridge.append(DIVISION);
        }
        checkUpBridgeOrDownBridge(movingResult);
        upBridge.append(CLOSE_BRACKET);
        downBridge.append(CLOSE_BRACKET);
        return upBridge + NEXT_LINE + downBridge;
    }

    private void checkUpBridgeOrDownBridge(MovingResult movingResult) {
        if (movingResult.getDirection().equals(UP.getKey())) {
            drawUpBridge(movingResult);
        }
        else {
            drawDownBridge(movingResult);
        }
    }

    private void drawUpBridge(MovingResult movingResult) {
        if (movingResult.getAnswer()) {
            upBridge.append(SUCCESS);
        }
        else {
            upBridge.append(FAILURE);
        }
        downBridge.append(BLANK);
    }

    private void drawDownBridge(MovingResult movingResult) {
        if (movingResult.getAnswer()) {
            downBridge.append(SUCCESS);
        }
        else {
            downBridge.append(FAILURE);
        }
        upBridge.append(BLANK);
    }
}
