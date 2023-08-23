package bridge;


public class InputValidator {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public void validateBridgeSize(String bridgeSize){
        validateInputNumber(bridgeSize);
        validateBridgeLength(bridgeSize);
    }

    private void validateBridgeLength(String number) {
        int bridgeLength = Integer.parseInt(number);
        if(bridgeLength < MIN_SIZE || bridgeLength > MAX_SIZE){
            throw new IllegalArgumentException(String.format(ErrorMessage.BRIDGE_LENGTH_ERROR.getMessage(), MIN_SIZE, MAX_SIZE));
        }
    }

    private void validateInputNumber(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER_ERROR.getMessage());
        }
    }

    private boolean isNumeric(String str) {
        return str.matches(NUMBER_REGEX);
    }

}
