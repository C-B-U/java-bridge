package bridge.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    void validateBridgeSizeBlank() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBridgeSizeCharacter() {
        assertThatThrownBy(() -> inputValidator.validateBridgeSize("s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateMoving() {
        assertThatThrownBy(() -> inputValidator.validateMoving("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateRetryCommand() {
        assertThatThrownBy(() -> inputValidator.validateRetryCommand("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
