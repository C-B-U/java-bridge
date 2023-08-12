package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {

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
        if (upStair.size() == 2){
            return;
        }
        upStair.add(getInsertMiddle(upStair), BridgeWindow.DIVISION);
        downStair.add(getInsertMiddle(downStair), BridgeWindow.DIVISION);
    }

    private int getInsertMiddle(List<BridgeWindow> stair){
        return stair.size() - 1;
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

