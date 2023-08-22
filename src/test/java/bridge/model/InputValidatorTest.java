package bridge.model;

import bridge.validator.InputValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    String ERROR_MESSAGE = "[ERROR]";
    InputValidator inputValidator = new InputValidator();

    @Test
    void movingCommandException() {
        String command = "A";

        assertThatThrownBy(() -> inputValidator.validateMoving(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void bridgeLengthException() {
        String command = "A";

        assertThatThrownBy(() -> inputValidator.validateIsNumber(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
