package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingValidatorTest {

    private static final InputValidator inputValidator = new InputValidator();
    @DisplayName("U 또는 D 외의 값을 입력하면 예외가 발생한다.")
    @Test
    void validateMoving() {
        assertThatThrownBy(() -> inputValidator.validateMoving("Q"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
