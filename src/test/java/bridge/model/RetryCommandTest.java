package bridge.model;

import bridge.constant.RetryCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RetryCommandTest {

    String ERROR_MESSAGE = "[ERROR]";

    @Test
    void getRetryCommand() {
        String command = "R";

        RetryCommand retryCommand = RetryCommand.getCommand(command);

        assertThat(retryCommand).isEqualTo(RetryCommand.RETRY);
    }

    @Test
    void getQuitCommand() {
        String command = "Q";

        RetryCommand retryCommand = RetryCommand.getCommand(command);

        assertThat(retryCommand).isEqualTo(RetryCommand.QUIT);
    }

    @Test
    void retryCommandException() {
        String command = "A";

        assertThatThrownBy(() -> RetryCommand.getCommand(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    void isRetryCommand() {
        RetryCommand retryCommand = RetryCommand.getCommand("R");

        boolean isRetry = retryCommand.isRetry();

        assertThat(isRetry).isTrue();
    }

    @Test
    void isNotRetryCommand() {
        RetryCommand retryCommand = RetryCommand.getCommand("Q");

        boolean isRetry = retryCommand.isRetry();

        assertThat(isRetry).isFalse();
    }
}
