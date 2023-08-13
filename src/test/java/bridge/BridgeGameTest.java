package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


public class BridgeGameTest extends NsTest {
    @Test
    void 실패_후_재시도() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Test
    void 실패_후_종료_1() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }

    @Test
    void 실패_후_종료_2() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }

    @Test
    void 실패_후_종료_3() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "Q");
            assertThat(output()).contains(
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
