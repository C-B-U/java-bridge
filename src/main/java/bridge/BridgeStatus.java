package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {

    private static final int INIT_SIZE = 2;
    private static final int LENGTH_ONE = 1;

    private final List<BridgeWindow> upStair = new ArrayList<>();
    private final List<BridgeWindow> downStair = new ArrayList<>();

    BridgeStatus(){
        init();
    }

    private void init(){
        upStair.add(BridgeWindow.START);
        upStair.add(BridgeWindow.END);
        downStair.add(BridgeWindow.START);
        downStair.add(BridgeWindow.END);

    }

    public void reset() {
        upStair.clear();
        downStair.clear();
        init();
    }

    public void successStair(String bridgeMoveStep) {
        inputDivision();
        if (bridgeMoveStep.equals("U")){
            upStair.add(getInsertMiddle(upStair), BridgeWindow.SUCCESS);
            downStair.add(getInsertMiddle(downStair), BridgeWindow.BLANK);
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeWindow.BLANK);
        downStair.add(getInsertMiddle(downStair) , BridgeWindow.SUCCESS);
    }

    public void failStair(String bridgeMoveStep) {
        inputDivision();
        if (bridgeMoveStep.equals("U")){
            upStair.add(getInsertMiddle(upStair), BridgeWindow.FAIL);
            downStair.add(getInsertMiddle(downStair), BridgeWindow.BLANK);
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeWindow.BLANK);
        downStair.add(getInsertMiddle(downStair), BridgeWindow.FAIL);
    }

    private void inputDivision(){
        if (upStair.size() == INIT_SIZE){
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeWindow.DIVISION);
        downStair.add(getInsertMiddle(downStair), BridgeWindow.DIVISION);
    }

    private int getInsertMiddle(List<BridgeWindow> stair){
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

