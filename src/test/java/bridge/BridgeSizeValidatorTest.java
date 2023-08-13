package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeSizeValidatorTest {

    private static final InputValidator inputValidator = new InputValidator();
    @DisplayName("다리 길이가 3이하이면 예외가 발생한다.")
    @Test
    void validateBridgeSize_1() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 20이상이면 예외가 발생한다.")
    @Test
    void validateBridgeSize_2() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("23"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이에 문자가 포함되면 예외가 발생한다.")
    @Test
    void validateBridgeIsDigit_1() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("123a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 문자이면 예외가 발생한다.")
    @Test
    void validateBridgeIsDigit_2() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
