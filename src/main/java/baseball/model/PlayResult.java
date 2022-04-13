package baseball.model;

public class PlayResult {

    private int strike;
    private int ball;

    public PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void updateReport(BallScore ballScore) {
        if (ballScore.isStrike()) {
            this.strike++;
        }

        else if(ballScore.isBall()) {
            this.ball++;
        }
    }
}
