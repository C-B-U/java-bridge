package bridge;

public class InputValidator {

    public void validateBridgeSize(String bridgeSize){
        int brideSize = Integer.parseInt(bridgeSize);
        if(brideSize < 3 || brideSize > 20){
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3~20 사이의 숫자입니다.");
        }
    }

            public void validateBridgeMoveStep(String bridgeMoveStep) {
        if (!bridgeMoveStep.equals("U") && !bridgeMoveStep.equals("D")){
            throw new IllegalArgumentException("[Error] 이동할 칸은 'U' 혹은 'D' 입니다.");
        }
    }
}
