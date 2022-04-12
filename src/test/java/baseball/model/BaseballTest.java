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

    @Test
    @DisplayName("Strike 검증")
    void 스트라이크테스트() {
        // given
        Baseball answer = new Baseball(1, 5);
        Baseball checkRight  = new Baseball(1, 5);
        Baseball checkWrong_1 = new Baseball(2, 5);
        Baseball checkWrong_2 = new Baseball(1, 9);

        // when
        BallScore right = answer.compare(checkRight);
        BallScore wrong_1 = answer.compare(checkWrong_1);
        BallScore wrong_2 = answer.compare(checkWrong_2);

        // then
        assertThat(right).isEqualTo(BallScore.Strike);
        assertThat(wrong_1).isNotEqualTo(BallScore.Strike);
        assertThat(wrong_2).isNotEqualTo(BallScore.Strike);
    }

    @Test
    @DisplayName("Ball 테스트")
    void 볼테스트() {
        // given
        Baseball answer = new Baseball(1, 2);
        Baseball check = new Baseball(2, 2);

        // when
        BallScore score = answer.compare(check);
        // then
        assertThat(score).isEqualTo(BallScore.Ball);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void 나싱테스트() {
        // given
        Baseball answer = new Baseball(1, 5);
        Baseball checkWrong_0  = new Baseball(2, 1);
        Baseball checkWrong_1 = new Baseball(3, 8);
        Baseball checkWrong_2 = new Baseball(5, 2);
        Baseball checkBall = new Baseball(3, 5);

        // when
        BallScore wrong_0 = answer.compare(checkWrong_0);
        BallScore wrong_1 = answer.compare(checkWrong_1);
        BallScore wrong_2 = answer.compare(checkWrong_2);
        BallScore ball = answer.compare(checkBall);

        // then
        assertThat(wrong_0).isEqualTo(BallScore.Nothing);
        assertThat(wrong_1).isEqualTo(BallScore.Nothing);
        assertThat(wrong_2).isEqualTo(BallScore.Nothing);

        assertThat(ball).isNotEqualTo(BallScore.Nothing);
    }
}