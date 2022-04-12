package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseballTest {

    @Test
    @DisplayName("숫자 1 ~ 9 까지 검증")
    void 숫자범위테스트() {
        // given
        Baseball okayBall = new Baseball(1, 9);
        Baseball numberUnderErrorBall = new Baseball(2, 0);
        Baseball numberUpperErrorBall = new Baseball(3, 10);

        // then
        assertThat(okayBall.isValid()).isTrue();

        assertThat(numberUnderErrorBall.isValid()).isFalse();

        assertThat(numberUpperErrorBall.isValid()).isFalse();
    }
}