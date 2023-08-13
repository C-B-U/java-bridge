package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameCommandValidatorTest {

    private static final InputValidator inputValidator = new InputValidator();
    @DisplayName("R 또는 Q 외의 값을 입력하면 예외가 발생한다.")
    @Test
    void validateMoving() {
        assertThatThrownBy(() -> inputValidator.validateGameCommand("P"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
