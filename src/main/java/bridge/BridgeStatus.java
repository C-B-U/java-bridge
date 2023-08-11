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
        downStair.add(BridgeWindow.START);
    }

    public void reset() {
        upStair.clear();
        downStair.clear();
        init();
    }

    public void successStair(String bridgeMoveStep) {
        if (bridgeMoveStep.equals("U")){
            upStair.add(BridgeWindow.SUCCESS);
            inputDivisionOrEnd(upStair);
            downStair.add(BridgeWindow.BLANK);
            inputDivisionOrEnd(downStair);
        }
        upStair.add(BridgeWindow.BLANK);
        inputDivisionOrEnd(upStair);
        downStair.add(BridgeWindow.SUCCESS);
        inputDivisionOrEnd(downStair);
    }

    public void failStair(String bridgeMoveStep) {
        if (bridgeMoveStep.equals("U")){
            upStair.add(BridgeWindow.FAIL);
            inputDivisionOrEnd(upStair);
            downStair.add(BridgeWindow.BLANK);
            inputDivisionOrEnd(downStair);
        }
        upStair.add(BridgeWindow.BLANK);
        inputDivisionOrEnd(upStair);
        downStair.add(BridgeWindow.FAIL);
        inputDivisionOrEnd(downStair);
    }

    private void inputDivisionOrEnd(List<BridgeWindow> stair){
        if (stair.contains(BridgeWindow.END)){
            stair.remove(stair.size()-1);
            stair.add(BridgeWindow.DIVISION);
        }
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

