package bridge.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnswerTable {

    private final List<String> upper;
    private final List<String> lower;

    public AnswerTable() {
        this.upper = new ArrayList<>();
        this.lower = new ArrayList<>();
    }

    public void setAnswerTable(String userInput, boolean success) {
        setUpperCase(userInput, success);
        setLowerCase(userInput, success);
    }

    private void setUpperCase(String userInput, boolean success) {
        if(userInput.equals(Constant.UPPER_CHAR.toString())) {
            MovingResult correctMessage = calculateMovingResult(userInput, success);
            upper.add(correctMessage.getAnswer());
            lower.add(Constant.BLANK.toString());
        }
    }

    private void setLowerCase(String userInput, boolean success) {
        if(userInput.equals(Constant.LOWER_CHAR.toString())) {
            MovingResult correctMessage = calculateMovingResult(userInput, success);
            lower.add(correctMessage.getAnswer());
            upper.add(Constant.BLANK.toString());
        }
    }

    private MovingResult calculateMovingResult(String userInput, boolean success) {
        return Arrays.stream(MovingResult.values())
                .filter(movingResult -> movingResult.getInput().equals(userInput))
                .filter(movingResult -> movingResult.getSuccess() == success)
                .findAny()
                .orElse(null);
    }

    public List<String> getUpper() {
        return upper;
    }

    public List<String> getLower() {
        return lower;
    }

    public void clear() {
        upper.clear();
        lower.clear();
    }
}
