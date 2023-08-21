package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest extends NsTest {

    @Test
    void 성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "U", "U");
            assertThat(output()).contains(
                    "[   | O | O ]",
                    "[ O |   |   ]",
                    "최종 게임 결과",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
        }, 0, 1, 1);
    }

    @Test
    void 실패_후_성공_테스트() {
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
    void 실패_후_실패_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "D","Q");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "최종 게임 결과",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Test
    void 실패_실패_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "R", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "최종 게임 결과",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );
        }, 1, 0, 1);
    }

    @Test
    void 실패_후_종료_테스트() {
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
