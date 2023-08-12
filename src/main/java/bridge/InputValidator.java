package bridge;

public class InputValidator {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    public void validateBridgeSize(String bridgeSize){
        validateInputNumber(bridgeSize);
        int bridgeLength = Integer.parseInt(bridgeSize);
        if(bridgeLength < MIN_SIZE || bridgeLength > MAX_SIZE){
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getMessage());
        }
    }
    public void validateBridgeMoveStep(String bridgeMoveStep) {
        validateInputUpperEnglish(bridgeMoveStep);
        if (!bridgeMoveStep.equals(GameCommand.UP_BRIDGE.getCommand()) &&
                !bridgeMoveStep.equals(GameCommand.DOWN_BRIDGE.getCommand())){
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVE_STAGE.getMessage());
        }
    }

    public void validateBridgeStartCommand(String gameCommand) {
        validateInputUpperEnglish(gameCommand);
        if (!gameCommand.equals(GameCommand.RETRY.getCommand()) &&
                !gameCommand.equals(GameCommand.QUIT.getCommand())){
            throw new IllegalArgumentException(ErrorMessage.NOT_RETRY_COMMAND.getMessage());
        }
    }

    private void validateInputNumber(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_STRING.getMessage());
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("^[0-9]*$");  // 정규표현식을 사용하여 숫자 여부를 확인
    }

    private void validateInputUpperEnglish(String upperEnglish){
        if(!isUpperEnglish(upperEnglish)){
            throw  new IllegalArgumentException(ErrorMessage.NOT_UPPER_ENGLISH.getMessage());
        }
    }

    private boolean isUpperEnglish(String str) {
        return str.matches("^[A-Z]*$");
    }

}
