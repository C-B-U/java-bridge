package bridge.input;

import bridge.validator.InputValidator;
import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CommandTest {
    private static final InputValidator inputValidator = new InputValidator();
    @DisplayName("재시작 여부에 대한 입력이 숫자이면 예외가 발생한다.")
    @Test
    void validateMovingIsString() {
        assertThatThrownBy(() -> inputValidator.validateRetryCommand("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부에 대한 입력이 U, D 외의 문자이면 예외가 발생한다.")
    @Test
    void validateMovingIsUorD() {
        assertThatThrownBy(() -> inputValidator.validateRetryCommand("H"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부에 대한 입력이 공백이면 예외가 발생한다.")
    @Test
    void validateMovingHasBlank() {
        assertThatThrownBy(() -> inputValidator.validateRetryCommand(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부를 잘못 입력하면 재입력하도록 합니다.")
    @Test
    void inputCommandUntilRight() {
        String[] input = {"s", "1", "R"};
        for (String s : input) {
            System.setIn(new ByteArrayInputStream(s.getBytes()));
        }
        String command = new InputView().readGameCommand();
        assertThat(command).isEqualTo("R");
    }
}
