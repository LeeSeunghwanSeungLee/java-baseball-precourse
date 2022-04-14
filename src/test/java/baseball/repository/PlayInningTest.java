package baseball.repository;

import baseball.model.BallScore;
import baseball.model.Baseball;
import baseball.model.PlayResult;
import baseball.repository.PlayInning;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class PlayInningTest {
    @Test
    @DisplayName("볼, 스트라이크 몇개인지 검증")
    void playTest() {
        PlayInning answer = new PlayInning(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(4, 5, 6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼, 스트라이크 검증, 오버로드한 play 메소드 테스트")
    void playTest2() {
        PlayInning answer = new PlayInning(Arrays.asList(1, 3, 5));
        BallScore result = answer.play(new Baseball(1, 3));

        assertThat(result).isEqualTo(BallScore.Ball);
    }

    @DisplayName("공 세개와 한개 비교하여 스트라이크 검증")
    @Test
    void playStrike() {
        PlayInning answers = new PlayInning(Arrays.asList(1,2,3));
        BallScore result = answers.play(new Baseball(1,1));
        assertThat(result).isEqualTo(BallScore.Strike);
    }

    @DisplayName("공 세개와 한개 비교하여 볼 검증")
    @Test
    void playBall() {
        PlayInning answers = new PlayInning(Arrays.asList(1,2,3));
        BallScore result = answers.play(new Baseball(1,2));
        assertThat(result).isEqualTo(BallScore.Ball);
    }

    @DisplayName("공 세개와 한개 비교하여 낫싱 검증")
    @Test
    void playNothing() {
        PlayInning answers = new PlayInning(Arrays.asList(1,2,3));
        BallScore result = answers.play(new Baseball(1,4));
        assertThat(result).isEqualTo(BallScore.Nothing);

        answers = new PlayInning(Arrays.asList(1,2,3));
        result = answers.play(new Baseball(2,4));
        assertThat(result).isEqualTo(BallScore.Nothing);
    }

    @DisplayName("낫싱 검증")
    @Test
    void playNothingOfThreeBall() {
        PlayInning answer = new PlayInning(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(7, 5, 6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @DisplayName("1스트라이크 1볼 테스트")
    @Test
    void oneStrikeOneBall() {
        PlayInning answer = new PlayInning(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(3, 2, 9));

        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @DisplayName("3 스트라이크 테스트")
    @Test
    void threeStrike() {
        PlayInning answer = new PlayInning(Arrays.asList(7, 2, 3));
        PlayResult result = answer.play(Arrays.asList(7, 2, 3));

        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }
}