package bridge.input;

import bridge.validator.InputValidator;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MovingTest {
    private static final InputValidator inputValidator = new InputValidator();
    @DisplayName("이동할 칸에 대한 입력이 숫자이면 예외가 발생한다.")
    @Test
    void validateMovingIsString() {
        assertThatThrownBy(() -> inputValidator.validateMoving("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸에 대한 입력이 U, D 외의 문자이면 예외가 발생한다.")
    @Test
    void validateMovingIsUorD() {
        assertThatThrownBy(() -> inputValidator.validateMoving("H"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸에 대한 입력이 공백이면 예외가 발생한다.")
    @Test
    void validateMovingHasBlank() {
        assertThatThrownBy(() -> inputValidator.validateMoving(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸을 잘못 입력하면 재입력하도록 합니다.")
    @Test
    void inputMovingUntilRight() {
        String[] input = {"d", "2", "D"};
        for (String s : input) {
            System.setIn(new ByteArrayInputStream(s.getBytes()));
        }
        String moving = new InputView().readMoving();
        assertThat(moving).isEqualTo("D");
    }
}
