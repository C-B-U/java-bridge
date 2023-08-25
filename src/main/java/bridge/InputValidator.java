package bridge;


public class InputValidator {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String UPPER_ENGLISH_REGEX ="^[A-Z]*$";

    public void validateBridgeSize(String bridgeSize){
        validateInputNumber(bridgeSize);
        validateBridgeLength(bridgeSize);
    }

    public void validateBridgeStage(String bridgeStage) {
        validateInputUpperEnglish(bridgeStage);
        validateBridgeStageCommand(bridgeStage);
    }

    public void validateBridgeRetry(String retryCommand) {
        validateInputUpperEnglish(retryCommand);
        validateInputRetryCommand(retryCommand);
    }

    private void validateInputNumber(String number) {
        if (isNotNumeric(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isNotNumeric(String str) {
        return !str.matches(NUMBER_REGEX);
    }

    private void validateBridgeLength(String number) {
        int bridgeLength = Integer.parseInt(number);
        if(isNotBridgeLength(bridgeLength)){
            throw new IllegalArgumentException(String.format(ErrorMessage.BRIDGE_LENGTH_ERROR.getMessage(), MIN_SIZE, MAX_SIZE));
        }
    }

    private boolean isNotBridgeLength(int bridgeLength){
        return bridgeLength < MIN_SIZE || bridgeLength > MAX_SIZE;
    }

    private void validateInputUpperEnglish(String bridgeStage) {
        if (isNotUpperEnglish(bridgeStage)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_UPPER_ENGLISH_ERROR.getMessage());
        }
    }

    private boolean isNotUpperEnglish(String str){
        return !str.matches(UPPER_ENGLISH_REGEX);
    }

    private void validateBridgeStageCommand(String bridgeStage) {
        if(GameCommand.isNotBridgeStageCommand(bridgeStage)){
            throw new IllegalArgumentException(String.format(ErrorMessage.BRIDGE_STAGE_COMMAND_ERROR.getMessage()
                    , GameCommand.UP_STAIR, GameCommand.DOWN_STAIR));
        }
    }

    private void validateInputRetryCommand(String retryCommand) {
        if (GameCommand.isNotBridgeRetryCommand(retryCommand)){
            throw new IllegalArgumentException(String.format(ErrorMessage.BRIDGE_STAGE_COMMAND_ERROR.getMessage()
                    , GameCommand.BRIDGE_RETRY, GameCommand.BRIDGE_QUITE));
        }
    }
}
