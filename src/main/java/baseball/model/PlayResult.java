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

    @Override
    public String toString() {
        if (isNothing())
            return "낫싱"; /// TODO -> constant 변경

        if (isZeroBall())
            return strike + "스트라이크"; // TODO -> constant 변경

        if (isZeroStrike())
            return ball + "볼"; // TODO -> constant 변경

        return ball + "볼 " + strike + "스트라이크";
    }

    public boolean isGameEnd() {
        return strike == 3; // TODO -> constant 변경
    }

    private boolean isNothing() {
        if (ball == 0 && strike == 0)
            return true;

        return false;
    }

    private boolean isZeroStrike() {
        if (strike == 0)
            return true;

        return false;
    }

    private boolean isZeroBall() {
        if (ball == 0)
            return true;

        return false;
    }
}
