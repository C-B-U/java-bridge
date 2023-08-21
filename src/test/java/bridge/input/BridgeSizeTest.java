package bridge.input;

import bridge.validator.InputValidator;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgeSizeTest {
    private static final InputValidator inputValidator = new InputValidator();
    @DisplayName("다리 길이가 3 미만이면 예외가 발생한다.")
    @Test
    void validateNumberLessThan3() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 20 초과면 예외가 발생한다.")
    @Test
    void validateNumberMoreThan20() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 문자연 예외가 발생한다.")
    @Test
    void validateNumberIsNumber() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("asdf"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 공백이면 예외가 발생한다.")
    @Test
    void validateNumberIsOnlyBlank() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 공백을 포함하면 예외가 발생한다.")
    @Test
    void validateNumberHasBlank() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(" 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이를 잘못 입력하면 재입력하도록 합니다.")
    @Test
    void inputSizeUntilRight() {
        String[] input = {"100", "five", "10"};
        for (String s : input) {
            System.setIn(new ByteArrayInputStream(s.getBytes()));
        }
        int size = new InputView().readBridgeSize();
        assertThat(size).isEqualTo(10);
    }
}
