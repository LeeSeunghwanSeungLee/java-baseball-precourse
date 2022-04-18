package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BallScoreTest {
    @Test
    @DisplayName("간단한 Enum 클래스 테스트")
    void 이넘테스트() {
        assertThat(BallScore.Strike.isStrike()).isTrue();
        assertThat(BallScore.Ball.isStrike()).isFalse();
        assertThat(BallScore.Strike.getValue()).isEqualTo(2);
        assertThat(BallScore.Ball.getValue()).isEqualTo(1);
        assertThat(BallScore.Nothing.getValue()).isEqualTo(0);
    }
}