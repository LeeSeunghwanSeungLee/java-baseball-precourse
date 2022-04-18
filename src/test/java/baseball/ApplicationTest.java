package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_완전종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "253", "936", "135", "935", "2");
                    assertThat(output()).contains("1볼", "1볼", "2스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                9, 3, 5
        );
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임종료_후_재시작1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "492", "294", "249", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "3볼", "2볼 1스트라이크", "게임 종료");
                },
                1, 3, 5, 2, 4, 9
        );
    }

    @Test
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("756", "231", "932", "1", "123", "2");
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
                },
                9,3, 2, 1, 2, 3
        );
    }

    @Test
    void 게임종료_후_완전종료1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("125", "987", "783", "2");
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                7, 8, 3
        );
    }
    @Test
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a22"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("334"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
