package bridge;

public class InputValidator {

    public void validateBridgeSize(String bridgeSize){
        validateInputNumber(bridgeSize);
        int brideSize = Integer.parseInt(bridgeSize);
        if(brideSize < 3 || brideSize > 20){
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3~20 사이의 숫자입니다.");
        }
    }
    public void validateBridgeMoveStep(String bridgeMoveStep) {
        validateInputUpperEnglish(bridgeMoveStep);
        if (!bridgeMoveStep.equals("U") && !bridgeMoveStep.equals("D")){
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 'U' 혹은 'D' 입니다.");
        }
    }

    public void validateBridgeStartCommand(String gameCommand) {
        validateInputUpperEnglish(gameCommand);
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 게임을 다시 시도할 명령어는 'R' 혹은 'Q' 입니다.");
        }
    }

    private void validateInputNumber(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException("[ERROR] 숫자로된 문자열이 아닙니다.");
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("^[0-9]*$");  // 정규표현식을 사용하여 숫자 여부를 확인
    }

    private void validateInputUpperEnglish(String upperEnglish){
        if(!isUpperEnglish(upperEnglish)){
            throw  new IllegalArgumentException("[ERROR] 대문자 영어가 아닙니다.");
        }
    }

    private boolean isUpperEnglish(String str) {
        return str.matches("^[A-Z]*$");
    }

}
