package baseball.controller;

import baseball.model.PlayResult;
import baseball.model.repository.PlayBallList;
import baseball.utils.InputHandler;
import baseball.utils.RandomNumber;
import baseball.view.View;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PlayController {

    private static PlayController playController = null;

    private PlayController() {}

    public synchronized static PlayController getInstance() {
        if (playController == null)
            playController = new PlayController();
        return playController;
    }
    public PlayResult playOnScreen(PlayBallList computerBalls) {
        View.EnterNumber.print();
        PlayResult result = playMain(computerBalls);
        View.showSubtitle(result.toString());
        return result;
    }

    private PlayResult playMain(PlayBallList computerBalls) {
        String input = Console.readLine();
        List<Integer> userBalls = InputHandler.getInstance().makeNumberList(input);
        return computerBalls.compareBallList(userBalls);
    }

    public boolean isWrongAnswer(PlayResult pr) {
        if (pr.isGameEnd()) {
            View.GameEnd.print();
            return false;
        }
        return true;
    }

    public boolean isRegame() {
        View.RestartGameOrQuit.print();
        String input = Console.readLine();
        if (InputHandler.getInstance().isRegame(input))
            return true;
        return false;
    }
}
