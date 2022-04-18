package baseball.model;

import baseball.config.BaseballConfig;
import baseball.config.ResultMessageConfig;

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
            return ResultMessageConfig.Nothing.getState();

        if (isZeroBall())
            return strike + ResultMessageConfig.Strike.getState();

        if (isZeroStrike())
            return ball + ResultMessageConfig.Ball.getState();

        return ball + ResultMessageConfig.Ball.getState() + " " + strike + ResultMessageConfig.Strike.getState();
    }

    public boolean isGameEnd() {
        return strike == BaseballConfig.BaseballSize.getConfigInt();
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
