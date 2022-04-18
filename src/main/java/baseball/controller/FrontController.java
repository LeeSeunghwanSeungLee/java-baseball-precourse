package baseball.controller;

import baseball.model.PlayResult;
import baseball.model.repository.PlayBallList;
import baseball.utils.RandomNumber;
import baseball.view.View;

import java.util.List;

public class FrontController {
    private static FrontController frontController = null;
    private PlayController playController;
    private PlayBallList computerBalls;


    private FrontController() {
        this.playController = PlayController.getInstance();
    }

    public synchronized static FrontController getInstance() {
        if (frontController == null)
            frontController = new FrontController();
        return frontController;
    }

    public void service() {
        makeComputerBalls();
        logic();
    }

//    public void reService(Exception e) {
//        View.showSubtitle(e.getMessage());
//        logic();
//    }

    public void logic() {
        PlayResult playResult;
        do {
            playResult = playController.playOnScreen(computerBalls);

        } while (playController.isWrongAnswer(playResult));

        if (playController.isRegame())
            service();
    }

    private void makeComputerBalls() {
        List<Integer> randomList = RandomNumber.make();
        this.computerBalls = new PlayBallList(randomList);
    }

}
