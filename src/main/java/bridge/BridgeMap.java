package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private static final int INIT_SIZE = 2;
    private static final int LENGTH_ONE = 1;

    private final List<BridgeMapElement> upStair = new ArrayList<>();
    private final List<BridgeMapElement> downStair = new ArrayList<>();

    public BridgeMap(){
        init();
    }

    private void init(){
        upStair.add(BridgeMapElement.START);
        upStair.add(BridgeMapElement.END);
        downStair.add(BridgeMapElement.START);
        downStair.add(BridgeMapElement.END);
    }

    public void reset() {
        upStair.clear();
        downStair.clear();
        init();
    }
    public void moveStair(String bridgeStair, boolean canMoveStage) {
        inputDivision();
        BridgeMapElement windowElement = BridgeMapElement.getStageWindowElement(canMoveStage);

        if (GameCommand.isBridgeStageCommandU(bridgeStair)) {
            upStair.add(getInsertMiddle(upStair), windowElement);
            downStair.add(getInsertMiddle(downStair), BridgeMapElement.BLANK);
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeMapElement.BLANK);
        downStair.add(getInsertMiddle(downStair), windowElement);
    }


    private void inputDivision(){
        if (upStair.size() == INIT_SIZE){
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeMapElement.DIVISION);
        downStair.add(getInsertMiddle(downStair), BridgeMapElement.DIVISION);
    }

    private int getInsertMiddle(List<BridgeMapElement> stair){
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
