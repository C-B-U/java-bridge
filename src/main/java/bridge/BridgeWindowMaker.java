package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeWindowMaker {

    private static final int INIT_SIZE = 2;
    private static final int LENGTH_ONE = 1;

    private final List<BridgeWindowElement> upStair = new ArrayList<>();
    private final List<BridgeWindowElement> downStair = new ArrayList<>();

    public BridgeWindowMaker(){
        init();
    }

    private void init(){
        upStair.add(BridgeWindowElement.START);
        upStair.add(BridgeWindowElement.END);
        downStair.add(BridgeWindowElement.START);
        downStair.add(BridgeWindowElement.END);
    }

    public void reset() {
        upStair.clear();
        downStair.clear();
        init();
    }
    public void moveStair(String bridgeStair, boolean canMoveStage) {
        inputDivision();
        BridgeWindowElement windowElement = BridgeWindowElement.getStageWindowElement(canMoveStage);

        if (GameCommand.isBridgeStageCommandU(bridgeStair)) {
            upStair.add(getInsertMiddle(upStair), windowElement);
            downStair.add(getInsertMiddle(downStair), BridgeWindowElement.BLANK);
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeWindowElement.BLANK);
        downStair.add(getInsertMiddle(downStair), windowElement);
    }


    private void inputDivision(){
        if (upStair.size() == INIT_SIZE){
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeWindowElement.DIVISION);
        downStair.add(getInsertMiddle(downStair), BridgeWindowElement.DIVISION);
    }

    private int getInsertMiddle(List<BridgeWindowElement> stair){
        return stair.size() - LENGTH_ONE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        upStair.forEach(stringBuilder::append);
        stringBuilder.append("\n");
        downStair.forEach(stringBuilder::append);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
