package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayResultTest {
    @Test
    @DisplayName("scoreReport 메소드 테스트")
    void 스코어테스트() {
        // given
        PlayResult result = new PlayResult();

        // when
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Nothing);
        result.updateReport(BallScore.Strike);
        result.updateReport(BallScore.Strike);

        // then
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("scoreReport 메소드 테스트2")
    void 스코어테스트2() {
        // given
        PlayResult result = new PlayResult();

        // when
        result.updateReport(BallScore.Strike);
        result.updateReport(BallScore.Strike);
        result.updateReport(BallScore.Strike);
        result.updateReport(BallScore.Strike);

        // then
        assertThat(result.getStrike()).isEqualTo(4);
    }

    @Test
    @DisplayName("scoreReport 메소드 테스트")
    void 스코어테스트3() {
        // given
        PlayResult result = new PlayResult();

        // when
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Nothing);
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Strike);

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }
}