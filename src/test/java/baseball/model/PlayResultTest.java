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
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Strike);

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("toString() 메소드 테스트")
    void 문자열반환() {
        // given
        PlayResult result = new PlayResult();

        // when
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Strike);

        // then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.toString()).isEqualTo("1스트라이크 2볼");
    }

    @Test
    @DisplayName("toString() 메소드 테스트")
    void 문자열반환2() {
        // given
        PlayResult result = new PlayResult();

        // when
        result.updateReport(BallScore.Strike);
        result.updateReport(BallScore.Strike);
        result.updateReport(BallScore.Strike);

        // then
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("toString() 메소드 테스트")
    void 문자열반환3() {
        // given
        PlayResult result = new PlayResult();

        // when
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Ball);
        result.updateReport(BallScore.Ball);

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
        assertThat(result.toString()).isEqualTo("3볼");
    }
}