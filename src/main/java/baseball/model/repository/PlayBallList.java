package baseball.model.repository;

import baseball.model.BallScore;
import baseball.model.Baseball;
import baseball.model.PlayResult;

import java.util.ArrayList;
import java.util.List;

public class PlayBallList {
    private List<Baseball> baseballList;
    private final int size = 3;

    public PlayBallList(List<Integer> answer) {
        createBalls(answer);
    }

    private void createBalls(List<Integer> answer) {
        baseballList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            baseballList.add(new Baseball(i + 1, answer.get(i))); // input -> position, number
        }
    }

    public BallScore play(Baseball ball) {
        int statusNum = 0;
        for (int i = 0; i < size; i++) {
            statusNum += baseballList.get(i).compare(ball).getValue();
        }

        if (statusNum == BallScore.Nothing.getValue()) {
            return BallScore.Nothing;
        }
        return strikeOrBall(statusNum);
    }

    private BallScore strikeOrBall(int statusNum) {
        return statusNum == BallScore.Strike.getValue() ? BallScore.Strike : BallScore.Ball;
    }

    public PlayResult compareBallList(List<Integer> userBallNumber) {
        PlayBallList userBalls = new PlayBallList(userBallNumber);
        PlayResult result = new PlayResult();

        for (Baseball ball: baseballList) {
            BallScore score = userBalls.play(ball);
            result.updateReport(score);
        }
        return result;
    }
}
