package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BallsTest {
    @Test
    @DisplayName("볼, 스트라이크 몇개인지 검증")
    void playTest() {
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answer.play(Arrays.asList(4, 5, 6));

        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("볼, 스트라이크 검증, 오버로드한 play 메소드 테스트")
    void playTest2() {
        Balls answer = new Balls(Arrays.asList(1, 3, 5));
        BallScore result = answer.play(new Baseball(1, 3));

        assertThat(result).isEqualTo(BallScore.Ball);
    }

    @DisplayName("공 세개와 한개 비교하여 스트라이크 검증")
    @Test
    void playStrike(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallScore result = answers.play(new Baseball(1,1));
        assertThat(result).isEqualTo(BallScore.Strike);
    }

    @DisplayName("공 세개와 한개 비교하여 볼 검증")
    @Test
    void playBall(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallScore result = answers.play(new Baseball(1,2));
        assertThat(result).isEqualTo(BallScore.Ball);
    }

    @DisplayName("공 세개와 한개 비교하여 낫싱 검증")
    @Test
    void playNothing(){
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallScore result = answers.play(new Baseball(1,4));
        assertThat(result).isEqualTo(BallScore.Nothing);

        answers = new Balls(Arrays.asList(1,2,3));
        result = answers.play(new Baseball(2,4));
        assertThat(result).isEqualTo(BallScore.Nothing);
    }
}